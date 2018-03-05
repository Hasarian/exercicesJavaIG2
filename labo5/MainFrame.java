package labo5;

import org.omg.CORBA.BAD_INV_ORDER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame
{
    private Container container;
    private JMenuBar menuBar;
    private JMenu menu, optionMenu;
    private JMenuItem app, student,infos, exit,inscription,iESN,help;
    private MainPanel mainPanel;

    public MainFrame()
    {
        super();
        container= this.getContentPane();
        setBounds(100,100,1200,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel=new  MainPanel(600);
        container.add(mainPanel);

        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        menu= new JMenu("Menu");
        optionMenu=new JMenu("Option Menu");
        menuBar.add(menu);
        menuBar.add(optionMenu);
        app=new JMenuItem("Application");
        student= new JMenuItem("Student");
        infos=new JMenuItem("Informations");
        menu.add(app);
        menu.add(student);
        menu.add(infos);
        exit= new JMenuItem("Quit");
        exit.addActionListener(new ExitListener());
        inscription=new JMenuItem("Inscription");
        iESN=new JMenuItem("IESN");
        iESN.addActionListener(new ChangePanelListener( new StringPanel("adresse\n téléphone \nsite internet")));
        help=new JMenuItem("Help");
        optionMenu.add(exit);
        optionMenu.add(inscription);
        optionMenu.add(iESN);
        optionMenu.add(help);

        this.setVisible(true);
    }
    private class ExitListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            System.exit(0);
        }
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
            container.remove(mainPanel);
            container.add(newPanel);
        }
    }
}
