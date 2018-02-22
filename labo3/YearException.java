package labo3;

public class YearException extends labo3Exception
{
    public YearException(int value)
    {
        super("this is not an acceptable value",new Integer(value).toString());
    }
}
