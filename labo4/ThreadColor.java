package labo4;

import javax.swing.*;

public class ThreadColor extends Thread
{
    Ball ball;
   public ThreadColor(Ball ball)
   {
       super("carnaval");
       this.ball=ball;
   }
   public void run()
   {
       while(true)
       {
           ball.colorChange();
           try
           {
               sleep(1);
           }catch(Exception exception)
           {
               JOptionPane.showMessageDialog(null,"there was something wrong with the sleep fonction","all-nighter",JOptionPane.ERROR_MESSAGE);
           }
       }
   }
}
