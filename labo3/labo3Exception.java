package labo3;

import javax.swing.*;

public class labo3Exception extends Exception
{
    private String msg;
    private String value;

    public labo3Exception(String msg,String value)
    {
        this.msg=msg;
        this.value=value;

    }

}
