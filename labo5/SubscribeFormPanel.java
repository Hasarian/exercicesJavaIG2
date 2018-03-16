package labo5;

import javax.swing.*;
import java.awt.*;

public class SubscribeFormPanel extends JPanel
{
    private JLabel nameLabel,firstNameLabel;
    private JTextField name,firstName;
    public SubscribeFormPanel()
    {
        super();
        setLayout(new GridBagLayout());
        nameLabel=new JLabel("family name:");
        firstNameLabel=new JLabel("first name:");
        name=new JTextField();
        firstName=new JTextField();

        GridBagConstraints contraints= new GridBagConstraints();
        contraints.fill=GridBagConstraints.HORIZONTAL;
        contraints.anchor=GridBagConstraints.EAST;
        contraints.weighty=1;
        contraints.gridwidth=3;
        contraints.gridheight=1;
        contraints.gridx=5;
        contraints.gridy=5;
        contraints.weightx=1;
        add(nameLabel,contraints);
        contraints.anchor=GridBagConstraints.WEST;
        contraints.gridx+=contraints.gridwidth+1;
        contraints.gridwidth++;
        contraints.weightx=2;
        add(name,contraints);
        contraints.anchor=GridBagConstraints.EAST;
        contraints.weightx--;
        contraints.gridy+=contraints.gridy;
        contraints.gridx=5;
        contraints.gridwidth--;
        add(firstNameLabel,contraints);
        contraints.anchor=GridBagConstraints.WEST;
        contraints.gridx+=contraints.gridwidth+1;
        contraints.gridwidth++;
        contraints.weightx++;
        add(firstName,contraints);


    }
}
