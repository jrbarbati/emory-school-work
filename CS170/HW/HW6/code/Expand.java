import java.awt.Dimension;
import java.awt.Color;

public class Expand extends Command
{
    private static SizeInputDialog ourDialog = 
        new SizeInputDialog("Resize Scale Input",
                            " scale width by",
                            "scale height by");


    public Expand ()
    {
        super("Resize");
    }


    public void execute (Pixmap target)
    {
        ourDialog.show();
        Dimension scale = ourDialog.getSize();
        Dimension oldSize = target.getSize();
        target.setSize(oldSize.width * scale.width, oldSize.height * scale.height);
        Dimension newSize = target.getSize();

        // TODO: fill in enlarged pixmap by copying current colors into empty
        //       space so each takes up scale space in the new pixmap
        
        //I chose to not create a new pixmap, as you'll see.
        
        int i, j;
        
        /*outer loop iterates over each pixel, copies the Color and assigns it
          to the expanded image */
        
        for(i = oldSize.height - 1; i > -1; i--) {
            
            //if image is scaled 1x1, image remains unaltered
            
            if (scale.width == 1 && scale.height == 1) {
                break;
            }
            
            for (j = oldSize.width - 1; j > -1; j--) {
                Color temp = target.getColor(j, i);
                target.setColor(j*scale.width, i*scale.height, temp);
                
                int x = scale.width - 1;
                int y = scale.height - 1;
                
                if (scale.width > 1 && scale.height > 1) {
                    
                    /*inner nested-loop fills in gaps left behind by outer
                      nested-loop, only runs if both the x and y directions are
                      scaled by a number greater than 1 */
                    
                    for(y = scale.height - 1; y > 0; y--) {
                        for(x = scale.width - 1; x > 0; x--) {
                            target.setColor(j*scale.width + (scale.width - x),
                                            i*scale.height + (scale.height - y),
                                            temp);
                            target.setColor(j*scale.width + (scale.width - x),
                                            i*scale.height,
                                            temp);
                            target.setColor(j*scale.width,
                                            i*scale.height + (scale.height - y),
                                            temp);
                        }//ends inner for-loop (x)
                    }//ends outer for-loop (y)
                    
                } //ends conditional
                
                /*this code runs when only the x OR y is scaled to a different
                  number than 1.  Works like above inner nested-loop but in
                  EITHER the x OR the y direction */
                
                if (scale.width == 1 || scale.height == 1) {
                    
                    /*first loop works with a change in the height ONLY and
                      assigns the necessary color to pixels
                      i.e if the width is scaled by 1 and height scaled by a
                      number greater than 1 */
                    
                    while (y > 0) {
                        target.setColor(j*scale.width,
                                        i*scale.height + (scale.height - y),
                                        temp);
                        y--;
                    }
                    
                    /*second loop works with a change in the width ONLY and
                      assigns the necessary color to pixels
                      i.e if the height is scaled by 1 and width scaled by a
                      number greater than 1 */
                    
                    while(x > 0) {
                        target.setColor(j*scale.width + (scale.width - x),
                                        i*scale.height,
                                        temp);
                        x--;
                    }
                    
                }//ends second if-statement
            }//ends inner for-loop (j)
        }//ends outer for-loop (i)
    }//ends execute method
}//ends Expand class
