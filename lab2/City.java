package lab2;

/**
 * Class that describes a city. Extends Location.
 *
 * @author Harabagiu Stefan
 */
public class City extends Location {
    private int population;

    /**
     * Sole constructor which sets all the attributes of this object
     *
     * @param name       name of the city
     * @param x          x coordinate
     * @param y          y coordinate
     * @param population population of the city
     */
    City(String name, double x, double y, int population) {
        super(name, x, y);
        this.setPopulation(population);
    }

    /**
     * Overridden method to set this objects type
     */
    @Override
    protected void setType() {
        this.type = "City";
    }

    /**
     * Default getter for this object's population
     *
     * @return this object's population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Default setter for this object's population
     *
     * @param population the population for this object to have
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
