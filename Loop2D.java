/**
 * Loops through a 2D array lazily.
 *
 * @author Venkadesh
 * @version May 30
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
public interface Loop2D<T>
{
    /**
     * A default method allows this interface to specify a body
     */
    /**
     * Applies the given func method to each element in the specified 2D array.
     * Traverses through the array with a nested for loop.
     * @param arr the array to apply the function to
     */
    default public void apply(T[][] arr){
        for(int r=0;r<arr.length;r++) 
            for(int c=0;c<arr[0].length;c++) func(r,c);
    }
    /**
     * This is the function that runs for each array element.
     * This is equal to public void func(int r, int c), 
     * since by default, all non-default functions are abstract in an interface.
     * Abstract is included for ilustrative purposes.
     */
    /**
     * The function to be run over each element of the array.
     * @param r the row index
     * @param c the column index
     */
    public void func(int r, int c);
}
