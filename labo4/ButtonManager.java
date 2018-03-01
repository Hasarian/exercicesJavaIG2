package labo4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonManager extends JButton
{
    Snooker snooker;
    public Snooker getSnooker(){return snooker;}
    public ButtonManager(Snooker snooker)
    {
        super("add");
        this.snooker=snooker;
        this.addActionListener(new ClickListener(this));
    }

    private class ClickListener implements ActionListener
    {
        ButtonManager button;
        public void actionPerformed(ActionEvent e)
        {
            button.getSnooker().addBall();
        }
        public ClickListener(ButtonManager button)
        {
            this.button=button;
        }
    }
}
