package exo1;

public class branchException extends labo2Exception
{
    public branchException(String branch)
    {
        super("this branch doesn't seem to exist. Please contact us\nerror value: "+branch);
    }
}
