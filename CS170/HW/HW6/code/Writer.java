/*
 * A button to write out the image. The image is forced to .jpg in Pixmap.java.
 *
 * @author Mac Mason (mac@cs.duke.edu)
 */


import javax.swing.JFileChooser;

public class Writer extends Command
{
	private static final JFileChooser ourChooser = new JFileChooser(".");
    public Writer()
    {
        super("Save Image");
    }
    
    public void execute (Pixmap target)
    {
    	String fileName = getFileName();
    	if (fileName != null)
    	{
    		target.write(fileName);
    	}
    }
    
    protected String getFileName()
    {
        int response = ourChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION)
        {
        	return ourChooser.getSelectedFile().getPath();
        }
        else
        {
        	return null;
        }
    }
}
