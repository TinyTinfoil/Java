import java.util.Scanner;
/**
 * Rock, Paper, Scissors in Java.
 * @author Venkadesh Eswaranandam
 * @version 12/18/20
 */
public class RPS2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the game of Rock, Paper, Scissors!");
        int player, computer, winner, index;
        int wins = 0, losses=0, ties=0;
        String in = "";
        //string segments are padded with spaces so they are 22 characters long (extra space is for a tie)
        String msg1 = "                      Paper covers rock,    Scissors cut paper,   Rock smashes scissors,";
        //segments padded with spaces so they are 14 characters long
        String msg2 = "Computer wins!Tie!          You win!      ";
        System.out.println("Enter your play: r, p, or s. (press any other key to quit)");
        in = input.nextLine();
        while (in.length()>0 && (in.charAt(0) == 'r'||in.charAt(0) == 's'|| in.charAt(0) == 'p'))
        {
            //converts char to int
            player = in.charAt(0);
            //converts s to 3, p to 1, and r to 2
            player = (player-111)/2+1;
            computer = (int)(Math.random() * 3) + 1;
            System.out.println("Computer play is " + (char)((computer/2)+ computer+ 111));
            //-1 for computer win, 0 for tie, 1 for player win.
            winner = ((computer-player)/2)*(-3)+(computer-player);
            //0 if tie, 1 if p+s, 2 if p+r, 3 if r+s
            index = Math.abs(winner)*(player+computer-2);
            //selects segment to print, .trim() removes trailing whitespace from a segment
            System.out.print(msg1.substring(22*(index),22*(index+1)).trim());
            //adds 1 or 0 to apropriate stats
            losses += ((winner*-1)+1)/2;
            //converts winner to 0,1, or 2
            winner++;
            ties += (winner)%2;
            wins += (winner)/2;
            System.out.println(msg2.substring(14*(winner),14*(winner+1)));
            System.out.println("Enter your play: r, p, or s. (press any other key to quit)");
            in = input.nextLine();
        }
        System.out.println("Stats:");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }
}




