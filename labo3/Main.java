package labo3;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ObjectOutputStream fileOut=null;
        try {
            YearOfStudy classrom = new YearOfStudy("IG", 2, "bac");
            ArrayList<Student> studentList=new ArrayList();
            studentList.add(new Student("Marc","Hollet",classrom));
            studentList.add(new Student("Delahaie","Anthony",classrom));
            studentList.add(new Student("Devraisse","Titi",classrom));
            studentList.add(new Student("SS","D",classrom));
            studentList.add(new Student("Monsieur","Excellence",classrom));
            studentList.add(new Student("Monsieur","Popularité",classrom));
            studentList.add(new Student("Lipoutou","Quarante-quatre",classrom));
            studentList.add(new Student("Das","Nose",classrom));
            studentList.add(new Student("de Combat","Croquette",classrom));
            studentList.add(new Student("de Combat","Piou",classrom));

            fileOut=new ObjectOutputStream(new FileOutputStream("students.txt"));
            for(Student student:studentList) fileOut.writeObject(student);

        }catch (labo3Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMsg(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException fileException)
        {
            JOptionPane.showMessageDialog(null,fileException.getMessage(),"file error",JOptionPane.ERROR_MESSAGE);
        }
        finally {
            if (fileOut!=null)
            {
                try {fileOut.close();}
                catch (IOException exception)
                {
                    JOptionPane.showMessageDialog(null,exception.getMessage(),"file closing error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        ObjectInputStream fileIn= null;
        try
        {
            fileIn=new ObjectInputStream(new FileInputStream("students.txt"));
            Student student=(Student) fileIn.readObject();
            while(student!=null)
            {
                System.out.println(student);
                student=(Student) fileIn.readObject();
            }
        }
        catch (EOFException eofException)
        {
            System.out.println("Plus d'enregistrement");
        }
        catch (IOException ioException)
        {
            JOptionPane.showMessageDialog(null,"File reading error","file error",JOptionPane.ERROR_MESSAGE);
        }
        catch   (Exception exception)
        {
            JOptionPane.showMessageDialog(null,"an error occured that isn't related to the opening","unkonwn error",JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            if(fileIn!=null)
            {
                try{
                    fileIn.close();
                }catch(IOException ioexception)
                {
                    JOptionPane.showMessageDialog(null,ioexception.getMessage(),"file closing error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
