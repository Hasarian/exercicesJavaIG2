package labo5;

import javax.swing.*;
import java.awt.*;

/*reste:
* id: nuùber field
* date de naissance (3 chiffres)
* section: automatique, en fonction du chiffre entré par l'user
* boursier/étranger :  trucs à cocher
* origine: text field
* radio box nouvel étudiant/réinscription
* */
public class SubscribeFormPanel extends JPanel
{
    private String matricule;
    public String getMatricule(){return matricule;}
    private JTextField name,firstName;
    public String getName(){return name.getText();}
    public String getFirstName(){return firstName.getText();}
    public SubscribeFormPanel()
    {
        super();
        setLayout(new BorderLayout());
        add(new FormPanel(),BorderLayout.CENTER);

    }
    private class FormPanel extends JPanel
    {
        private JLabel nameLabel,firstNameLabel;
        private FormPanel()
        {
            super();
            nameLabel=new JLabel("family name:");
            firstNameLabel=new JLabel("first name:");
            name=new JTextField();
            firstName=new JTextField();

            setLayout(new GridBagLayout());
            GridBagConstraints constraints=new GridBagConstraints();
            constraints.weightx=1;
            constraints.anchor=GridBagConstraints.LINE_END;
            constraints.gridx=1;
            constraints.gridy=1;
            add(nameLabel,constraints);
            constraints.gridy++;
            add(firstNameLabel,constraints);

            constraints.fill=GridBagConstraints.HORIZONTAL;
            constraints.insets=new Insets(0,0,0,250);
            constraints.gridx++;
            constraints.anchor=GridBagConstraints.LINE_START;
            constraints.gridy=1;
            add(name,constraints);
            constraints.gridy++;
            add(firstName,constraints);
        }
    }
}
