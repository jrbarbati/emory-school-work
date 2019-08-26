import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SizeInputDialog extends JDialog implements ActionListener
{
    private JTextField myXScaleInput;
    private JTextField myYScaleInput;
    private Dimension myScales;


    public SizeInputDialog (String title, String prompt1, String prompt2)
    {
        setTitle(title);
        setModal(true);
        setSize(180, 120);

        JButton okButton = new JButton("ok");
        okButton.addActionListener(this);
        myXScaleInput = new JTextField("1", 6);
        myYScaleInput = new JTextField("1", 6);
        JPanel p = new JPanel();
        p.add(new JLabel(prompt1));
        p.add(myXScaleInput);
        p.add(new JLabel(prompt2));
        p.add(myYScaleInput);
        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(okButton, BorderLayout.SOUTH);

        myScales = new Dimension(2, 2);
    }

    public void actionPerformed (ActionEvent e)
    {
        myScales.setSize(Integer.parseInt(myXScaleInput.getText()),
                         Integer.parseInt(myYScaleInput.getText()));
        setVisible(false);
    }


    public Dimension getSize ()
    {
        return myScales;
    }
}
