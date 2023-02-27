package lab2;

/**
 * Class that describes a gas station. Extends Location.
 *
 * @author Harabagiu Stefan
 */
public class GasStation extends Location {
    private double gasPrice;

    /**
     * Sole constructor which sets all the attributes of this object
     *
     * @param name     name of the gas station
     * @param x        x coordinate
     * @param y        y coordinate
     * @param gasPrice the price of gas
     */
    GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.setGasPrice(gasPrice);
    }

    /**
     * Overridden method to set this objects type
     */
    @Override
    protected void setType() {
        this.type = "GasStation";
    }

    /**
     * Default getter for this object's gas price
     *
     * @return this object's gas price
     */
    public double getGasPrice() {
        return this.gasPrice;
    }

    /**
     * Default setter for this object's gas price
     *
     * @param gasPrice the gas price for this object to have
     */
    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}
