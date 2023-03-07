package lab3;

import java.util.Date;
import java.util.HashMap;

public class Person implements Comparable<Person>, Node {

    private final String name;
    private final Date birthdate;

    private final HashMap<Node, Relations> relations = new HashMap<>();

    Person(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public Relations getRelation(Node node){
        return this.relations.get(node);
    }
    public void addRelation(Node node, Relations relation) throws NullPointerException{
        if (relation == null){
            throw new NullPointerException("Relation cannot be null!");
        }
        if (node instanceof Person && relation instanceof PersonToCompanyRelation) {
            throw new ClassCastException("Cannot add relation of type PersonToCompany between 2 Persons!");
        }
        if (node instanceof Company && relation instanceof PersonToPersonRelation){
            throw new ClassCastException("Cannot add relation of type PersonToPerson between Person and company!");
        }

        this.relations.put(node, relation);
        // This is so 2 Persons don't keep adding the relation to each-other indefinitely
        if(node instanceof Person && (node).getRelation(this) != relation){
            return;
        }
        node.addRelation(this, relation);
    }

    @Override
    public int compareTo(Person other) {
        if (other == null)
            throw new NullPointerException("Tried comparing with null object!");
        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Person: " + this.name + ", born at: " + this.birthdate.toString();
    }
}
