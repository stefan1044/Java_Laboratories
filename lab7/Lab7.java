package lab7;

import java.util.ArrayList;
import java.util.Random;

public class Lab7 {

    public static void main(String[] args){
        var lab7 = new Lab7();

        lab7.compulsory();
    }

    private void compulsory(){

        boolean[][] startLocations = new boolean[5][5];
        int N = 5;

        var explore = new Exploration(N);
        Random rand = new Random();
        for(int i = 1;i<=3;i++){
            int x,y;
            while (true){
                x = rand.nextInt(N);
                y = rand.nextInt(N);
                if (!startLocations[x][y]){
                    startLocations[x][y] = true;
                    break;
                }
            }
            System.out.println("Starting location for Robot" + i + " " + x + " " + y);
            explore.addRobot("Robot" + i, x, y);
        }

        explore.start();

        System.out.println(explore.getExplorationMap());
    }
}
