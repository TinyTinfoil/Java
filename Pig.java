import java.util.Scanner;
/**
 * Two die version of the game Pig. 
 * @author Venkadesh
 * @version 1/17
 */
public class Pig
{
    public static void main(String[] args)
    {
        int playerScore = 0;
        int computerScore = 0;
        Scanner in = new Scanner(System.in);
        char play;
        int n;
        int turnScore=0;
        while(true){
            System.out.println("Player turn");
            while(true){
                System.out.println("Roll? (y/n/q)");
                play = (in.nextLine()+" ").charAt(0); //By including a space, an out of range error can be avoided 
                while(play!='y'&&play!='n'&&play!='q'){
                    System.out.println("Please type yes or no...");
                    play = (in.nextLine()+" ").charAt(0);
                }
                if (play == 'q') break;
                if(play == 'n') break;
                turnScore = fairRoll(playerScore,turnScore);
                if (turnScore<=0||playerScore+turnScore>=100) break;
            }
            playerScore += turnScore;
            if (play=='q') break;
            if (playerScore>=100){
                System.out.println("Player wins");
                break;
            }
            turnScore = 0;
            System.out.println("Computer turn");
            if (playerScore >= 85 || computerScore >=85)
                n = 100;
            else 
                n = (20+Math.abs(playerScore-computerScore)/4);
            while(turnScore<=n){
                System.out.println("Computer choses to roll");
                turnScore = fairRoll(computerScore,turnScore);
                if (turnScore<=0||computerScore+turnScore>=100) break;
            }
            computerScore += turnScore;
            if (computerScore>=100){
                System.out.println("Computer wins");
                break;
            }
            turnScore = 0;
        }
        System.out.println("Computer final score: " + computerScore);
        System.out.println("Player final score: " + playerScore);        
    }
    static int fairRoll(int playerScore, int turnScore)
    {
        int roll1 = (int)(Math.random()*6)+1;
        int roll2 = (int)(Math.random()*6)+1;
        if(roll1+roll2==2){
            System.out.println("Rolled 2 ones, back to zero!");
            return -playerScore;
        }
        if (roll1==1 || roll2==1){
            System.out.println("Rolled a one, lost turn score");
            return 0;
        }
            System.out.println("Rolled a " + roll1 + " and a " + roll2);
            System.out.println("Current score is " + (playerScore+turnScore+roll1+roll2));
            return roll1 + roll2 + turnScore;
    }
}
