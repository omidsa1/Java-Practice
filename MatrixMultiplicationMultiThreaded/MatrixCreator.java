package SecondSet.MatrixMultiplicationMultiThreaded;

import java.util.Random;

public class MatrixCreator {

    public static int[][] produceMatrix(int rows, int columns) {
        int[][] result = new int[rows][columns];

        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                result[i][j] = random.nextInt(100) * 10;

            }
        }

        return result;
    }

    public static void print(int[][] matrix) {

        System.out.println("\n");

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int[] ints : matrix) {
            for (int j = 0; j < columns; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }

    }

}
