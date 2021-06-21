import java.util.stream.*;
/**
 *Parallel 2D array iteration (Non thread safe).
 * @author Venkadesh Eswaranandam
 * @version May 29
 */
public interface Parallel2D<T> extends Loop2D<T>//does not work with JavaFX functions
{
    /**
     * May traverse through a 2D array in parallel, applying func().
     * Arrays less than or equal to 100 rows are traversed in a stream sequentially.
     * Arrays larger than 100 rows are additonally traversed in parallel on rows.
     * Arrays larger than 1000 rows are additionally traversed in parallel on 
     * both in rows and columns.
     * @param arr the array to traverse through
     * @throws exception if func is not thread safe
     */
    default public void apply(T[][] arr)
    {
        if(arr.length>1000){
            IntStream.range(0, arr.length)
            .parallel()
            .forEach(
                r -> 
                {IntStream.range(0, arr[0].length)
                    .parallel()
                    .forEach(
                        c -> func(r,c));
                });
        } else if(arr.length>100){
            IntStream.range(0, arr.length)
            .parallel()
            .forEach(
                r -> 
                {IntStream.range(0, arr[0].length)
                    .forEach(
                        c -> func(r,c));
                });
        }
        else {
            //non parallel for small values
            IntStream.range(0, arr.length)
            .forEach(
                r -> 
                {IntStream.range(0, arr[0].length)
                    .forEach(
                        c -> func(r,c));
                });
        }
    }
}
