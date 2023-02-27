package lab2;

import java.util.Objects;

/**
 * Class to represent a location
 *
 * @author Harabagiu Stefan
 */
public class Location {

    private String name;
    protected String type;
    private double x, y;

    /**
     * Constructor to initialize a location
     *
     * @param name name of the location
     * @param x    coordinate on the X axis
     * @param y    coordinate on the Y axis
     */
    protected Location(String name, double x, double y) {
        this.setName(name);
        this.setX(x);
        this.setY(y);
        this.setType();
    }

    /**
     * Default getter for this object's name
     *
     * @return this object's name
     */
    public String getName() {
        return name;
    }

    /**
     * Default setter for this object's name
     *
     * @param name the name which this object will have
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Default getter for this object's type
     *
     * @return this object's type
     */
    public String getType() {
        return type;
    }

    /**
     * Default setter for this object's location
     */
    protected void setType() {
        this.type = "Location";
    }

    /**
     * Default getter for this object's x coordinate
     *
     * @return this object's x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Default setter for this object's x coordinate
     *
     * @param x the x coordinate which this object will have
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Default getter for this object's y coordinate
     *
     * @return this object's y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Default setter for this object's y coordinate
     *
     * @param y the y coordinate which this object will have
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Overloaded method to describe this object in a string format
     *
     * @return this object's attributes as a string
     */
    @Override
    public String toString() {
        return "Location: " + this.name + ", " + this.type + ", " + this.x + ", "
                + this.y;
    }

    /**
     * Overloaded method to check equality between two Location objects
     *
     * @param obj other object
     * @return true if objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Location)) return false;
        Location comp = (Location) obj;

        return (Objects.equals(this.name, comp.name) && Objects.equals(this.type, comp.type) && this.x == comp.x &&
                this.y == comp.y);
    }

}
