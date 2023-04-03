package lab7;

import static java.lang.Thread.sleep;

public class Robot implements Runnable{
    private final String name;
    private boolean running;
    Exploration exploration;
    private int x, y;

    Robot(String name, Exploration exploration, int x, int y){
        this.name = name;
        this.exploration =exploration;
        this.running = true;
        this.x = x;
        this.y = y;
        this.exploration.getExplorationMap().visit(x,y,this);
    }



    public String getName() {
        return name;
    }

    @Override
    public void run() {
        int[] rowDirections = {-1, 0, 1, 0};
        int[] colDirections = {0, 1, 0, -1};
        while (this.running){
            boolean couldMove = false;
            for(int i = 0;i<4;i++){
                if ( 0<=this.x + rowDirections[i] && this.x + rowDirections[i] <
                        this.exploration.getExplorationMap().getSharedMemory().getN() && 0<=this.y + colDirections[i] &&
                        this.y + colDirections[i] < this.exploration.getExplorationMap().getSharedMemory().getN()) {
                    if (this.exploration.getExplorationMap().visit(this.x + rowDirections[i],
                            this.y + colDirections[i], this)) {

                        couldMove = true;
                        break;
                    }
                }
            }

            if (!couldMove)
                this.running = false;

            try {
                sleep((int) (Math.random()*100));
            } catch (InterruptedException e) {
                System.out.println(e);;
            }
        }
    }
}
