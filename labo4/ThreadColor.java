package labo4;

import javax.swing.*;

public class ThreadColor extends Thread
{
    Snooker snooker;
   public ThreadColor(Snooker snooker)
   {
       super("carnaval");
       this.snooker=snooker;
   }
   public void run()
   {
       while(true)
       {
           for(Ball ball:snooker.getBalls()) ball.colorChange();
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
