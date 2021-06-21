import java.util.Scanner;
/**
 * Prints Pascal's Triangle to stdout with recursion.
 *
 * @author Venkadesh Eswaranandam
 * @version 4/20
 */
public class Pascal
{
    public static int[][] triangle;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("# of rows to print of Pascal's Triangle?");
        int rows = in.nextInt();
        triangle = new int[rows][];
        //instantiate rows before columns to create a triangular array
        for(int i = 0;i<rows;i++){
            triangle[i] = new int[i+1];
        }
        for(int r = 0;r<rows;r++){
            for(int c = 0;c<=r;c++){
                triangle[r][c]=pascal(r,c);
            }
        }
        for(int[] a : triangle){
            if((rows-a.length)%2==1) System.out.print("\t");
            for(int i = (rows-a.length)/2; i>0; i--){
                System.out.print("\t\t");
            }
            for(int e : a){
                System.out.print(e+"\t\t");
            }
            System.out.println();
        }
    }
    public static int pascal(int r, int c){
        if (r<0 || c<0 || c>r) return 0;
        if (r==0 || c==0 || r==c){ 
            return 1;
        }
        return pascal(r-1,c-1) + pascal(r-1,c);
    }        
}

import java.math.BigInteger;
/**
 * Optimized program for printing Pascal's Triangle
 *
 * @author Venkadesh Eswaranandam
 * @version 4/20
 */

class TurboPascal
{
    /*BigIntegers don't overflow, while int and long will overflow and cause
     * negative numbers to be printed, ruining further results
     */
    public static BigInteger[][] triangle;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("# of rows to print of Pascal's Triangle?");
        int rows = in.nextInt();
        triangle = new BigInteger[rows][];
        //instantiate rows before columns to create a triangular array
        for(int i = 0;i<rows;i++){
            triangle[i] = new BigInteger[i+1];
        }
        for(int r = 0;r<rows;r++){
            for(int c = 0;c<=r;c++){
                triangle[r][c]=pascal(r,c);
            }
        }
        for(BigInteger[] a : triangle){
            for(int i = rows-a.length; i>0; i--){
                System.out.print(" ");
            }
            for(BigInteger e : a){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
    public static BigInteger pascal(int r, int c){
       if (r<0 || c<0 || c>r) return BigInteger.ZERO;
        //Caches results to triangle and recalls numbers to avoid recomputation
       if (triangle[r][c]!=null) return triangle[r][c];
       if (r==0 || c==0 || r==c){ 
            return triangle[r][c] = BigInteger.ONE;
        }
	//BigInts use .add instead of +
        return triangle[r][c] = pascal(r-1,c-1).add(pascal(r-1,c));
    }      
}



