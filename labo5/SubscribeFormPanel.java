package labo5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
* boursier/étranger :  trucs à cocher
* */
public class SubscribeFormPanel extends JPanel {
    private static final String[] branches = {"technologie de l'informatique",
            "informatique de gestion",
            "comptabilité",
            "marketing",
            "automation",
            "droit",
            "régendat"};

    private JTextField matricule, firstname, name, birthDate, origin;

    public String getMatricule() {
        return matricule.getText();
    }

    public String getFirstName() {
        return firstname.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getBirthDate() {
        return birthDate.getText();
    }

    public String getBranch() {
        return branches[branchNumber()];
    }

    public String getOrigin() {
        return origin.getText();
    }

     private boolean isNewInscirption;
    public boolean isNewInscirption(){return isNewInscirption;}
    JCheckBox boursier, foreigner;

    public boolean isBoursier() {
        return boursier.isSelected();
    }

    public boolean isForeigner() {
        return foreigner.isSelected();
    }

    public SubscribeFormPanel()
    {
        setLayout(new BorderLayout());
        JPanel centerPanel=new JPanel();
        add(centerPanel,BorderLayout.CENTER);
      //  centerPanel.setLayout(new GridLayout(2,1));

        centerPanel.add(new GeneralInfoForm());
        //centerPanel.add(new RadioButton());
        JPanel southPanel=new JPanel();
        JButton backButton=new JButton("to main menu");
        JButton confirmButton=new JButton("confirm");
        southPanel.add(backButton);
        southPanel.add(confirmButton);
        add(southPanel,BorderLayout.SOUTH);
    }

    public int branchNumber()
    {
        char firstNumber= matricule.getText().charAt(0);
       // System.out.println(firstNumber+"\n"+matricule.getText()+"\n"+matricule.getText().charAt(0));
        if(firstNumber<'1'||firstNumber>'7')
        {
            JOptionPane.showMessageDialog(null,"this is not a correct matricule","error",JOptionPane.ERROR_MESSAGE);
            matricule.setText("");
            return -1;
        }
        return Integer.parseInt(""+firstNumber)-1;
    }


    private class GeneralInfoForm extends JPanel
    {
        JTextField branch;
        private GeneralInfoForm()
        {
            super();
            JLabel matriculeLabel=new JLabel("matricule:");
            JLabel firstnameLabel=new JLabel("firstname:");
            JLabel nameLabel=new JLabel("family name:");
            JLabel birthDateLabel=new JLabel("birth date:");
            JLabel originLabel=new JLabel("originLabel");
            JLabel branchLabel=new JLabel("section:");
            matricule=new JTextField();
            firstname=new JTextField();
            name=new JTextField();
            birthDate=new JTextField();
            origin=new JTextField();
            branch=new JTextField();
            branch.setEditable(false);
            boursier=new JCheckBox("boursier");
            foreigner=new JCheckBox("foreigner");

            setLayout(new GridLayout(8,2));


            add(matriculeLabel);
            add(matricule);
            matricule.addActionListener(new matriculeListner());
            add(firstnameLabel);
            add(firstname);
            add(nameLabel);
            add(name);
            add(birthDateLabel);
            add(birthDate);
            add(originLabel);
            add(origin);
            RadioButton groupButton=new RadioButton();
            add(groupButton.getFirstButton());
            add(groupButton.getAgainButton());
            add(branchLabel);
            add(branch);

            add(boursier);
            add(foreigner);



        }
        private class matriculeListner implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(branchNumber()>=0)
                branch.setText(branches[branchNumber()]);
            }
        }
    }
    private class RadioButton extends JPanel
    {
        JRadioButton first,again;
        public JRadioButton getFirstButton(){return first;}

        public JRadioButton getAgainButton() {
            return again;
        }

        private RadioButton()
        {
            super();
            first=new JRadioButton("new inscription",true);
            again=new JRadioButton("renew inscription",false);
            add(first);
            add(again);
            ButtonGroup group=new ButtonGroup();
            group.add(first);
            group.add(again);

            RadioButtonListener selectionListener=new RadioButtonListener();
            first.addItemListener(selectionListener);
            again.addItemListener(selectionListener);
        }
        private class RadioButtonListener implements ItemListener
        {
            public void itemStateChanged(ItemEvent event)
            {
                if(event.getSource()==first&&event.getStateChange()==ItemEvent.SELECTED)
                    isNewInscirption=true;
                if(event.getSource()==again&&event.getStateChange()==ItemEvent.SELECTED)
                    isNewInscirption=false;
            }
        }
    }

}