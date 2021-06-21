package parallel;

import java.util.stream.LongStream;
/**
 * Contains paralell utilites for primes
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Primes
{
    public static boolean isPrime(long i){
        if (i == 1){
            return false;
        }
        boolean isPrime = true;
        if(LongStream.range(2,(long)Math.sqrt(i+1))
        .parallel().anyMatch(x -> i%x==0)) isPrime=false;
        return isPrime;
    }
}
