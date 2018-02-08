package exo1;

import java.util.GregorianCalendar;

public class Personne
{
    private String name;
    public String getName(){return name;}
    private void setName(String name){this.name=name;}

    private String firstname;
    public String getFirstname(){return firstname;}
    private void setFirstname(String name){firstname=name;}

    private char sex;
    public char getSex(){return sex;}
    private void setSex(char sexInitialLetter){sex=sexInitialLetter;}

    private GregorianCalendar birthDate;
    public GregorianCalendar getBirthDate(){return birthDate;}
    private void setBirthDate(int year,int month,int day)
    {
        birthDate=new GregorianCalendar(year,month,day);
    }

    public Personne(String name,String firstname,char sex,int dayOfBirth,int monthOfBirth,int yearOfBirth)
    {
        setName(name);
        setFirstname(firstname);
        setSex(sex);
        setBirthDate(yearOfBirth,monthOfBirth,dayOfBirth);
    }

}
