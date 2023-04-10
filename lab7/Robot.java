package lab7;

import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private final String name;
    private final int x;
    private final int y;
    Exploration exploration;
    private boolean running;

    Robot(String name, Exploration exploration, int x, int y) {
        this.name = name;
        this.exploration = exploration;
        this.running = true;
        this.x = x;
        this.y = y;
        this.exploration.getExplorationMap().visit(x, y, this);
    }


    public String getName() {
        return name;
    }

    @Override
    public void run() {
        int[] rowDirections = {-1, 0, 1, 0};
        int[] colDirections = {0, 1, 0, -1};
        while (this.running) {
            boolean couldMove = false;
            for (int i = 0; i < 4; i++) {
                var upperBound = this.exploration.getExplorationMap().getSharedMemory().getN();
                var newX = this.x + rowDirections[i];
                var newY = this.y + colDirections[i];
                if (0 <= newX && newX < upperBound && 0 <= newY && newY< upperBound) {
                    if (this.exploration.getExplorationMap().visit(newX, newY, this)) {
                        couldMove = true;
                        break;
                    }
                }
            }

            if (!couldMove) this.running = false;

            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
