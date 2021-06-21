import java.util.Scanner;
/**
 * Prompt a user for a time in seconds and 
 * returns it in hours, minutes, and seconds.
 * @author Venkadesh Eswaranandam
 * @version 9/24/20
 */
public class TimeConversion
{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input time in seconds: ");
        int time = input.nextInt();
        System.out.print("\nSeconds: " + time%60);
        //Converts seconds to minutes, then outputs minutes that cannot become an hour.
        System.out.print("\nMinutes: " + ((time/=60)%60));
        System.out.print("\nHours: " + time/60);
    }
}

