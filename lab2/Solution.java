package lab2;

/**
 * Class to determine the shortest or fastest path between two Locations. Best path refers to shortest or fastest
 * path.
 *
 * @author Harabagiu Stefan
 */
public class Solution extends Problem {
    private final Location location1;
    private final Location location2;

    /**
     * Sole constructor. Initializes problem instance.
     * @param locations array of locations for the problem
     * @param roads array of roads for the problem
     * @param location1 the first location
     * @param location2 the second location
     */
    Solution(Location[] locations, Road[] roads, Location location1, Location location2){
        super(locations, roads);
        this.location1 = location1;
        this.location2 = location2;
    }

    /**
     * Algorithm to determine the best path between the locations. Uses a classic Djikstra algorithm.
     * @param type Whether to determine best path by length or time taken.
     * @return An array of roads which represent the route to take.
     */
    public Road[] bestRoute(routeType type){
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

        // adjacency matrix to be used for Djikstra algorithm, keeps both the shortest length or fastest time and
        // the specific road to take
        double[][][] adjacencyMatrix = new double[this.locations.length][this.locations.length][2];
        for (int roadIndex = 0; roadIndex < this.roads.length;roadIndex++) {
            int fromLocationIndex = -1, toLocationIndex = -1;
            Location fromLocation = this.roads[roadIndex].getLocation(0);
            Location toLocation = this.roads[roadIndex].getLocation(1);
            for (int locationIndex = 0; locationIndex < this.locations.length; locationIndex++) {
                if (fromLocation == this.locations[locationIndex]) {
                    fromLocationIndex = locationIndex;
                }
                if (toLocation == this.locations[locationIndex]) {
                    toLocationIndex = locationIndex;
                }
            }
            if (fromLocationIndex != -1 && toLocationIndex != -1) {
                //if it has to return shortest route, measure distance by length, otherwise by time
                // taken(length/speedLimit)
                if (type == routeType.shortest &&
                        (this.roads[roadIndex].getLength() < adjacencyMatrix[fromLocationIndex][toLocationIndex][0]
                        || adjacencyMatrix[fromLocationIndex][toLocationIndex][0] == 0)) {
                    adjacencyMatrix[fromLocationIndex][toLocationIndex][0] = this.roads[roadIndex].getLength();
                    adjacencyMatrix[toLocationIndex][fromLocationIndex][0] = this.roads[roadIndex].getLength();
                    adjacencyMatrix[fromLocationIndex][toLocationIndex][1] = roadIndex;
                    adjacencyMatrix[toLocationIndex][fromLocationIndex][1] = roadIndex;
                }
                else if ( this.roads[roadIndex].getLength()/this.roads[roadIndex].getSpeedLimit() <
                        adjacencyMatrix[fromLocationIndex][toLocationIndex][0] ||
                        adjacencyMatrix[fromLocationIndex][toLocationIndex][0] == 0){
                    adjacencyMatrix[fromLocationIndex][toLocationIndex][0] = this.roads[roadIndex].getLength()/
                            this.roads[roadIndex].getSpeedLimit();
                    adjacencyMatrix[toLocationIndex][fromLocationIndex][0] = this.roads[roadIndex].getLength()/
                            this.roads[roadIndex].getSpeedLimit();
                    adjacencyMatrix[fromLocationIndex][toLocationIndex][1] = roadIndex;
                    adjacencyMatrix[toLocationIndex][fromLocationIndex][1] = roadIndex;
                }
            }
        }

        //simple Djikstra algorithm
        double[] distances = new double[this.locations.length];
        int[] previous = new int[this.locations.length];
        boolean[] visited = new boolean[this.locations.length];
        visited[location1Index] = true;

        for (int index = 0;index<this.locations.length;index++){
            distances[index] = Double.MAX_VALUE;
            previous[index] = -1;
        }
        distances[location1Index] = 0;


        int[] queue = new int[this.locations.length*this.locations.length];
        int queueTop = 1, queueBottom = 0;
        double temporaryDistance;
        queue[0] = location1Index;

        while (queueBottom != queueTop){
            int currentNode = queue[queueBottom];
            //if the target node is found we can stop
            if (currentNode == location2Index)
                break;


            for(int index = 0;index < this.locations.length;index++){
                if(adjacencyMatrix[currentNode][index][0]!=0){
                    temporaryDistance = distances[currentNode] + adjacencyMatrix[currentNode][index][0];
                    if (temporaryDistance < distances[index]){
                        distances[index] = temporaryDistance;
                        previous[index] = currentNode;
                        if (!visited[index]){
                            queue[queueTop] = index;
                            queueTop++;
                        }
                    }
                }
            }

            queueBottom++;
        }


        int[] pathTaken = new int[this.locations.length];
        int pathLength = 0, currentNode = location2Index;

        //regenerate the path taken in inverse order
        while (previous[currentNode] != -1){
            pathTaken[pathLength] = previous[currentNode];
            currentNode = previous[currentNode];
            pathLength++;
        }

        Road[] route = new Road[pathLength];

        //reverse the order to return the correct route
        for(int iteration = pathLength - 1;iteration >= 0 ;iteration--){
            route[pathLength - 1 - iteration] = this.roads[pathTaken[iteration]];
        }

        return route;
    }
}
