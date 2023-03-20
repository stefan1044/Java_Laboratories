package lab4;

import org.jgrapht.Graph;
import org.jgrapht.alg.independentset.ChordalGraphIndependentSetFinder;
import org.jgrapht.alg.interfaces.IndependentSetAlgorithm;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.interfaces.VertexCoverAlgorithm;
import org.jgrapht.alg.matching.GreedyMaximumCardinalityMatching;
import org.jgrapht.alg.vertexcover.RecursiveExactVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem {

    private final ArrayList<Student> students;
    private final ArrayList<Project> projects;

    Problem(ArrayList<Student> students) {
        this.students = students;
        var tempMap = new HashMap<Project, Boolean>();

        for (var student : this.students) {
            for (int index = 0; index < student.getNumberOfProjects(); index++) {
                tempMap.put(student.getProject(index), true);
            }
        }

        this.projects = new ArrayList<>(tempMap.keySet());
    }

    private int getNumberOfStudents() {
        return this.students.size();
    }


    private Student getStudent(int index) {
        return this.students.get(index);
    }

    private Project getProject(int index) {
        return this.projects.get(index);
    }

    public void printLowerThanAveragePreferences() {
        double averagePreferences = 0;

        averagePreferences = (double) this.projects.stream().mapToInt(e -> getNumberOfStudents()).sum()
                / this.projects.size();

        double finalAveragePreferences = averagePreferences;
        this.students.stream().filter(e -> (double) getNumberOfStudents() > finalAveragePreferences)
                .forEach(System.out::println);
    }


    private void assignProject() {

    }


    public HashMap<Student, Project> greedyAlgorithm() {
        var solution = new HashMap<Student, Project>();
        var assigned = new HashMap<Project, Boolean>();
        for (var project : this.projects) {
            assigned.put(project, false);
        }


        for (var student : this.students) {
            for (var project : student.getProjects()) {
                if (!assigned.get(project)) {
                    assigned.put(project, true);
                    solution.put(student, project);
                    break;
                }
            }
        }

        return solution;
    }


    public MatchingAlgorithm.Matching<Object, DefaultEdge> maximumCardinalityMatching() {

        Graph<Object, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (var project : this.projects) {
            graph.addVertex(project);
        }
        for (var student : this.students) {
            graph.addVertex(student);
            for (var project : student.getProjects()) {
                graph.addEdge(student, project);
            }
        }

        var matching = new GreedyMaximumCardinalityMatching<Object, DefaultEdge>(graph, false);

        return matching.getMatching();
    }


    public VertexCoverAlgorithm.VertexCover<Object> vertexCover() {
        Graph<Object, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (var project : this.projects) {
            graph.addVertex(project);
        }
        for (var student : this.students) {
            graph.addVertex(student);
            for (var project : student.getProjects()) {
                graph.addEdge(student, project);
            }
        }

        var cover = new RecursiveExactVCImpl<Object, DefaultEdge>(graph);

        return cover.getVertexCover();
    }

    public IndependentSetAlgorithm.IndependentSet<Object> independentSet() {
        Graph<Object, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        for (var project : this.projects) {
            graph.addVertex(project);
        }
        for (var student : this.students) {
            graph.addVertex(student);
            for (var project : student.getProjects()) {
                graph.addEdge(student, project);
            }
        }

        var set = new ChordalGraphIndependentSetFinder<Object, DefaultEdge>(graph);

        return set.getIndependentSet();
    }

}
