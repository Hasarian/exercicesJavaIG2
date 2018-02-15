package exo1;

import javax.swing.*;

public class Main
{
    public static void main(String[]args)
        {
            try
            {
                Student student = new Student("Alibaba", "Alakazam", 'N', 1, 1, 1985, "market", 2);
                System.out.println(student);
            }
            catch(labo2Exception exception)
            {
                JOptionPane.showMessageDialog(null,exception.getMsg(),"alert",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
}