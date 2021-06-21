/**
 * Month is a class repersenting one month worth of days.
 * @author Venkadesh Eswaranandam
 * @version 3/18
 */
public class Month
{
    private String name;
    private int days;
    private int firstDay;
    public Month(String mname, int mfirstday,int mdays)
    {
       name=mname;
       days=mdays;
       firstDay=mfirstday;
    }
    public void setDays(int mdays){
        days = mdays;
    }
    public void setName(String mname)
    {
       name=mname;
    }
    public void setFirstDay(int mfirstday){
        firstDay = mfirstday;
    }
    public int getDays(){
        return days;
    }
    public String getName()
    {
       return name;
    }
    public int getFirstDay(){
        return firstDay;
    }
    public String toString(){
        String output = "";
        output += name + "\n";
        output += "SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT\t\n";
        int newline = firstDay;
        for (int i=0;i<firstDay;i++){
            output += "\t";
        }
        for (int i=1;i<=days;i++){
            newline++;
            output += i+"\t";
            if (newline%7==0) output += "\n";
        }
        if (firstDay+days%7!=0) output += "\n";
        return output;
    }
}
