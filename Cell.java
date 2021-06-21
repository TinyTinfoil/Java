import javafx.scene.paint.*;
import javafx.event.*;
import javafx.scene.input.*;
/**
 * Repersents a game of life cell
 *
 * @author Venkadesh Eswaranandam
 * @version May 26
 */
public class Cell
{
    private Square display;
    private boolean live;
    //default colors for those who don't call setColors
    private Color active = Color.LIGHTBLUE;
    private Color inactive = Color.BLACK;
    //same with size as well
    private int size = 10;
    /**
     * The color that is painted when paintState is called.
     */
    public static boolean paint;
    /**
     * Makes a game of life cell with a false state.
     */
    public Cell()
    {
        this(false);
    }
    /**
     * Makes a game of life cell with the specified state.
     * @param state the inital state of the cell
     */
    public Cell(boolean state){
        live = state;
        /**
         * Ternary statement:
         * if(condition) x=1; else x=2;
         * is the same as
         * x = condition? 1 : 2;
         */ 
        display = new Square(size, live ? active : inactive);
        /* EventHandler is a functional interface.
         * Its basiclly a interface with methods that can be overridden by a program
         * The double colon syntax means to override that method with the one in class::methodName
         */
        EventHandler<MouseEvent> toggle = this::toggleState;
        display.setOnMouseClicked(toggle);
        display.setOnMouseDragEntered(this::paintState);
        display.setOnMouseEntered(e -> paint=this.live);
    }
    /**
     * Sets the colors of this GOL Cell.
     * @param live the color to display while active
     * @param dead the color to display while inactive
     */
    public void setColors(Color live, Color dead){
        active = live;
        inactive = dead;
        display.setColor(this.live? active : inactive);
    }
    /**
     * Sets the size of this GOL Cell.
     * @param s the size of the cell
     */
    public void setSize(int s){
        size = s;
        display.setWidth(s);
        display.setHeight(s);
    }
    /**
     * Returns the square element that displays the square.
     * @return the JavaFX square repersenting this square
     */
    public Square display(){
        return display;
    }
    /**
     * Returns the current status of the cell.
     * @return the status of this cell
     */
    public boolean getState(){
        return live;
    }
    /**
     * Sets the state of the cell.
     * @param s the state to set this cell to
     */
    public void setState(boolean s){
        if(s!=live){
            live = s;
            if(s) display.setColor(active);
            else display.setColor(inactive);
        }
    }
    /**
     * Paints the state of this cell, according to the value of paint.
     * @param o the MouseEvent that is responsable for triggering the paint action.
     */
    public void paintState(MouseEvent o){
        setState(paint);
    }
    /**
     * Toggles the state of the cell.
     * @param o the MouseEvent that is responsable for triggering this action.
     */
    public void toggleState(MouseEvent o){
        //Changes paint to opposite of what it was when mouse entered cell
        paint = !live;
        setState(!live);
    }
}
