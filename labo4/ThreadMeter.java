package labo4;

import javax.swing.*;

public class ThreadMeter extends Thread
{
    PointsMeter meter;
    public ThreadMeter(PointsMeter meter)
    {
        super("je rafraichis mon paypal pour le zenith");
        this.meter=meter;
    }
    public void run()
    {
        while(true)
        {
            meter.repaint();
            try {
                sleep(10);
            }catch(Exception except)
            {
                JOptionPane.showMessageDialog(null,"error while sleeping","sleep error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
