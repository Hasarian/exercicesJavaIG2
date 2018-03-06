package labo5;

import javax.swing.*;
import java.awt.*;

public class SubscribeFormPanel extends JPanel
{
    JLabel nameLabel,firstNameLabel;
    JTextField name,firstName;
    public SubscribeFormPanel()
    {
        super();
        setLayout(new GridLayout(2,2));
        nameLabel=new JLabel("family name:");
        firstNameLabel=new JLabel("first name:");
        name=new JTextField();
        firstName=new JTextField();
        add(nameLabel);
        add(firstNameLabel);
        add(name);
        add(firstName);
    }
}
