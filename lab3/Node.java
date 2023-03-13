package lab3;

public interface Node {
    String getName();

    void addRelation(Node node, Relations relation);

    Relations getRelation(Node node);
}
