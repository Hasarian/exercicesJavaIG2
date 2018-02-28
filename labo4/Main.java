package labo4;

import labo4.labo4Frame.MainFrame;

public class Main
{
    public static void main(String[] args)
    {
        Snooker snooker=new Snooker(300,600);
        new MainFrame(snooker,new PointsMeter(snooker));
    }
}
