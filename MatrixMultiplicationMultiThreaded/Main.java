package SecondSet.MatrixMultiplicationMultiThreaded;

public class Main {

        public static void main(String[] args) {

            int[][] Matrix1 = MatrixCreator.produceMatrix(20, 15);
            int[][] Matrix2 = MatrixCreator.produceMatrix(15, 40);

            int[][] Result = new int[Matrix1.length][Matrix2[0].length];
            MatrixCreator.print(ThreadManager.multiply(Matrix1, Matrix2, Result));


    }
}
