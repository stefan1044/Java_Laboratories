package lab4;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    private final String name;
    private final ArrayList<Project> projects;

    Student(String name) {
        this.name = name;
        projects = new ArrayList<Project>();
    }

    Student(String name, ArrayList<Project> projects) {
        this.name = name;
        this.projects = projects;
    }


    @Override
    public int compareTo(Student other) {
        if (other == null)
            throw new NullPointerException("Tried comparing to null Student!");
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Student:" + this.name /*+  " with projects: " + this.projects.toString() + "\n"*/;
    }

    public String getName() {
        return name;
    }

    public Project getProject(int index) {
        return this.projects.get(index);
    }

    public ArrayList<Project> getProjects() {
        return this.projects;
    }

    public int getNumberOfProjects() {
        return this.projects.size();
    }
}
