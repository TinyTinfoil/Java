import java.util.Scanner;
/**
 * Prints calendars with a user's input of year number.
 * Specifically, this class handles the user's input.
 * @author Venkadesh Eswaranandam
 * @version 3/18
 */
public class Driver
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int year;
        while(true){
            System.out.print("Enter the year for your calendar (press 1 to quit): ");
            year = input.nextInt();
            if (year==1) break;
            if(year>1582) System.out.print(new Calendar(year));
            else System.out.println("Year does not exist in Gregorian calendar...");
        }
    }
}
