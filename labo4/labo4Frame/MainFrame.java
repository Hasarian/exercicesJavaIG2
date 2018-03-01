package labo4.labo4Frame;

import labo4.ButtonManager;
import labo4.PointsMeter;
import labo4.Snooker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Container mainContainer;
    public MainFrame(Snooker snooker)
    {
        super("Basic snooker");
        setBounds(100,100,1200,800);
        JSplitPane mainpanel=new JSplitPane();
        mainContainer=this.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.add(mainpanel,BorderLayout.CENTER);
        mainpanel.setDividerLocation(450);
        mainpanel.setDividerSize(0);
        mainpanel.setLeftComponent(snooker);
        mainpanel.setRightComponent(snooker.getCounter());

        mainContainer.add(new ButtonManager(snooker),BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
