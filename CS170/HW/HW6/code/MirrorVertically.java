import java.awt.Color;
import java.awt.Dimension;


public class MirrorVertically extends Command
{
    public MirrorVertically ()
    {
        super("Mirror Vertically");
    }


    public void execute (Pixmap target)
    {
        Dimension bounds = target.getSize();
        // TODO: mirror target image along vertical middle line by swapping
        //       each color on right with one on left
        
        //outer loop iterates over the rows of pixels
        //inner loop iterates over the first half of the columns of the pixels
        //and switches them with the corresponding columns on the opposite half
        //(pixel-by-pixel, not all the column at once to give the mirrored image
        //over a vertical axis
        
        for(int i = 1; i < (bounds.height - 1); i++) {
            for (int j = (bounds.width / 2); j > 0; j--) {
                Color temp = target.getColor(j, i);
                Color replaceNew = target.getColor((bounds.width - j),i);
                target.setColor(j, i, replaceNew);
                target.setColor((bounds.width - j), i,temp);
            } 
        }
    }
}