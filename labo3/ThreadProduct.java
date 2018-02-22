package labo3;

import javax.swing.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ThreadProduct extends Thread
{
    private StudentToRead writingZone;

    public ThreadProduct(StudentToRead writingZone)
    {
        super("Student searcher");
        this.writingZone=writingZone;
    }

    public void run()
    {
        ObjectInputStream fileIn= null;
        try
        {
            fileIn=new ObjectInputStream(new FileInputStream("students.txt"));
            Student student=(Student) fileIn.readObject();
            while(student!=null)
            {
                writingZone.setStudent(student);
                student=(Student) fileIn.readObject();
            }
            //writingZone.setStudent(null);
        }
        catch (EOFException eofException)
        {
            System.out.println("no more records");
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
