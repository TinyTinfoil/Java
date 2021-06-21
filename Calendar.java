
/**
 * Generates a Calendar for a year.
 * @author Venkadesh Eswaranandam
 * @version 3/18
 */
public class Calendar
{
    // instance variables - replace the example below with your own
    private Month[] months;
    private int year;
    public Calendar(int cyear)
    {
        year = cyear;
        months = new Month[12];
        String[] titles = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        months[0] = new Month(titles[0],firstDay(year),31);
        if (isLeapYear(year)) months[1] = new Month(titles[1],offset(months[0]),29);
        else months[1] = new Month(titles[1],offset(months[0]),28);
        for(int i=2;i<12;i++){
            months[i] = new Month(titles[i],offset(months[i-1]),31-((i+(i/7))%2));
        }
    }
    public static boolean isLeapYear(int year){
        return year%4==0 && (!(year%100==0)||year%400==0);
    }
    public static int firstDay(int year){
        year--;
        return ((((year)*365)+(year)/4-(year)/100+(year)/400)+1)%7;
    }
    public String toString(){
        String out = "";
        for(Month i : months){
            out += i + "\n";
        }
        return out;
    }
    public int offset(Month m){
        return (m.getFirstDay()+m.getDays())%7;
    }
}
