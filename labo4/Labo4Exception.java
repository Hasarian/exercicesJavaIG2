package labo4;

public class Labo4Exception extends Exception
{
    private String msg;
    private  String value;

    public Labo4Exception(String msg, String value)
    {
        this.msg=msg;
        this.value=value;
    }

    public String getMsg(){return msg+"\nError value:"+value;}
}
