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
    private static final String[] branches={"technologie de l'informatique",
                                            "informatique de gestion",
                                             "comptabilité",
                                              "marketing",
                                              "automation",
                                               "droit",
                                               "régendat"};
    private JTextField matricule,firstname,name,birthDate,origin;
    public String getMatricule(){return matricule.getText();}
    public String getFirstName(){return firstname.getText();}
    public String getName(){return name.getText();}
    public String getBirthDate(){return birthDate.getText();}
    public String getBranch(){return branches[branchNumber()];}
    public String getOrigin(){return origin.getText();}
    RadioButton inscriptionKind;
    JCheckBox boursier,foreigner;
    public boolean isBoursier(){return boursier.isSelected();}
    public boolean isForeigner(){return foreigner.isSelected();}


    public int branchNumber()
    {
        int firstNumber= matricule.getText().charAt(0);
        if(firstNumber<1||firstNumber>7)
        {
            JOptionPane.showMessageDialog(null,"this is not a correct matricule","error",JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        return firstNumber;
    }

    private class GeneralInfoForm extends JPanel
    {

    }
    private class RadioButton extends JPanel
    {

    }
    private class CheckBoxManager
    {

    }
}