package lab2;

/**
 * Class to determine the shortest or fastest path between two Locations. Best path refers to shortest or fastest
 * path.
 *
 * @author Harabagiu Stefan
 */
public class Problem {

    private final Location[] locations;
    private final Road[] roads;


    /**
     * Sole constructor. (For invocation by subclass
     * constructors, typically implicit.)
     *
     * @param locations array of locations from which we can find best path
     * @param roads     array of roads through which to search when finding best path
     */
    Problem(Location[] locations, Road[] roads) {
        this.locations = locations.clone();
        this.roads = roads.clone();

    }

    /**
     * Method to check if a problem instance is valid. A problem instance is valid if there are no duplicate Locations
     * or Roads.
     *
     * @return true if the problem instance is valid, false otherwise
     */
    public boolean isValid() {
        for (int i = 0; i < this.locations.length - 1; i++) {
            for (int j = i + 1; j < this.locations.length; j++) {
                if (this.locations[i] == this.locations[j])
                    return false;
            }
        }

        for (int i = 0; i < roads.length - 1; i++) {
            for (int j = i + 1; j < roads.length; j++) {
                if (roads[i] == roads[j])
                    return false;
            }
        }

        return true;
    }

    /**
     * Method to check if it is possible to go from one Location to another with the existing Roads.
     *
     * @param location1 Location from which to start
     * @param location2 Location to which a path will be checked if it exists
     * @return true if a path exists, false otherwise
     */
    public boolean isPath(Location location1, Location location2) {

        // get the index of the given locations. If the locations do not exist in the problem instance, throw an error
        int location1Index = -1, location2Index = -1;
        for (int index = 0; index < this.locations.length; index++) {
            if (this.locations[index] == location1) {
                location1Index = index;
            }
            if (this.locations[index] == location2) {
                location2Index = index;
            }
        }
        if (location1Index == -1) {
            throw new RuntimeException("First location provided does not belong to problem locations!");
        }
        if (location2Index == -1) {
            throw new RuntimeException("Second location provided does not belong to problem locations!");
        }

        // adjacency matrix to be used for BFS algorithm
        boolean[][] adjacencyMatrix = new boolean[this.locations.length][this.locations.length];
        for (Road road : this.roads) {
            int fromLocationIndex = -1, toLocationIndex = -1;
            Location fromLocation = road.getLocation(0);
            Location toLocation = road.getLocation(1);
            for (int index = 0; index < this.locations.length; index++) {
                if (fromLocation == this.locations[index]) {
                    fromLocationIndex = index;
                }
                if (toLocation == this.locations[index]) {
                    toLocationIndex = index;
                }
            }
            if (fromLocationIndex != -1 && toLocationIndex != -1) {
                adjacencyMatrix[fromLocationIndex][toLocationIndex] = true;
            }
        }

        // BFS algorithm. If location2 is visited upon finishing the search, then there is a path between location1 and
        // location 2
        int[] queue = new int[this.locations.length];
        boolean[] visitedLocation = new boolean[this.locations.length];
        int queueTop = 1, queueBottom = 0;
        queue[0] = location1Index;

        while (queueBottom != queueTop) {
            for (int index = 0; index < locations.length; index++) {
                if (adjacencyMatrix[queue[queueBottom]][index] && !visitedLocation[index]) {
                    queue[queueTop] = index;
                    visitedLocation[index] = true;
                    queueTop++;
                }
            }
            queueBottom++;
        }

        return visitedLocation[location2Index];
    }
}
