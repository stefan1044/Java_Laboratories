package lab2;

/**
 * Class that describes an airport. Extends Location.
 *
 * @author Harabagiu Stefan
 */
public class Airport extends Location {
    private int terminals;

    /**
     * Sole constructor which sets all the attributes of this object
     *
     * @param name      name of the airport
     * @param x         x coordinate
     * @param y         y coordinate
     * @param terminals number of terminals
     */
    Airport(String name, double x, double y, int terminals) {
        super(name, x, y);
        this.setTerminals(terminals);
    }

    /**
     * Overridden method to set this objects type
     */
    @Override
    protected void setType() {
        this.type = "Airport";
    }

    /**
     * Default getter for this object's terminals
     *
     * @return this object's number of terminals
     */
    public int getTerminals() {
        return terminals;
    }

    /**
     * Default setter for this object's terminals
     *
     * @param terminals the number of terminals for this object to have
     */
    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }
}
