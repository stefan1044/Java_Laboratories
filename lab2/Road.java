package lab2;

/**
 * Class to represent a road between 2 locations
 *
 * @author Harabagiu Stefan
 */
public class Road {

    private roadType type;
    private double length;
    private int speedLimit;
    private final Location[] locations;

    /**
     * Sole constructor which sets all attributes of this object
     *
     * @param type       the type of road, is of type <code>roadType</code>
     * @param length     length of this road, cannot be shorter than euclidean distance between the Locations
     * @param speedLimit speed limit of this road
     * @param location1  first location of this road
     * @param location2  second location of this road
     */
    Road(roadType type, double length, int speedLimit, Location location1, Location location2) {
        //calculates euclidean distance between Locations
        double minDistance = Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) +
                Math.pow(location1.getY() - location2.getY(), 2));

        if (length < minDistance) {
            throw new RuntimeException("Road length cannot be smaller than euclidean distance between locations!");
        }
        this.setType(type);
        this.setLength(length);
        this.setSpeedLimit(speedLimit);

        this.locations = new Location[2];
        this.setLocation(location1, location2);
    }

    /**
     * Default getter for roadType
     *
     * @return this object's roadType
     */
    public roadType getType() {
        return type;
    }

    /**
     * Default setter for roadType
     *
     * @param type the type to which to set this objects roadType
     */
    public void setType(roadType type) {
        this.type = type;
    }

    /**
     * Default getter for length
     *
     * @return this object's length
     */
    public double getLength() {
        return length;
    }

    /**
     * Default setter for length
     *
     * @param length the value to which to set this objects length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Default getter for speedLimit
     *
     * @return this object's speedLimit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Default setter for speedLimit
     *
     * @param speedLimit the value to which to set this objects speedLimit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Default getter for Locations
     *
     * @param index the index of the locations to get. Has to be either 0 or 1
     * @return the location at position index in <code>this.locations[]</code>
     */
    public Location getLocation(int index) {
        if (index < 0 || index > 1) {
            throw new RuntimeException("Road has maximum of two locations!");
        }
        return this.locations[index];
    }

    /**
     * Default setter for Locations
     *
     * @param location1 first Location of this Road
     * @param location2 second Location of this Road
     */
    public void setLocation(Location location1, Location location2) {
        this.locations[0] = location1;
        this.locations[1] = location2;
    }

    /**
     * Overloaded method to describe this object in a string format
     *
     * @return this object's attributes as a string
     */
    @Override
    public String toString() {
        return "Road: " + this.type.toString() + ", " + this.length + ", " +
                this.speedLimit;
    }

    /**
     * Overloaded method to check equality between two Road objects
     *
     * @param obj other object
     * @return true if objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Road)) return false;
        Road comp = (Road) obj;

        return (this.type == comp.type && this.length == comp.length && this.speedLimit == comp.speedLimit &&
                this.locations[0] == comp.locations[0] && this.locations[1] == comp.locations[1]);
    }


}
