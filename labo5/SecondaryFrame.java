package labo5;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondaryFrame extends JFrame
{
    JPanel panel;
    JButton mainMenuButton;
    Container container;
    MainFrame mainFrame;
    public SecondaryFrame(JPanel panel,MainFrame mainFrame)
    {
        super();
        setBounds(100,100,1200,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container=getContentPane();
        this.mainFrame=mainFrame;
        mainMenuButton=new JButton("main menu");
        mainMenuButton.addActionListener(new MainMenuListener(mainFrame,this));
        this.panel=panel;
        container.setLayout(new BorderLayout());
        container.add(panel,BorderLayout.CENTER);
        container.add(mainMenuButton, BorderLayout.SOUTH);
    }
    public void genWindow()
    {
        mainFrame.setVisible(false);
        setVisible(true);
    }

    private class MainMenuListener implements ActionListener
    {
        SecondaryFrame toClose;
        MainFrame toSetVisible;
        private MainMenuListener(MainFrame mainFrame,SecondaryFrame currentFrame)
        {
            super();
            toSetVisible=mainFrame;
            toClose=currentFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            toClose.dispose();
            toSetVisible.totMainPanel();
            toSetVisible.setVisible(true);
        }
    }
}
