package lab7;

import java.util.ArrayList;

public class Exploration {
    private final ExplorationMap explorationMap;
    private final SharedMemory sharedMemory;
    private final ArrayList<Robot> robots;

    Exploration(int n){
        this.explorationMap = new ExplorationMap(n);
        this.sharedMemory = this.explorationMap.getSharedMemory();
        this.robots = new ArrayList<>();
    }

    public void start(){
        var threads = new Thread[this.robots.size()];
        for(int i = 0;i<this.robots.size();i++){
            threads[i] = new Thread(this.robots.get(i));
            threads[i].start();
        }

        for(int i = 0;i<this.robots.size();i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Joined thread " + i);
        }
    }

    public void addRobot(String name, int x, int y){
        this.robots.add(new Robot(name, this, x, y));
    }

    public ExplorationMap getExplorationMap(){
        return this.explorationMap;
    }
}
