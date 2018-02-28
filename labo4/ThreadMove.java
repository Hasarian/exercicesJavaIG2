package labo4;

import javax.swing.*;

public class ThreadMove extends Thread
{
    Snooker snooker;

    public ThreadMove(Snooker snooker)
    {
        super("the balls are moving");
        this.snooker=snooker;
    }
    public void run()
    {
        while(true)
        {
            snooker.getBall().move();
            snooker.repaint();
            try {
                sleep(10);
            }catch(Exception except)
            {
                JOptionPane.showMessageDialog(null,"error while sleeping","sleep error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
