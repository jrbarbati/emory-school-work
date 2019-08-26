//Joseph Barbati - jdbarba
//Section 004
//worked by myself, no outside sources beyond what clues I may have gathered
//from piazza

import java.awt.*;
import javax.swing.*;


/**
 * Image manipulating program.
 * <P>
 * This program allows the you to display images (gif or jpg, or anything
 * supported by Java). Images are specified using a file dialog, but a simple
 * modification would allow the user to use an http: URL (currently a file: URL
 * is used)
 * <P>
 * Current image processing is simple: reflect horizontally/vertically and
 * invert (change black-to-white or vice-versa, and do the right thing with
 * color pixels, e.g., red = 255 - red).
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 * @author Owen Astrachan (ola@cs.duke.edu)
 */
public class Main
{
    public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "Pixmap!";


    public static void main (String[] args)
    {
        // create container that will work with Window manager
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create GUI components
        PixmapCanvas canvas = new PixmapCanvas(frame);
        ButtonPanel commands = new ButtonPanel(canvas);
        // add commands to test here
        commands.add(new Reader());
        commands.add(new Writer());
        commands.add(new Negative());

		//TODO:
		/*Add new instatantiations of Expand, MirrorVertically, 
		MirrorHorizontally, and Blur Objects.  Copy the above pattern for the
		command to add a Negative Object */
        commands.add(new MirrorHorizontally());
        commands.add(new MirrorVertically());
        commands.add(new Expand());
        commands.add(new Blur());
        
        // add our container to Frame and show it
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.getContentPane().add(commands, BorderLayout.NORTH);
        frame.pack();
        // start the GUI
        frame.setVisible(true);
    }
}
