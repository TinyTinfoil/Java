import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
/**
 * A JavaFX square.
 * @author Venkadesh Eswaranandam
 * @version June 7th
 */
public class Square extends javafx.scene.shape.Rectangle{
    /**
     * Makes a square with the specified size.
     * @param s the size of the square
     */
    public Square(int s){
        super(s,s);
    }
    /**
     * Makes a square with the specified size and color.
     * @param s the size of the square
     * @param f the color of the square
     */
    public Square(int s, Paint f){
        super(s,s,f);
    }
    /**
     * Helper method to set the color of a square.
     * Shorthand for this.setFill(f).
     * @param f the color to set the square to
     */
    public void setColor(Paint f){
        setFill(f);
    }
}
