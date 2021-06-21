package parallel;
 
import java.util.stream.*;
/**
 *Parallel 2D array iteration (Non thread safe).
 * S.A.M(Single Abstract Method) I am.
 * @author Venkadesh Eswaranandam
 * @version May 29
 */
/* *
 * All interfaces are abstract (abstract classes have one or more undeclared methods to "fill in" by overriding)
 * To work with lambda, the class needs to be an interface with only one abstract function.
 * Interfaces can also be used as object types.
 * The <T> allows one to use this function as they would an arraylist,
 * by specifying the type in the arrow brackets.
 * For example, the type of Parallel2D<String> for a String 2d array.
 * Java can go even further and *infer* the type in this case
 * So ArrayList a = new ArrayList<String>(); is valid;
 */
public interface ForEach2D<T>//does not work with JavaFX functions
{
    /**
     * Run to apply the function for each element in the array.
     * The T is a placeholder for the type
     * The default keyword allows the function to have a body, even though it's an interface.
     */
    default public void apply(T[][] arr)
    {
        
        IntStream.range(0, arr.length)
        .parallel()
        .forEach(
        r -> 
        {IntStream.range(0, arr[0].length)
        .parallel()
        .forEach(
        c -> func(r,c));
 });
    }
    /**
     * This is the function that runs for each array element.
     * This is equal to public void func(int r, int c), 
     * since by default, all non-default functions are abstract in an interface.
     * Abstract is included for ilustrative purposes.
     */
    public abstract void func(int r,int c);
}
