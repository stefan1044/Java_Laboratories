package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();

        lab4.compulsory();
        lab4.homework();
        lab4.bonus();
    }

    private void compulsory() {
        var studentList = new ArrayList<Student>(Arrays.asList(IntStream.range(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new)));

        var projectList = new TreeSet<Project>(Arrays.asList(IntStream.range(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new)));

        System.out.println(studentList);
        System.out.println(projectList);
    }

    private void homework() {

    }

    private void bonus() {

    }
}
