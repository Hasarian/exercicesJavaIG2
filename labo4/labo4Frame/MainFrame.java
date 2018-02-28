package labo4.labo4Frame;

import labo4.PointsMeter;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Container mainContainer;
    public MainFrame(JPanel Snooker, PointsMeter pointsMeter)
    {
        super("Basic snooker");
        setBounds(100,100,1200,1200);
        mainContainer=this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(Snooker,BorderLayout.CENTER);
        mainContainer.add(pointsMeter,BorderLayout.EAST);
        setVisible(true);
    }

}
