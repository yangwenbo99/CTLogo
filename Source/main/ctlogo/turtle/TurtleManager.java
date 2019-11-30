package ctlogo.turtle;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TurtleManager {
    private static TurtleManager instance = null;
    private ArrayList<Turtle> allTurtles;
    private Turtle activeTurtle;

    private TurtleManager() {
        allTurtles = new ArrayList<Turtle>();
        activeTurtle =  new Turtle();
        allTurtles.add(activeTurtle);
    }

    public static TurtleManager getInstance() {
        if (instance == null)
            instance = new TurtleManager();
        return instance;
    }

    public Turtle newTurtle(Turtle t) {
        allTurtles.add(t);
        return t;
    }

    /**
     *
     *
     * @param index the index of turtle
     * @return the turtle
     *
     * @throws NoSuchElementException if no such turtle found
     */
    public Turtle getTurtleByIndex(int index) {
        try {
            return allTurtles.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(
                    String.format("No such turtle at index %d", index));
        }
    }

    /**
     *
     *
     * @param index the index of turtle
     * @throws NoSuchElementException if no such turtle found
     */
    public void activateTurtleByIndex (int index) {
        activeTurtle = getTurtleByIndex(index);
    }

    public Turtle getActiveTurtle() {
        return activeTurtle;
    }

}
