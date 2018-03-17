package labo5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel
{
    private int divider;
    private NorthPanel topPanel;
    private CenterPanel midPanel;
    private Container container;

    public MainPanel(int divider,Container container)
    {
        this.container=container;
       this.divider=divider;
       topPanel=new NorthPanel();
       midPanel= new CenterPanel();
       setLayout(new BorderLayout());
       add(topPanel,BorderLayout.NORTH);
       add(midPanel,BorderLayout.CENTER);

    }
    private class NorthPanel extends JSplitPane
    {
        private StringPanel panel1;
        private StringPanel panel2;

        private NorthPanel()
        {
            super();
            setDividerLocation(divider);
            setDividerSize(0);
            panel1=new StringPanel("Menus");
            panel2=new StringPanel("Options de menu");
            setLeftComponent(panel1);
            setRightComponent(panel2);
        }
    }
    private class CenterPanel extends JSplitPane
    {
        private JPanel buttonLayout1;
        private JPanel buttonLayout2;
        private JButton exitButton;
        private CenterPanel()
        {
           super();
           setDividerLocation(divider);
           setDividerSize(0);
            buttonLayout1=new JPanel();
            buttonLayout2=new JPanel();
            buttonLayout1.setLayout(new GridLayout(3,1));
            buttonLayout2.setLayout(new GridLayout(4,1));
            buttonLayout1.add(new JButton("Application"));
            buttonLayout1.add(new JButton("Etudiant"));
            buttonLayout1.add(new JButton("infos"));
            exitButton= new JButton("Quitter");
            exitButton.addActionListener(new CloseEventListener());
            buttonLayout2.add(exitButton);
            JButton inscriptionButton=new JButton("Inscription");
            buttonLayout2.add(inscriptionButton);
            inscriptionButton.addActionListener(new ChangePanelListener(new SubscribeFormPanel()));
            JButton iesnButton=new JButton("IESN");
            buttonLayout2.add(iesnButton);
            iesnButton.addActionListener(new ChangePanelListener(new IESNpanel()));
            buttonLayout2.add(new JButton("aide"));
           setLeftComponent(buttonLayout1);
           setRightComponent(buttonLayout2);
        }
        private class CloseEventListener implements ActionListener
        {
            public void actionPerformed(ActionEvent a)
            {
                System.exit(0);
            }
            public CloseEventListener(){}
        }
        private class ChangePanelListener implements ActionListener
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
        }
        private class NewFrameListener implements  ActionListener
        {
            SecondaryFrame newFrame;
            private NewFrameListener(SecondaryFrame newFrame)
            {
                this.newFrame=newFrame;
            }
            public void actionPerformed(ActionEvent event)
            {
                newFrame.genWindow();
            }
        }
    }
}
