package lab4;

public class Project implements Comparable<Project>{

    private final String name;

    Project(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Project other) {
        if (other == null)
            throw new NullPointerException("Tried comparing to null Project!");
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString(){
        return this.name + " ";
    }

    public String getName() {
        return name;
    }
}
