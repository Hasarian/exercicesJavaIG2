package labo4;

import javax.swing.*;
import java.util.ArrayList;

public class ThreadMove extends Thread
{
    Snooker snooker;
    ArrayList<Ball> ballsToDelete;

    public ThreadMove(Snooker snooker)
    {
        super("the balls are moving");
        this.snooker=snooker;
        ballsToDelete=new ArrayList<Ball>();
    }
    public void run()
    {
        while(true)
        {
            for (Ball ball:snooker.getBalls())
            {
                ball.move();
                if(ball.toDelete())ballsToDelete.add(ball);
            }
            snooker.deleteBall(ballsToDelete);
            ballsToDelete.removeAll(ballsToDelete);
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
