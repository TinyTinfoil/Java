import java.util.*;
public class AksTest {
    private static ArrayList<Long> c = new ArrayList<Long>(); //max array size
    public static void main(String[] args) {
        for (int n = 0; n < 10; n++) {
            coeff(n);
            show(n);
        }
 
        System.out.print("Primes:");
        for (int n = 1; n < c.size(); n++)
            if (isPrime(n))
                System.out.printf(" %d", n);
 
        System.out.println();
    }
 
    static void coeff(int n) {
        c.add(0,1L);
        for (int i = 0; i < n; c.add(0,-c.get(0)), i++) {
            c.add(1 + i,1L);
            for (int j = i; j > 0; j--)
                c.add(j,c.get(j - 1) - c.get(j));
        }
    }
 
    static boolean isPrime(int n) {
        coeff(n);
        c.set(0,c.get(0)+1);
        c.set(n,c.get(n)-1);
 
        int i = n;
        while (i-- != 0 && c.get(i) % n == 0)
            continue;
        return i < 0;
    }
 
    static void show(int n) {
        System.out.print("(x-1)^" + n + " =");
        for (int i = n; i >= 0; i--) {
            System.out.print(" + " + c.get(i) + "x^" + i);
        }
        System.out.println();
    }
}