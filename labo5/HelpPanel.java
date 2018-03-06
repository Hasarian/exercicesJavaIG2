package labo5;

import javax.swing.*;

public class HelpPanel extends JPanel
{
    JLabel helpTxt;

    public HelpPanel()
    {
        super();
        helpTxt=new JLabel("<html><p>This is a menu to help you subscribe in our school </html>");
        add(helpTxt);
    }
}
