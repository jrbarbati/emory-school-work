import java.awt.Color;
import java.awt.Dimension;


public class Negative extends Command
{
    public static final int MAX_COLOR_LEVEL = 255;


    public Negative ()
    {
        super("Reverse Colors");
    }


    public void execute (Pixmap target)
    {
        // loop over each color in pixmap
        Dimension bounds = target.getSize();
        for (int x = 0; x < bounds.width; x++)
        {
            for (int y = 0; y < bounds.height; y++)
            {
                // invert
                Color old = target.getColor(x, y);
                target.setColor(x, y,
                    new Color(MAX_COLOR_LEVEL - old.getRed(),
                              MAX_COLOR_LEVEL - old.getGreen(),
                              MAX_COLOR_LEVEL - old.getBlue()));
            }
        }
    }
}