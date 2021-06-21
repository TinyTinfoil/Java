import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.geometry.*;
/**
 * An implementation of Conway's game of life, with support for JavaFX.
 * @author Venkadesh Eswaranandam
 * @version 2021
 */
public class GameOfLife
{
    private Cell[][] board;
    private int gen;
    private boolean[][] old;
    private Loop2D run = (r,c) -> {
                    int n = getNeighbors(r,c);
                    if (n==3) board[r][c].setState(true);
                    else if (n>3||n<2)board[r][c].setState(false);
        };
    private Loop2D fillOld = (r,c) -> old[r][c] = board[r][c].getState();
    /**
     * Makes a GOL board with the specified size.
     * @param width the width of the board
     * @param height the height of the board
     */
    public GameOfLife(int width, int height)
    {
        board = new Cell[height][width];
        old = new boolean[height][width];
        for(int r = 0; r<board.length;r++){
            for(int c = 0; c<board[0].length;c++){
                board[r][c] = new Cell();
            }
        }
        gen = 0;
    }
    /**
     *Simulates cell interaction.
     * Call this function to increase the Game of Life generation by one
     */
    public void simulate(){
        //The board's current state is copied over so that changes don't propogate to cells on futher rows and columns
        fillOld.apply(board);
        /**
         * The above is the same as creating a new class that implements Loop2D and overides the func method
         * ((Loop2D) (r,c)->old[r][c]=board[r][c].getState()).apply(board);
         * same as
         * Loop2D temp = (r,c)->old[r][c]=board[r][c].getState());
         * temp.apply(board);
         * same as
         * Loop2D<Cell> temp = (int r, int c)->old[r][c]=board[r][c].getState());
         * temp.apply(board);
         * same as
         * class Temp<T> implements Loop2D<T>{
         *     public void func(int r, int c){
         *         old[r][c]=board[r][c].getState();
         *      }
         * }
         * (new Temp<Cell>()).apply(board);
         */
        run.apply(board);
        gen++;
    }
    /**
     * Returns the number of generations the board has gone through.
     * @return the number of generations simulated.
     */
    public int getGeneration(){
        return gen;
    }
    /**
     * Toggles the state of one game of life cell.
     * @param r the row the cell is on
     * @param c the column the cell is on
     */
    public void toggle(int r, int c){
        board[r][c].setState(!board[r][c].getState());
    }
    /**
     * Fills the game of life board with a random amount of active cells.
     * Only affects cells that are currently inactive
     */
    public void fillRandom(){
        for(int r=0;r<board.length*board[0].length;r++) 
            board
            [(int)(Math.random()*board.length)]
            [(int)(Math.random()*board[0].length)].setState(true);
    }
    /**
     * Clears the game of life board (sets all cell states to false).
     */
    public void clear(){
        for(Cell[] r : board) for(Cell c : r) c.setState(false);
    }
    /**
     * Returns the neighbors that each cell has.
     * @param row the row of the cell
     * @param col the column of the cell
     * @param old the previous states of all the cells, before updating
     */
    private int getNeighbors(int row, int col){
        int count = 0;  
        //Checks each row and column by displacing it -1 -> 0 -> 1
        for(int r=-1;r<=1;r++){
            for(int c=-1;c<=1;c++){
                //avoids checking out of bounds rows
                if(!(row+r<0||col+c<0||(col+c)>=board[0].length||(row+r)>=board.length)
                &&old[row+r][col+c]) count++;
            } 
        }
        //Removes the element itself from the neighbor calculation
        if(old[row][col]) count--;
        return count;
    }
    /**
     * Prints out a textual repersentation of the board to stdout.
     * Does not modify the UI, nor access the GridPanes
     * Designed for testing
     */
    public void print(){
        for(Cell[] t:board){
            for(Cell i:t){
                if (i.getState()) System.out.print("x");
                else System.out.print("_");
            }
            System.out.println();
        }
    }
    /**
     * Gets the cell at the specified location.
     * @param r the row of the cell
     * @param c the column of the cell
     * @return the cell object at the specified row and column
     */
    public Cell get(int r, int c){
        return board[r][c];
    }
    /**
     * Gets the GridPane that contains all the game of life cells and will be
     * updated on changes.
     * @return the JavaFX GridPane that contains all the game of life cells
     */
    public GridPane getPane(){
        GridPane pane = new GridPane();
        ((Loop2D) (r,c) -> pane.add(board[r][c].display(),r,c)).apply(board);
        pane.setOnDragDetected(e -> pane.startFullDrag());
        pane.setVgap(1);
        pane.setHgap(1);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
    /**
     * Sets the active and dead colors for the entire board.
     * @param live the color for live cells
     * @param dead the color for dead cells
     */
    public void setColors(Color live, Color dead){
          ((Loop2D) (r,c) -> board[r][c].setColors(live,dead)).apply(board);
    }
    /**
     * Sets the display size of all cells for this game of life
     * @param s the size of the cells
     */
    public void setSize(int s){
         ((Loop2D) (r,c) -> board[r][c].setSize(s)).apply(board);
    }
}
