package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplorationMap {
    private final SharedMemory sharedMemory;
    private final ArrayList<ArrayList<ArrayList<Token>>> matrix;
    private final boolean[][] visited;
    private final Lock lock = new ReentrantLock();

    ExplorationMap(int n){
        this.sharedMemory = new SharedMemory(n);
        this.matrix = new ArrayList<ArrayList<ArrayList<Token>>>(n);

        for (int i = 0;i<n;i++) {
            this.matrix.add(new ArrayList<ArrayList<Token>>());
            for(int j = 0;j<n;j++){
                this.matrix.get(i).add(new ArrayList<Token>());
            }
        }


        this.visited = new boolean[n][n];
    }

    public boolean visit(int row, int col, Robot robot){
        boolean canVisit = false;
        this.lock.lock();
        try{
            if (!this.visited[row][col]) {
                System.out.println(robot.getName() + " visited " + row + " " + col);
                canVisit = true;
                this.visited[row][col] = true;
                this.matrix.get(row).add(col ,sharedMemory.extractTokens(sharedMemory.getN()));
            }
        }
        finally {
            lock.unlock();
        }
        return canVisit;
    }

    public SharedMemory getSharedMemory() {
        return this.sharedMemory;
    }

    @Override
    public String toString(){
        StringBuilder matrixString = new StringBuilder();
        for (int i = 0;i<this.matrix.size();i++){
            matrixString.append("Line ").append(i).append(":\n");
            for (int j = 0;j<this.matrix.get(i).size();j++){
                matrixString.append("Column ").append(j).append(": ");
                for(int k = 0;k<this.matrix.get(i).get(j).size();k++){
                    matrixString.append(this.matrix.get(i).get(j).get(k));
                }
                matrixString.append("\n");
            }
        }
        StringBuilder visitedString = new StringBuilder();
        for (int i = 0;i<this.sharedMemory.getN();i++){
            for(int j = 0;j< this.sharedMemory.getN();j++){
                visitedString.append(this.visited[i][j]).append(" ");
            }
            visitedString.append("\n");
        }
        return "Matrix values:\n" + matrixString + "\n Visited:\n" +
                visitedString;
    }
}
