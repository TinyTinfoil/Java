import java.util.Scanner;
/**
 * Prompts the user for an interger to check if it's a leap year. Returns true or false.
 * @author Venkadesh Eswaranandam
 * @version 11/13/20
 */
public class LeapYear extends Cal
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Year to check if leap year:");
        int year = input.nextInt();
        while (year<1582)
        {
            System.out.println("Year must be greater than 1582");
            year = input.nextInt();
        } 
        System.out.println(isLeapYear(year));
    }
    public static boolean isLeapYear(int year){
        return year%4==0 && (!(year%100==0)||year%400==0);
    }
}
