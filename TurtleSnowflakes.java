import java.util.*;
import java.awt.Turtle;
import java.lang.*;

public class TurtleSnowflakes
{
  public static void main(String[] args)
  {
      World world = new World(300,300);
      Turtle yertle = new Turtle(world);
      yertle.setColor(Color.blue);

      // Use this variable in the loops
      int turnAmount = 30;
      int n = 3;
      // 1. Write a for loop that runs many times
      // 2. Change it to use turnAmount to figure out how many times to run
      for(int i = 0; i<(360/turnAmount); i++){
         // 1 & 2. Write an inner loop that draws a triangle (3 sides, 120 degree turns)
         // 3. Then change it to be any polygon with a variable n
          for (int e = 0; e<n; e++){
              yertle.forward();
              yertle.turn(360/n);
          }
         // turn turnAmount degrees before drawing the polygon again
          yertle.turn(turnAmount);
         // 4. Add an if statement that changes the colors depending on the loop variables
          if (i%2==0) yertle.setColor(Color.red); else yertle.setColor(Color.blue);
      }
      world.show(true);
  }
}
