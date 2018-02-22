package labo3;

public class LevelException extends labo3Exception
{
    public LevelException(String levelError)
    {
        super("this is not an existant level",levelError);
    }
}
