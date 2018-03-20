package labo5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrameListener implements ActionListener
{
    SecondaryFrame newFrame;
    public NewFrameListener(SecondaryFrame newFrame)
    {
        this.newFrame=newFrame;
    }
    public void actionPerformed(ActionEvent event)
    {
        newFrame.genWindow();
    }
}