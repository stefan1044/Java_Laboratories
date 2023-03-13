package lab4;

import java.util.ArrayList;

public class Student implements Comparable<Student>{

    private final String name;
    ArrayList<Project> projects;

    Student(String name){
        this.name = name;
        projects = new ArrayList<Project>();
    }

    @Override
    public int compareTo(Student other){
        if (other == null)
            throw new NullPointerException("Tried comparing to null Student!");
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
