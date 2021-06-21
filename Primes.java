
/**
 * Finds primes in a specific range
 * @author Venkadesh
 * @version -1
 */
import java.util.*;
public class Primes
{
    public static void main(String[] args){
        System.out.print(primeInRange((long)1, (long)124));
    }
    /**
     * @param lower The lower bound to start searching
     * @param upper The upper bound to stop searching
     * @return the primes that were found
     */
    static String primeInRange(long lower, long upper){
        Set<Long> primes = new HashSet<Long>();
        for (long i = lower; i <= upper; i++){
            if (isPrime(i)){
                primes.add(i);
            }
        }
        return sortSet(primes).toString(); 
    }
    /**
     * @param in The set to sort
     * @return a TreeSet that has been sorted
     */
    static TreeSet sortSet(Set in){
        return new TreeSet(in);
    }
    /**
     * Note that this uses the nieve approch to checking primes, by checking
     * all numbers below sqrt(i) for possible divisors. For faster/more
     * performant checking, use AksTest instead.
     * @param i a number to check for primality. 
     * @return true or false
     * @see AksTest#isPrime
     */  
    public static boolean isPrime(long i){
        if (i == 1){
            return false;
        }
        boolean isPrime = true;
        for (long x = 2; x < Math.sqrt(i+1); x++){
            if (i%x == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }
    /**
     * Uses Primes.isPrime as a backend
     * @param target the nth prime to return
     * @return true or false
     * @see Primes#isPrime
     */
    static String nthPrime(long target){
        Set<Long> primes = new HashSet<Long>();
        long i = 1;
        do {
            if (isPrime(i)){
                primes.add(i);
            }
            i++;
        } while (primes.size() < target);
        return sortSet(primes).last().toString();
    }
}