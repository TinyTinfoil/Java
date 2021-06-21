import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameOfLifeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void toggleTest()
    {
        GameOfLife gameOfLi1 = new GameOfLife(10, 10);
        gameOfLi1.toggle(1, 1);
        Cell cell1 = gameOfLi1.get(1, 1);
        assertEquals(true, cell1.getState());
        Cell cell2 = gameOfLi1.get(1, 2);
        assertEquals(false, cell2.getState());
        gameOfLi1.toggle(1, 1);
        assertEquals(false, cell1.getState());
        gameOfLi1.clear();
        gameOfLi1.fillRandom();
        gameOfLi1.clear();
        assertEquals(false, cell1.getState());
    }
    @Test
    public void stablityTest()
    {
        GameOfLife g = new GameOfLife(10,10);
        g.toggle(5,5);g.toggle(4,5);g.toggle(3,5);
        for(int i=0;i<5;i++) g.simulate();
        assertEquals(true,g.get(4,5).getState());
    }
}


