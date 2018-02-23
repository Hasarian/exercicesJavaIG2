package labo4;

public class NumberException extends Labo4Exception
{
    public NumberException(String value)
    {
        super("this number is not correct",value);
    }
}
