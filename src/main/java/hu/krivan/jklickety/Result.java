package hu.krivan.jklickety;

/**
 * Egyszerű objektum egy felhasználó eredményének reprezentációjához.
 *
 * @author Balint
 */
public class Result {

    private String name;
    private int points;

    public Result(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
