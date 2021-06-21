import java.util.Scanner;
/**
 * Prints Pascal's Triangle to stdout.
 *
 * @author Venkadesh Eswaranandam
 * @version 4/20
 */
public class CopyOfPascal
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

