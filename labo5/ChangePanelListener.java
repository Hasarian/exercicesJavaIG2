package labo5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePanelListener implements ActionListener
{
    JPanel newPanel;
    Container container;
    public ChangePanelListener(JPanel newPanel, Container container)
    {
        this.newPanel=newPanel;
        this.container=container;
    }
    public void actionPerformed(ActionEvent event)
    {
        container.removeAll();
        container.add(newPanel);
        container.revalidate();
    }
}
/*private class ChangePanelListener implements ActionListener
{
    JPanel newPanel;

    private ChangePanelListener(JPanel newPanel)
    {
        this.newPanel=newPanel;
    }
    public void actionPerformed(ActionEvent event)
    {
        container.removeAll();
        container.add(newPanel);
        container.revalidate();
    }
}*/
