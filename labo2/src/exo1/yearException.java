package exo1;

public class yearException extends labo2Exception
{
    public yearException(int yearOfStudyError)
    {
        super("this is not a supported year for your curriculum\nerror value: "+yearOfStudyError);
    }
}
