import java.awt.Color;
import java.awt.Dimension;


public class MirrorHorizontally extends Command
{
    public MirrorHorizontally ()
    {
        super("Mirror Horizontally");
    }


    public void execute (Pixmap target)
    {
        Dimension bounds = target.getSize();
        //bounds.width
        //bounds.height
        // TODO: mirror target image along horizontal middle line by swapping
        //       each color on top with one on the bottom
        
        //inner loop iterates over the columns of pixels
        //outer loop iterates over the first half of the rows of the pixels
        //and switches them with the corresponding rows on the opposite half
        //(pixel-by-pixel, not all the row at once) to give the mirrored image
        //over a horizontal axis
        
        for(int i = (bounds.height / 2); i > 0; i--) {
            for (int j = 0; j < bounds.width ; j++) {
                Color temp = target.getColor(j, i);
                Color replaceNew = target.getColor(j, (bounds.height - i));
                target.setColor(j, i, replaceNew);
                target.setColor(j, (bounds.height - i), temp);
            }
        }
    }
}
