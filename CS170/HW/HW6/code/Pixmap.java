import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


/**
 * Class for manipulating graphics images originally developed in C++ revision
 * history for C++ version
 * <P>
 * Modified: 3/21/94 11/29/94 4/13/95
 * <P>
 * Ported: 10/16/1996 to Java (Syam Gadde) re-implemented, ported to 1.1 6/1/97
 * (Owen Astrachan)
 * <P>
 * 
 * this class represents an image that supports manipulation, i.e., reflection,
 * expansion, inversion, etc. It has an analog in C++ for comparison between the
 * two languages although there is more support in Java for images than there is
 * in C++.
 * <P>
 * 
 * Creating a pixmap requires a filename that should be a gif or jpg image (or
 * others if getImage() supports them). Currently the filename represents a
 * local image, but changing the URL to support network retrievable images
 * should be straightforward
 * 
 * @author Owen Astrachan
 * @author Syam Gadde
 */
public class Pixmap
{
    public static final Dimension DEFAULT_SIZE = new Dimension(300, 300);
    public static final Color DEFAULT_COLOR = Color.BLACK;
    public static final String DEFAULT_NAME = "Default";

    public static final String FILE_OUTPUT_FORMAT = "jpeg";  // force file writing in .jpg format

    private String myFileName;
    private BufferedImage myImage;
    private Dimension mySize;


    /**
     * Create a default pixmap (300x300 black)
     */
    public Pixmap ()
    {
        this(DEFAULT_SIZE.width, DEFAULT_SIZE.height, DEFAULT_COLOR);
    }

    /**
     * Create a black pixmap with given width and height
     */
    public Pixmap (int width, int height)
    {
        this(width, height, DEFAULT_COLOR);
    }

    /**
     * Create a pixmap with given width and height and filled with given initial color
     */
    public Pixmap (int width, int height, Color color)
    {
        createImage(width, height, color);
    }

    /**
     * Create this image as a copy of the given image
     */
    public Pixmap (Pixmap other)
    {
        myFileName = other.myFileName;
        mySize = other.getSize();
        myImage = copyImage(mySize, mySize, other.myImage);
    }

    /**
     * Create a pixmap from the given local file
     * @param filename complete pathname of local file
     */
    public Pixmap (String fileName)
    {
        if (fileName == null)
        {
            createImage(DEFAULT_SIZE.width, DEFAULT_SIZE.height, DEFAULT_COLOR);
        }
        else
        {
            read(fileName);
        }
    }


    public String getName ()
    {
        int index = myFileName.lastIndexOf(File.separator);
        if (index >= 0) return myFileName.substring(index + 1);
        else            return myFileName;
    }

    public Dimension getSize ()
    {
        return new Dimension(mySize);
    }

    public Color getColor (int x, int y)
    {
        return new Color(myImage.getRGB(x, y));
    }


    public void setColor (int x, int y, Color value)
    {
        myImage.setRGB(x, y, value.getRGB());
    }

    public void setSize (int width, int height)
    {
        if (width != mySize.width || height != mySize.height)
        {
            Dimension newSize = new Dimension(width, height);
            if (width > mySize.width || height > mySize.height)
            {
                myImage = copyImage(mySize, newSize, myImage);
            }
            else
            {
                // BUGBUG: scale image down instead?
                myImage = myImage.getSubimage(0, 0, width, height);
            }
            mySize = newSize;
        }
    }

    public void read (String fileName)
    {
        try
        {
            myFileName = fileName;
            myImage = ImageIO.read(new File(myFileName));
            mySize = new Dimension(myImage.getWidth(), myImage.getHeight());
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public void write(String fileName)
    {
    	try
    	{
            ImageIO.write(myImage, FILE_OUTPUT_FORMAT, new File(fileName));
    	}
    	catch (IOException e)
    	{
            System.out.println(e);
    	}
    }

    public void paint (Graphics pen)
    {
        pen.drawImage(myImage, 0, 0, mySize.width, mySize.height, null);
    }


    private void createImage (int width, int height, Color color)
    {
        myFileName = DEFAULT_NAME;
        myImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        mySize = new Dimension(width, height);
    }

    private BufferedImage copyImage (Dimension from, Dimension to, BufferedImage original)
    {
        int[] data = new int[from.width * from.height];
        original.getRGB(0, 0, from.width, from.height, data, 0, from.width);

        BufferedImage result = new BufferedImage(to.width, to.height, BufferedImage.TYPE_INT_RGB);
        result.setRGB(0, 0, from.width, from.height, data, 0, from.width);
        return result;
    }


    public static void main (String[] args)
    {
        Pixmap p = new Pixmap(200, 100);
        p.setSize(400, 200);
        p.setSize(400, 200);
        p.setSize(200, 400);
    }
}
