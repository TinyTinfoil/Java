import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.collections.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.beans.value.*;
import javafx.geometry.*;
//Lots of imports here...
/**
 * Makes the UI for a Game of Life.
 * @author Venkadesh Eswaranandam
 * @version May 26
 */
public class UI extends Application
{
    //Some comments were made by BlueJ, others were made by me
    private GameOfLife gl;
    private Color c1 = Color.LIGHTBLUE;
    private Color c2 = Color.BLACK;
    private Timeline loop;
    private Button playBtn;
    private NumberInput width;
    private NumberInput height;
    private Label gen;
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param stage the primary stage for this application.
     */
    public void start(Stage stage)
    {
        // Create a new grid pane
        gl = new GameOfLife(50,50);
        GridPane board = gl.getPane();
        //Put inside a VBox so items show from top to bottom.
        VBox root = new VBox();
        //adds a bit of padding
        root.setPadding(new Insets(10, 10, 10, 10));
        //adds game of life board
        root.getChildren().add(board);
        //makes a pane for holding the toolbar
        FlowPane tb = new FlowPane();
        //Adds horizantal padding
        tb.setHgap(10);
        //Centers the toolbar
        tb.setAlignment(Pos.CENTER);
        ObservableList toolbar = tb.getChildren();
        //Makes a step button
        Button step = new Button("Step");
        //set an action on the button using method reference
        step.setOnAction(this::simulate);
        //Add the button and label into the pane
        toolbar.add(step);
        //creates play button
        playBtn = new Button("Play");
        playBtn.setOnAction(this::togglePlay);
        toolbar.add(playBtn);
        //creates resizing slider
        Label size = new Label("Size:");
        Slider slider = new Slider(1, 50,10);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setBlockIncrement(1);
        slider.setSnapToTicks(true);
        slider.valueProperty().addListener(
        (ChangeListener<Number>)
                //? extends Number means all types that extend Number, in other words its a wildcard type
                (ObservableValue<? extends Number> observableValue, 
                Number oldValue, 
                Number newValue) -> { 
                    gl.setSize(newValue.intValue());
                }
            
        );
        toolbar.add(size);
        toolbar.add(slider);
        //creates random button
        Button rnd = new Button("Fill Random");
        rnd.setOnAction(
            (EventHandler) e -> gl.fillRandom());
        toolbar.add(rnd);
        //creates clear button
        Button clr = new Button("Clear");
        clr.setOnAction(
           (EventHandler) e-> gl.clear());
        toolbar.add(clr);
        //Need to create new flow pane so it appears on new line
        FlowPane dim = new FlowPane();
        width = new NumberInput();
        height = new NumberInput();
        Button boardDim = new Button("Change Dimensions:");
        boardDim.setOnAction(e -> {
            gl = new GameOfLife(width.getValue(),height.getValue());
            gl.setColors(c1,c2);
            root.getChildren().remove(0);
            root.getChildren().add(0,gl.getPane());
        });
        dim.getChildren().add(boardDim);
        //Width and height boxes shouldn't be apart
        dim.getChildren().add(new FlowPane(width,height));
        dim.setHgap(10);
        //centers these controls as well, since these are on a new line.
        dim.setAlignment(Pos.CENTER);
        //Adds to root.
        root.getChildren().add(tb);
        root.getChildren().add(dim);
        //Adds color pickers with the actions that should occur when the value changes
        ColorPicker colorPicker1 = new ColorPicker();
        colorPicker1.setValue(Color.LIGHTBLUE);
        colorPicker1.setOnAction((EventHandler)
                t -> {
                    c1 = colorPicker1.getValue();
                    gl.setColors(c1,c2);
                }
            );
        ColorPicker colorPicker2 = new ColorPicker();
        colorPicker2.setValue(Color.BLACK);
        colorPicker2.setOnAction((EventHandler) 
                t -> {
                    c2 = colorPicker2.getValue();
                    gl.setColors(c1,c2);
                }
            );
        FlowPane colors = new FlowPane(new Label("Active Color:"),colorPicker1,new Label("Inactive Color:"),colorPicker2);
        colors.setHgap(10);
        colors.setAlignment(Pos.CENTER);
        root.getChildren().add(colors);
        //adds generation label
        gen = new Label("0");
        gen.setText(" "+ gl.getGeneration());
        FlowPane genLabel = new FlowPane(new Label("Generation:"),gen);
        genLabel.setAlignment(Pos.CENTER);
        root.getChildren().add(genLabel);
        //centers root
        root.setAlignment(Pos.CENTER);
        //Setting everything inside a scroll pane so that it is able to be resized
        ScrollPane scroll = new ScrollPane();
        scroll.setContent(root);
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(scroll,700,700);
        stage.setTitle("Game of Life");
        stage.setScene(scene);
        stage.sizeToScene();
        // Show the Stage (window)
        stage.show();
        //The Timeline is a way for JavaFX to run a function depending on time
        loop = new Timeline(
            //It uses KeyFrame objects that store the time...
            new KeyFrame(Duration.seconds(0.1), 
                //...and the action to be ran 
                ((EventHandler) this::simulate)
            )
        );
        //Indefinate makes the timeline run continuously
        loop.setCycleCount(Timeline.INDEFINITE);
    }
    /**
     * This will be executed to update the simulation
     * It keeps track of the time that GameOfLife.simulate() takes to run
     * @param event Has no use, only exists to allow it to override the EventHandler parameter
     */
    private void simulate(Object event)
    {
        gl.simulate();
        gen.setText(" "+gl.getGeneration());
    }
    /**
     * Toggles playback 
     * @param event Has no use, only exists to allow it to override the EventHandler parameter
     * @see UI#simulate
     */
    private void togglePlay(Object event){
        //Can use == because we are comparing object referances
        if(loop.getStatus()==Animation.Status.RUNNING){
            loop.stop();
            playBtn.setText("Play");
        } else{
            loop.play();
            playBtn.setText("Pause");
        }
    }
}