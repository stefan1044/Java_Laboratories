package lab3;

import java.util.HashMap;

public class Company implements Comparable<Company>, Node {

    private final String name;
    private final int revenue;
    private final HashMap<Person, Relations> employees;

    Company(String name, int revenue) {
        this.name = name;
        this.revenue = revenue;
        this.employees = new HashMap<>();
    }

    public int getRevenue() {
        return revenue;
    }

    public Relations getRelation(Node node) {
        if (node instanceof Company)
            return null;
        return this.employees.get((Person) node);
    }

    @Override
    public int compareTo(Company other) {
        if (other == null)
            throw new NullPointerException("Tried comparing with null object!");
        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addRelation(Node node, Relations relation) throws NullPointerException, ClassFormatError {
        if (relation == null) {
            throw new NullPointerException("Relation cannot be null!");
        }
        if (relation instanceof PersonToPersonRelation) {
            throw new ClassFormatError("Cannot add relation of type PersonToPerson between Company and Person");
        }

        if (node instanceof Person) {
            this.employees.put((Person) node, relation);
        } else {
            throw new ClassFormatError("Companies cannot have relations with another company!");
        }
    }

    @Override
    public String toString() {
        return "Company: " + this.name;
    }


}
