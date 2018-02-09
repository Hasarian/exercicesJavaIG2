package exo1;

public class Student extends Personne
{
    private static String[] branches;
        static
        {
            branches = new String[]{"compta", "droit", "market", "infoGestion", "technoInfo"};
        }

    private String branch;
        public String getBranch(){return branch;}
        private void setBranch(String branch)throws branchException
        {
            branch=branch.toLowerCase()
            if(isLegitBranch(branch))this.branch=branch;
            else {throw new branchException;}
        }

    private int yearOfStudy;
        public int getYearOfStudy(){return yearOfStudy};
        private void setYearOfStudy(int yearOfStudy)throws yearException
        {
            if(yearOfStudy<1||yearOfStudy>3) throw  new yearException;
            this.yearOfStudy=yearOfStudy;
        }

    public Student(String name,String firstname,char sex,int dayOfBirth,int monthOfBirth,int yearOfBirth,String branch,int yearOfStudy) throws yearException,branchException,sexeException
    {
        super(name,firstname,sex,dayOfBirth,monthOfBirth,yearOfBirth)
        setBranch(branch);
        setYearOfStudy(yearOfStudy);
    }

    public String toString()
    {
        String description=super.toString();
        description+=" est inscrit"+?(super.getSex()=='M')"":"e";
        description+=" en "+getYearOfStudy()+(getYearOfStudy()==1)?"ere":"eme";
        description+=" "+branch;
        return description;
    }

    public static boolean isLegitBranch(String branch)
    {
        for(int i=0;i<branches.length;i++)
        {
            if(branches[i].equals(branch)) return true;
        }
        return false;
    }
}