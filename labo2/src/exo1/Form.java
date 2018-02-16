package exo1;
import javax.swing.*;
import java.awt.*;

public class Form
{
    private Window window;
    private Container container;
    private int nbEtudiants;
    private void setNbEtudiants(int nbEtudiants) throws NbException
    {
        if (nbEtudiants<1) throw new NbException();
        this.nbEtudiants=nbEtudiants;
    }

    public Form() throws  NbException
    {
        setNbEtudiants(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the number of students you wish to sign up:","preparetion",JOptionPane.QUESTION_MESSAGE)));
        window=new Window("subscribing "+nbEtudiants+" students");
        container=window.getContentPane();
    }

    private class Window extends JFrame
    {
        private Window(String titre)
        {
            super(titre);
            setBounds(100,100,500,500);
            setVisible( true);
        }

    }


    private class  oneForm extends JPanel
    {
        private JPanel textForm,birthForm;
        private JLabel nameLabel,firstNameLabel;
        private JTextField name,firstname;
        private JComboBox dayOfBirth,monthOfBirth,yearOfBirth,yearOfStudy,sexInit,branch;

        public oneForm()
        {
            textForm= new JPanel();
            textForm.setBounds(10,80,200,200);
            textForm.setLayout(new GridLayout(2,2,2,3));

            nameLabel=new JLabel("family name:");
            textForm.add(nameLabel);
            name=new JTextField();
            textForm.add(name);
            firstNameLabel=new JLabel("first name:");
            textForm.add(firstNameLabel);
            firstname=new JTextField();
            textForm.add(firstname);
            this.add(textForm);

            birthForm= new JPanel();
            birthForm.setLayout(new GridLayout(1,3,1,1));
            dayOfBirth=new JComboBox();
            for(int day=1;day<32;day++)dayOfBirth.addItem(day);
            birthForm.add(dayOfBirth);
            monthOfBirth=new JComboBox();
            for (int month=1;month<13;month++)monthOfBirth.addItem(month);

        }

    }

}
