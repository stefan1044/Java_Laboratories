package lab3;

public interface Node{
    String getName();
    //public Relations getRelation(Node node);
    void addRelation(Node node, Relations relation);
    Relations getRelation(Node node);
}
