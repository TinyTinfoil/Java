import java.util.Scanner;
/**
 * Write a description of class Cal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cal
{
     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int year;
        while(true){
            System.out.print("Enter the year for your calendar (press 1 to quit): ");
            year = input.nextInt();
            if (year==1) break;
            if(year>1582) print(year);
            else System.out.println("Year does not exist in Gregorian calendar...");
        }
        
    }
    public static void print(int year){
        String[] titles = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int leapyear;
        if (year%4==0 && (!(year%100==0)||year%400==0)) leapyear = 2;
        else leapyear = 1;
        year--;
        int offset = ((((year)*365)+(year)/4-(year)/100+(year)/400)+1)%7;
        int i = 0;
        int days = 0;
        for(String months : titles){
            System.out.println(months);
            days = 31-((i+(i/7))%2);
            if (i==1) days-=leapyear;
            for(int e = 0;e<offset;e++){
                System.out.print("\t");
            }
            for(int r = 1;r<=days;r++){
                System.out.print(r+"\t");
                if((r+offset)%7==0) System.out.println();
            }
            System.out.println();
            offset=(days+offset)%7;
            i++;
        }
     }
}
