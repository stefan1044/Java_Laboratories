package lab2;

import java.util.Random;

public class Lab2 {

    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();

        lab2.compulsory();
        lab2.homework();
        lab2.bonus();
    }

    void compulsory() {
        Location l1 = new Location("Mc", 12, 13);
        Location l2 = new Location("Kfc", 10, 15);
        Location l3 = new Location("Bathroom", 11, 11);

        Road r1 = new Road(roadType.highway, 1235, 50, l1, l2);
        //new Road(roadType.country, 1, 120, l1, l3);  <---- This will throw because of length

        System.out.println(l1);
        System.out.println(l3);
        System.out.println((r1));

    }

    void homework() {
        City l1 = new City("McDonald's", 12, 13, 8_000_000);
        Airport l2 = new Airport("Kfc", 10, 15, 28);
        GasStation l3 = new GasStation("Bathroom", 11, 11, 6.80);
        City l4 = new City("Dubai", 19, 37, 6_000_000);
        Location[] locations = {l1, l2, l3, l4};

        Road r1 = new Road(roadType.highway, 1235, 50, l1, l2);
        Road r2 = new Road(roadType.express, 110, 70, l2, l3);
        Road r3 = new Road(roadType.country, 4000, 110, l1, l4);
//        Road[] roadsThrow = {r1, r2, r1};
//        Problem pThrow = new Problem(locations, roadsThrow); <--- This will throw cause of duplicates
        Road[] roads = {r1, r2, r3};


        Problem p1 = new Problem(locations, roads);
        System.out.println("Check to see if p1 is valid: " + p1.isValid());
        System.out.println("Check to see if there is path between l1 and l3: " + p1.isPath(l1, l3));
        System.out.println("Check to see if there is path between l2 and l4: " + p1.isPath(l2, l4));

    }

    void bonus() {
        City l1 = new City("McDonald's", 12, 13, 8_000_000);
        Airport l2 = new Airport("Kfc", 10, 15, 28);
        GasStation l3 = new GasStation("Bathroom", 11, 11, 6.80);
        City l4 = new City("Dubai", 19, 37, 6_000_000);
        Location[] locations = {l1, l2, l3, l4};

        Road r1 = new Road(roadType.highway, 1235, 50, l1, l2);
        Road r2 = new Road(roadType.express, 110, 70, l2, l3);
        Road r3 = new Road(roadType.country, 4000, 110, l1, l4);
        Road[] roads = {r1, r2, r3};

        Solution s1 = new Solution(locations, roads, l1, l3);

        Road[] route = s1.bestRoute(routeType.shortest);

        System.out.println("Shortest route is:");
        for (Road road : route) {
            System.out.println(road);
        }

        String[] cityNames = {"City1", "City2", "City3", "City4", "City5", "City6", "City7", "City8", "City9", "City10"};
        int[] coordinates = {5, 10, 15, 25, 35, 40, 45, 50, 55, 60};
        int[] populations = {100_000, 200_000, 500_000, 1_000_000, 2_000_000, 3_000_000, 4_000_000, 5_000_000, 8_000_000,
                10_000_000};


        roadType[] roadTypes = {roadType.highway, roadType.country, roadType.express};
        double[] length = {100, 250, 350, 500, 850, 950, 1000, 1010, 1050, 1100};
        int[] speedLimits = {100, 120, 140, 150, 160, 170, 180, 190, 200, 210};

        int testLocationsSize = 500;
        int testRoadsSize = 1500;
        Location[] testLocations = new Location[testLocationsSize];
        Road[] testRoads = new Road[testRoadsSize];

        Random rng = new Random(System.currentTimeMillis());
        for (int index = 0; index < testLocationsSize; index++) {
            testLocations[index] = new City(cityNames[rng.nextInt(10)], coordinates[rng.nextInt(10)],
                    coordinates[rng.nextInt(10)], populations[rng.nextInt(10)]);
        }

        for (int index = 0; index < testRoadsSize; index++) {
            testRoads[index] = new Road(roadTypes[rng.nextInt(3)], length[rng.nextInt(10)],
                    speedLimits[rng.nextInt(10)], testLocations[rng.nextInt(testLocationsSize)],
                    testLocations[rng.nextInt(testLocationsSize)]);
        }

        Solution s2 = new Solution(testLocations, testRoads, testLocations[rng.nextInt(testLocationsSize)],
                testLocations[rng.nextInt(testLocationsSize)]);

        long startTime = System.currentTimeMillis();
        s2.bestRoute(routeType.shortest);
        long endTime = System.currentTimeMillis();

        System.out.println("Runtime of large solution instance is:" + (endTime - startTime));

    }
}
