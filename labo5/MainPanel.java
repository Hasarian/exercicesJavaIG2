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

    public MainPanel(int divider)
    {
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
            exitButton.addActionListener(new CloseEventListener(exitButton));
            buttonLayout2.add(exitButton);
            buttonLayout2.add(new JButton("Inscription"));
            buttonLayout2.add(new JButton("IESN"));
            buttonLayout2.add(new JButton("aide"));
           setLeftComponent(buttonLayout1);
           setRightComponent(buttonLayout2);
        }
        private class CloseEventListener implements ActionListener
        {
            JButton button;
            public void actionPerformed(ActionEvent a)
            {
                System.exit(0);
            }
            public CloseEventListener(JButton button){this.button=button;}
        }
    }
}
