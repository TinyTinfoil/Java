import javafx.beans.value.*;
/**
 * A specialized TextField that only recives numeric input.
 * @author Venkadesh
 * @version May 30
 */
public class NumberInput extends javafx.scene.control.TextField
{
    /**
     * Makes a new numerical input object.
     * This acts just like a TextField, but removes all non digit input made
     * by the user, including dots and commas.
     * As such, it cannot be used to recive double or float input and is best
     * suited for the input of relatively small integer values.
     */
    public NumberInput(){
        this.textProperty().addListener((ChangeListener<String>) 
            (temp, oldValue, 
             newValue) -> {
                /**
                 * Regex:
                 * Regular expressions are one way to process strings based
                 * on patterns.
                 * It was popularized by Perl and now can be found in most
                 * programing languages.
                 * It's a useful programming skill that carries through many 
                 * different languages.
                 * In Java, Regex can be applied to a string through the 
                 * String.matches method.
                 * The String.replaceAll method replaces the pattern matches
                 * with the specified string (in this case, it is removed);
                 * \d* means match digits and digits following it
                 * \D* means match everything but a digit and digits following it
                 */
                if (!newValue.matches("\\d*")) {
                    this.setText(newValue.replaceAll("\\D*", ""));
                }
            }
        );
    }
    /**
     * Returns the integer value of the input.
     * If it is blank, it will return 0.
     * @return the integer value of the input (not including dots, etc.)
     */
    public int getValue(){
        //Adding zero at the start does not change the value, yet prevents a NumberFormatExecption
        return Integer.parseInt("0" + this.getCharacters().toString());
    }
}
