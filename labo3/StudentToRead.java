package labo3;

public class StudentToRead
{
    private Student student;
    public synchronized Student getStudent()
    {
        if(toStepOn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        toStepOn=true;
        notify();
        return student;
    }
    public synchronized void setStudent(Student student)
    {
        if(!toStepOn)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        toStepOn=false;
        this.student=student;
        notify();
    }
    private boolean toStepOn=true;

}
