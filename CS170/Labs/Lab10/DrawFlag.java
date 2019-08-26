//Joseph Barbati - jdbarba
//Section 004

import java.awt.*;
import java.awt.image.*;

/* ========================================================
   Coordinate system of the Canvas:

           0    1       x#       400
           +----+--------+----------+
           |                        |  ^
         1 |                        |  |
           |                        |  |
           |                        |  |  height
      y#   |        (x#,y#)         |  |
           |                        |  |
           |                        |  |
       300 +------------------------+  v
            <----------------------> (400,300)
                    width

    Coordinate = (x#,y#)
   ======================================================== */


public class DrawFlag {

   static public void main(String[] args) {
      /* ======================================================
         This section of the program defines color values and
         makes a canvas variable (named 'pic') for drawing

         Do NOT change anything in this section
         ====================================================== */
      final int RED    = 0xFF0000;         // Color code for red
      final int GREEN  = 0x00FF00;         // Color code for green
      final int BLUE   = 0x0000FF;         // Color code for blue
      final int YELLOW = 0xFFFF00;         // Color code for yellow
      final int WHITE  = 0xFFFFFF;         // Color code for white
      final int BLACK  = 0x000000;         // Color code for black

      /* ------------------------------------------------
         Preparing to draw picture...
         ------------------------------------------------ */
      Frame f = new Frame( "My image" );    // Create a Frame

      MyCanvas pic = new MyCanvas(400,300); // Make a 400x300 canvas 
      f.add("Center", pic);                 // Put the canvas in the window

      f.setSize(400,330);                   // Set window size
      f.setVisible(true);                   // Make window visible 

      /* ====================================================
         You must complete the lab by doing the tasks below

         This program draws a picture of the Scottish flag
         ==================================================== */

      /* ------------------------------------------------------
         Define a 400x300 array of ints named 'pixel'

         This variable will contain the pixels (= color code)
         for the Scottish flag
         ------------------------------------------------------ */
      int[][] pixel = new int[400][300];

      /* ------------------------------------------------------
         variables for forming (x,y) corrdinate pairs
         ------------------------------------------------------ */
      int x, y;


      /* ==========================================================
         Try this:*/

//           for (int col = 0; col < 400; col++ )
//               pixel[col][100] = YELLOW;
      /* ========================================================== */


      /* ==========================================================
         TODO Part 1:

         Write a nested for-statement (a for-statement inside 
         a for-statement) to store the BLUE pixel color code
         in the rows 0 - 299 (x coordinate) and columns 0 - 399
         (y coordinate) of the variable 'pixel'

         After you have written this statement, test your program
         You should see a blue rectangle (the "background" of the flag).
         ========================================================== */
	     for (int row = 0; row < 300; row++) {
             for (int col = 0; col < 400; col++) {
                 pixel[col][row] = BLUE;
             }
         }
           

      /* ==========================================================
         TODO Part 2: draw a WHITE diagonal from upper left to lower right.

         Write a nested for-statement (a for-statement inside 
         a for-statement) to store the WHITE pixel color code
         in the variable 'pixel[col][row]' if:

                 -150 <= 3*col - 4*row <= 150

         After you have written this part, test you program.
         You should see a white diagonal running from the upper 
		   left to lower right of the flag.
         ========================================================== */
       for (int row = 0; row < 300; row++) {
           for (int col = 0; col < 400; col++) {
               if (3*col - 4*row <= 150 && 3*col - 4*row >= -150) {
                   pixel[col][row] = WHITE;
               }
           }
       }

      /* ==========================================================
         TODO Part 3: draw the other diagonal across

         Use the hint in the lab handout to write a nested
         for-statement that makes the other diagonal WHITE
         (It will be the same width as previous diagonal).
         ========================================================== */
       for (int row = 0; row < 300; row++) {
           for (int col = 0; col < 400; col++) {
               if (3*col + 4*row <= 1350 && 3*col + 4*row >= 1050) {
                   pixel[col][row] = WHITE;
               }
           }
       }


    /* ===============================================================
       DO NOT modify these statements (this draws the picture)
       =============================================================== */
       pic.draw( pixel );
       pic.repaint();   // Repaint the frame

       System.out.println();
       System.out.println("**** Type Control-C to exit !!! ****");
       System.out.println("** Hold the Control-key... and then type C !!! **");
       System.out.println();
       System.out.println();
   }
}

