import java.awt.Color;
import java.awt.Dimension;


public class Blur extends Command
{
    private static SizeInputDialog ourDialog = 
        new SizeInputDialog("Choose Neighborhood Size",
                            "       width",
                            "      height");


    public Blur ()
    {
        super("Blur");
    }


    public void execute (Pixmap target)
    {
        ourDialog.show();
        Dimension neighborhood = ourDialog.getSize();
        Dimension bounds = target.getSize();

        // TODO: blur target pixmap by averaging each color 
        //       with its neighbors
        
        Pixmap targetCopy = new Pixmap(target);
        Dimension boundsCopy = targetCopy.getSize();
        
        
        /* outer nested for-loop runs through all the pixels that will be used 
           to blur the image */
        
        for(int i = neighborhood.height / 2 + 1;
            i < boundsCopy.height - (neighborhood.height / 2 + 1); i++)
        {
            for(int j = neighborhood.width / 2 + 1;
                j < boundsCopy.width - (neighborhood.width / 2 + 1); j++)
            {
                
                int a = i - (neighborhood.height / 2 + 1);
                int b = j - (neighborhood.width / 2 + 1);
                
                int totalRed = 0;
                int totalGreen = 0;
                int totalBlue = 0;
                int avgRed = 0;
                int avgGreen = 0;
                int avgBlue = 0;
                
                /* inner nested for-loop finds the average RGB values over all
                   the pixels in the neighborhood and sets that color to the 
                   corresponding pixel in target */
                
                for(int y = a; y < a + neighborhood.height; y++) {
                    for(int x = b; x < b + neighborhood.width; x++) {
                        
                        Color old = targetCopy.getColor(x, y);
                        totalRed += old.getRed();
                        totalGreen += old.getGreen();
                        totalBlue += old.getBlue();
                        
                    }
                }
                
                avgRed = totalRed/(neighborhood.width * neighborhood.height);
                avgGreen = totalGreen/(neighborhood.width * neighborhood.height);
                avgBlue = totalBlue/(neighborhood.width * neighborhood.height);
                target.setColor(j, i, new Color(avgRed, avgGreen, avgBlue));
                
            }
        }
    }
}
