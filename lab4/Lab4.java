package lab4;

import java.util.*;
import java.util.function.Supplier;
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
        Random rd = new Random();
        int NUMBER_OF_PROJECTS = 1000;
        int NUMBER_OF_STUDENTS = 1000;

        var projectList = new ArrayList<Project>(Arrays.asList(IntStream.range(0, NUMBER_OF_PROJECTS)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new)));


        Supplier<ArrayList<Project>> func = () -> {
            var projects = new ArrayList<Project>();
            Collections.shuffle(projectList);
            int numberOfProjects = rd.nextInt(NUMBER_OF_PROJECTS - 1) + 1;
            for (int index = 0; index < numberOfProjects; index++) {
                projects.add(projectList.get(index));
            }
            return projects;
        };


        var studentList = new ArrayList<Student>(Arrays.asList(IntStream.range(0, NUMBER_OF_STUDENTS)
                .mapToObj(i -> new Student("S" + i, func.get()))
                .toArray(Student[]::new)));

        var problem = new Problem(studentList);

        long time = System.currentTimeMillis();
        System.out.println(problem.greedyAlgorithm());
        time = System.currentTimeMillis() - time;
        System.out.println("Greedy time is " + time);


    }

    private void bonus() {
        Random rd = new Random();
        int NUMBER_OF_PROJECTS = 1000;
        int NUMBER_OF_STUDENTS = 1000;

        var projectList = new ArrayList<Project>(Arrays.asList(IntStream.range(0, NUMBER_OF_PROJECTS)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new)));


        Supplier<ArrayList<Project>> func = () -> {
            var projects = new ArrayList<Project>();
            Collections.shuffle(projectList);
            int numberOfProjects = rd.nextInt(NUMBER_OF_PROJECTS - 1) + 1;
            for (int index = 0; index < numberOfProjects; index++) {
                projects.add(projectList.get(index));
            }
            return projects;
        };


        var studentList = new ArrayList<Student>(Arrays.asList(IntStream.range(0, NUMBER_OF_STUDENTS)
                .mapToObj(i -> new Student("S" + i, func.get()))
                .toArray(Student[]::new)));

        var problem = new Problem(studentList);

        long time = System.currentTimeMillis();
        System.out.println(problem.maximumCardinalityMatching());
        time = System.currentTimeMillis() - time;
        System.out.println("Matching time is " + time);

    }
}
