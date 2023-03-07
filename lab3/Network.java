package lab3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Network {

    private final List<Node> list;

    private ArrayList<ArrayList<Integer>> adjacencyList;
    boolean[] visited;

    private ArrayList<Integer> timeIn;
    private ArrayList<Integer> low;
    private int timer = 0;

    Network(List<Node> list) {
        this.list = list;
        for (Node node1 : this.list) {
            for (Node node2 : this.list) {
                if (node1.getName().equals(node2.getName())) {
                    throw new RuntimeException("Cannot have duplicate names in Network!");
                }
            }
        }
    }


    public int computeImportance(Node node) {
        if (!this.list.contains(node)) {
            throw new NoSuchElementException("Node: " + node.toString() + " is not present in the network!");
        }

        int importance = 0;
        for (Node nodeIterator : this.list) {
            if (!this.list.contains(nodeIterator)) {
                continue;
            }
            if (node.getRelation(nodeIterator) != null) {
                importance++;
            }
        }

        return importance;
    }

    public void addNode(Node node) {
        for (Node node1 : this.list) {
            if (node.getName().equals(node1.getName())) {
                throw new RuntimeException("Cannot have duplicate names in Network!");
            }
        }
        this.list.add(node);
    }

    public ArrayList<ArrayList<Object>> getSortedImportanceList() {
        ArrayList<ArrayList<Object>> importanceList = new ArrayList<>();

        for (Node nodeIterator : this.list) {
            ArrayList<Object> temporaryList = new ArrayList<>();
            temporaryList.add(computeImportance(nodeIterator));
            temporaryList.add(nodeIterator);
            importanceList.add(temporaryList);
        }

        importanceList.sort((object1, object2) -> {
            if ((Integer) object1.get(0) > (Integer) object2.get(0)) {
                return -1;
            } else if ((Integer) object1.get(0) < (Integer) object2.get(0)) {
                return 1;
            }
            return 0;
        });

        return importanceList;
    }

    private boolean dfs(int v, int p) {
        this.visited[v] = true;
        this.timer++;
        this.timeIn.add(v, timer);
        this.low.add(v, timer);
        int children = 0;
        for (int to : this.adjacencyList.get(v)) {
            if (to == p)
                continue;
            if (visited[to]) {
                this.low.add(v, Math.min(this.low.get(v), this.timeIn.get(to)));
            } else {
                dfs(to, v);
                this.low.add(Math.min(this.low.get(v), this.low.get(to)));
                if (this.low.get(to) >= this.timeIn.get(v) && p != -1)
                    return true;
                ++children;
            }
        }
        return p == -1 && children > 1;
    }

    public HashSet<Node> articulationPoints() {
        HashSet<Node> articulationPoints = new HashSet<>();

        int numberOfNodes = this.list.size();
        this.adjacencyList = new ArrayList<>();
        for(int iteration = 0;iteration<numberOfNodes;iteration++){
            adjacencyList.add(new ArrayList<>());
        }

        for (int index1 = 0; index1 < numberOfNodes; index1++) {
            for (int index2 = index1 + 1; index2 < numberOfNodes; index2++) {
                if (this.list.get(index1).getRelation(this.list.get(index2)) != null) {
                    adjacencyList.get(index1).add(index2);
                    adjacencyList.get(index2).add(index1);
                }
            }
        }

        this.visited = new boolean[numberOfNodes];

        this.timeIn = new ArrayList<>();
        this.low = new ArrayList<>();
        this.timer = 0;

        for (int index = 0; index < numberOfNodes; index++) {
            this.timeIn.add(-1);
            this.low.add(-1);
        }


        for (int index = 0; index < numberOfNodes; index++) {
            if (!visited[index] && this.dfs(index, -1))
                articulationPoints.add(this.list.get(index));
        }

        return articulationPoints;
    }


}
