package labo3;

import java.io.Serializable;

public class Student implements Serializable
{
    private String name;
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    private String firstname;
    public String getFirstname(){return firstname;}
    public void setFirstname(String firstname){this.firstname=firstname;}

    private YearOfStudy yearOfStudy;
    public YearOfStudy getYearOfStudy(){return yearOfStudy;}
    public void setYearOfStudy(YearOfStudy yearOfStudy){this.yearOfStudy=yearOfStudy;}

    public Student(String name,String firstname,YearOfStudy yearOfStudy)
    {
        setFirstname(firstname);
        setName(name);
        setYearOfStudy(yearOfStudy);
    }

    public String toString()
    {return getName()+" "+getFirstname()+" inscrit(e) en "+getYearOfStudy().toString();}
}
