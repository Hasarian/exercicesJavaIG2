package labo3;

public class ThreadConsume extends  Thread
{
    private StudentToRead readingZone;

    public ThreadConsume(StudentToRead readingZone)
    {
        super("student displayer");
        this.readingZone=readingZone;
    }
    public void run()
    {
        Student student=readingZone.getStudent();
        while(student!=null)
        {
            System.out.println(student);
            student=readingZone.getStudent();
        }
    }
}
