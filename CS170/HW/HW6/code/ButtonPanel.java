import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The collection of commands to apply to the active image.
 * 
 * @author Robert C Duvall
 */
public class ButtonPanel extends JPanel
{
    private PixmapCanvas myView;


    public ButtonPanel (PixmapCanvas view)
    {
        myView = view;
    }
    
    
    public void add (Command c)
    {
        add(new CommandButton(c, myView));
    }
    
    

    class CommandButton extends JButton
    {
        private PixmapCanvas myCanvas;
        private Command myCommand;


        public CommandButton (Command command, PixmapCanvas canvas)
        {
            super(command.getName());
            myCanvas = canvas;
            myCommand = command;

            // perform command when button is clicked
            addActionListener(new ActionListener()
                {
                    public void actionPerformed (ActionEvent e)
                    {
                        applyCommand();
                    }
                });
        }

        protected void applyCommand ()
        {
            Pixmap p = myCanvas.getPixmap();
            myCommand.execute(p);
            myCanvas.refresh();
        }
    }
}
