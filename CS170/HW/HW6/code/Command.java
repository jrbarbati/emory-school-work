/**
 * An abstract command class that operates on Pixmaps
 * 
 * @author Robert C Duvall
 */
public abstract class Command
{
    private String myName;


    public Command (String name)
    {
        myName = name;
    }

    /**
     * Returns the name of this command 
     * (displayed on the button used to activate it)
     */
    public String getName ()
    {
        return myName;
    }


    /**
     * Subclasses determine how to update the given Pixmap
     */
    public abstract void execute (Pixmap target);
}