package lab3;

import java.util.*;

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

        createAdjacencyLists();
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
        createAdjacencyLists();
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

    private void createAdjacencyLists() {
        this.adjacencyList = new ArrayList<>();
        for (int iteration = 0; iteration < this.list.size(); iteration++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int index1 = 0; index1 < this.list.size(); index1++) {
            for (int index2 = index1 + 1; index2 < this.list.size(); index2++) {
                if (this.list.get(index1).getRelation(this.list.get(index2)) != null) {
                    adjacencyList.get(index1).add(index2);
                    adjacencyList.get(index2).add(index1);
                }
            }
        }
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

    public ArrayList<Node> articulationPoints() {
        HashSet<Node> articulationPoints = new HashSet<>();

        int numberOfNodes = this.list.size();

        this.timeIn = new ArrayList<>();
        this.low = new ArrayList<>();
        this.timer = 0;

        for (int index = 0; index < numberOfNodes; index++) {
            this.timeIn.add(-1);
            this.low.add(-1);
        }


        for (int index = 0; index < numberOfNodes; index++) {
            this.visited = new boolean[numberOfNodes];
            if (!visited[index] && this.dfs(index, -1))
                articulationPoints.add(this.list.get(index));
        }

        return new ArrayList<>(articulationPoints);
    }


    public ArrayList<ArrayList<Node>> identifyBlocks() {
        var blocks = new ArrayList<ArrayList<Node>>();
        var cutPoints = this.articulationPoints();


        // start a dfs search from each node, and the graph formed by the search without articulation points will be a
        // block
        for (int index = 0; index < this.list.size(); index++) {
            var currentBlock = new ArrayList<Node>();
            boolean[] visited = new boolean[this.list.size()];
            var stack = new Stack<Integer>();
            int currentIndex;
            stack.add(index);
            visited[index] = true;
            while (stack.size() != 0) {
                currentIndex = stack.pop();
                for (int nodeIndex : this.adjacencyList.get(currentIndex)) {
                    // only visit nodes which are not articulation points and not visited yet
                    if (!visited[nodeIndex] && !cutPoints.contains(this.list.get(nodeIndex))) {
                        stack.add(nodeIndex);
                        visited[nodeIndex] = true;
                        currentBlock.add(this.list.get(nodeIndex));
                    }
                }
            }
            blocks.add(currentBlock);
        }


        return blocks;
    }
}
