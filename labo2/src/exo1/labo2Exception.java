package exo1;

import javax.swing.*;

public class labo2Exception extends Exception
{
    private String msg;
    public String getMsg()
    {
        return msg;
    }
    public labo2Exception(String msg)
    {
     this.msg=msg;
    }
}
