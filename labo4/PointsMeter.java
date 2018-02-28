package labo4;

import javax.swing.*;
import java.awt.*;

public class PointsMeter extends JPanel
{
    Snooker snooker;
    public PointsMeter(Snooker snooker)
    {
        this.snooker=snooker;
        ThreadMeter thread=new ThreadMeter(this);
        thread.start();
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawString("points:\n"+new Integer(snooker.getTotalPoints()).toString(),600,600);
    }
}