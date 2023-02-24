package lab1;

public class matrix {

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) {
            throw new UnsupportedOperationException("Miss-matched matrix sizes");
        }

        int[][] returnMatrix = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                returnMatrix[i][j] = 0;
                for (int k = 0; k < rows2; k++) {
                    returnMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return returnMatrix;
    }

    public static void print(int[][] matrix){
        int columns = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < columns; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
