package lab2;

public class Lab2 {

    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();

        lab2.compulsory();
        lab2.homework();
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

    }
}
