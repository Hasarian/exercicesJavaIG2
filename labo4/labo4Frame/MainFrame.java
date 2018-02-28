package labo4.labo4Frame;

import labo4.PointsMeter;
import labo4.Snooker;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private Container mainContainer;
    public MainFrame(Snooker snooker)
    {
        super("Basic snooker");
        setBounds(100,100,1200,1200);
        JSplitPane mainpanel=new JSplitPane();
        mainContainer=this.getContentPane();
        mainContainer.add(mainpanel);
        mainpanel.setDividerLocation(700);
        mainpanel.setDividerSize(0);
        mainpanel.setLeftComponent(snooker);
        mainpanel.setRightComponent(snooker.getCounter());
        //new PointFrame(pointsMeter);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /*private class PointFrame extends JFrame
    {
        Container pointContainer;

        public PointFrame(PointsMeter counter)
        {
            super("points du \"billard\"");
            setBounds(300,300,200,200);
            pointContainer=this.getContentPane();
            pointContainer.add(counter);
            setVisible(true);
        }
    }*/


}
