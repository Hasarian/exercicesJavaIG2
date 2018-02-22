package labo3;

import java.util.logging.Level;

public class YearOfStudy
{
    private String branchLabel;
    public String getBranchLabel(){return branchLabel;}
    public void setBranchLabel(String branchLabel){this.branchLabel=branchLabel;}

    private int year;
    public int getYear(){return year;}
    public void setYear(int year) throws YearException
    {
        if (year>3||year<1)throw new YearException(year);
        this.year=year;
    }

    private String level;
    public String getLevel(){return level;}
    public void setLevel(String level) throws LevelException
    {
        level=level.toLowerCase();
        if (!level.equals("bac")&&!level.equals("master")) throw new LevelException(level);
        this.level=level;
    }

    public YearOfStudy(String branchLabel,int year,String level) throws YearException,LevelException
    {
        level=level.toLowerCase();
        if (level.equals("master")&&year==3)throw new YearException(3);
        setBranchLabel(branchLabel);
        setLevel(level);
        setYear(year);
    }

    public String toString()
    {
        return level+year+" "+branchLabel;
    }
}
