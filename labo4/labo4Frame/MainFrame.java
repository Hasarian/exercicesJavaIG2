package labo4.labo4Frame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Container mainContainer;
    public MainFrame(JPanel Snooker)
    {
        super("Basic snooker");
        setBounds(100,100,1200,1200);
        mainContainer=this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(Snooker,BorderLayout.CENTER);
        setVisible(true);
    }

}
