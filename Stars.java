import java.io.*;
/**
 * Write a description of class Stars here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stars extends Pig
{
    private static int lars = 10;
    public static void main(String[] args){
        lars++;
        System.out.println(lars);
        
}
    static void leftTriangle()
    {
        for (int row = 1; row <= 10; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void rightTriangle()
    {
        for (int row = 1; row <= 10; row++)
        {
            for (int spc = 1; spc <= 10-row; spc++)
            {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++)
                {
                    System.out.print("* ");
                }
            System.out.println();
        }
    }
    static void invertedTriangle()
    {
        for (int row = 1; row <= 10; row++)
        {
            for (int col = 1; col <= row; col++)
                {
                    System.out.print("  ");
                }
            for (int spc = 1; spc <= 10-row; spc++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void diamond()
    {
        for (int row = 1; row <= 5; row++)
        {
            for (int spc = 1; spc <= 5-row; spc++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++)
                {
                    System.out.print("* ");
                }
            System.out.println();
        }
        for (int row = 1; row <= 5; row++)
        {
            for (int col = 1; col <= row; col++)
                {
                    System.out.print(" ");
                }
            for (int spc = 1; spc <= 5-row; spc++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
