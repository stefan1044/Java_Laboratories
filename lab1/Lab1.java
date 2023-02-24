package lab1;

public class Lab1 {
    public static void main(String[] args) {

        Lab1 lab1 = new Lab1();

        lab1.compulsory();

        int exercise2Argument1;
        int exercise2Argument2;
        int exercise2Argument3;

        try {
            exercise2Argument1 = Integer.parseInt(args[0]);
            exercise2Argument2 = Integer.parseInt(args[1]);
            exercise2Argument3 = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("Arguments provided for exercise 2 are not integers!");
            return;
        }
        lab1.homework(exercise2Argument1);

        lab1.bonus(exercise2Argument1, exercise2Argument2, exercise2Argument3);


    }

    void compulsory() {
        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

        n = n * 3 + 0b10101 + 0xFF;
        int result = n * 6;

        int temporarySum = 0;
        while (result > 9) {
            while (result != 0) {
                temporarySum += result % 10;
                result /= 10;
            }
            result = temporarySum;
            temporarySum = 0;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    void homework(int n) {

        if (n < 1) {
            System.out.println("n has to be greater than 0");
            return;
        }

        int[][] latinSquare = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                latinSquare[i][j] = (i + j) % n + 1;
            }
        }

        String[][] output = new String[2][n];
        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder(), column = new StringBuilder();
            for (int j = 0; j < n; j++) {
                line.append(latinSquare[i][j]);
                column.append(latinSquare[j][i]);
            }
            output[0][i] = line.toString();
            output[1][i] = column.toString();

/*
            System.out.println("Line "+ Integer.toString(i + 1) + " is: " + line.toString() + "\n" +
                    "Column " + Integer.toString(i + 1) + " is: " + column.toString());
*/
        }

        if (n >= 30_000) {
            System.out.println(System.currentTimeMillis());
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Line " + (i + 1) + " is: " + output[0][i] + "\n" +
                    "Column " + (i + 1) + " is: " + output[1][i]);
        }

    }

    void bonus(int n, int edges, int k) {

        if (n < 3) {
            throw new RuntimeException("Cannot create cycle graph with less than 3 nodes!");
        }

        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            adjacencyMatrix[i][i + 1] = 1;
            adjacencyMatrix[i + 1][i] = 1;
        }
        adjacencyMatrix[n - 1][0] = 1;
        adjacencyMatrix[0][n - 1] = 1;

        //matrix.print(adjacencyMatrix);

        int[][] cycleMatrix;
        cycleMatrix = adjacencyMatrix.clone();

        System.out.println("Adjacency Matrix:");
        matrix.print(cycleMatrix);

        for (int i = 1; i < n; i++) {
            int[][] tempMatrix = matrix.multiply(cycleMatrix, adjacencyMatrix);
            cycleMatrix = tempMatrix.clone();
        }
        System.out.println("Adjacency matrix at the power " + n);
        matrix.print(cycleMatrix);

        if (edges < k + 1) {
            throw new RuntimeException("Number of edges cannot be less than or equal to k!");
        }
        if (edges * k % 2 != 0) {
            throw new RuntimeException("Graph cannot be " + k + " regular!");
        }

        System.out.println("Regular graph matrix with " + edges + " edges and k = " + k);
        int[][] regularMatrix = new int[edges][edges];
        for (int i = 0; i < edges; i++) {
            for (int j = i + 1; j <= i + k / 2 && j < edges; j++) {
                regularMatrix[i][j] = 1;
                regularMatrix[j][i] = 1;
            }
            if (i - k / 2 < 0) {
                for (int j = edges - 1; j > edges - 1 + i - k / 2; j--) {
                    regularMatrix[i][j] = 1;
                    regularMatrix[j][i] = 1;
                }
            }
            if (i < edges / 2 && k % 2 == 1) {
                regularMatrix[i][i + edges / 2] = 1;
                regularMatrix[i + edges / 2][i] = 1;
            }
        }
        matrix.print(regularMatrix);

    }


}