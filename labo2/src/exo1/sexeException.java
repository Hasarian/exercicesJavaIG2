package exo1;

public class sexeException extends labo2Exception
{
    public sexeException(char wrongSexEntry)
    {
        super("we asked you to enter either \"m\" or \"f\"\nerror value:"+wrongSexEntry);
    }
}
