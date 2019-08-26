import java.awt.*;
import javax.swing.*;


public class PixmapCanvas extends JPanel
{
    private JFrame myContainer;
    private Pixmap myPixmap;
    private String myTitle;


    public PixmapCanvas (JFrame container)
    {
        this(container, null);
    }

    public PixmapCanvas (JFrame container, String pixName)
    {
        setBorder(BorderFactory.createLoweredBevelBorder());
        myContainer = container;
        myPixmap = new Pixmap(pixName);
        refresh();
    }


    public Pixmap getPixmap ()
    {
        return myPixmap;
    }

    public void refresh ()
    {
        if (! myPixmap.getSize().equals(getSize()))
        {
            setSize(myPixmap.getSize());
            myContainer.setTitle(myPixmap.getName());
            myContainer.pack();
        }
        repaint();
    }

    public void paintComponent (Graphics pen)
    {
        super.paintComponent(pen);
        myPixmap.paint(pen);
    }


    public void setSize (Dimension size)
    {
        setPreferredSize(size);
        setMinimumSize(size);
        super.setSize(size);
    }
}