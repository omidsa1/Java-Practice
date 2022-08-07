package SecondSet.MatrixMultiplicationMultiThreaded;

public class RowMultiplier implements Runnable {

        private final int[][] Result;
        private final int[][] Matrix1;
        private final int[][] Matrix2;
        private final int row;

        public RowMultiplier(int[][] Result, int[][] Matrix1, int[][] Matrix2, int row) {
            this.Result = Result;
            this.Matrix1 = Matrix1;
            this.Matrix2 = Matrix2;
            this.row = row;
        }


    @Override
        public void run() {

            for (int i = 0; i < Matrix2[0].length-1; i++) {
                Result[row][i] = 0;
                for (int j = 0; j < Matrix1[row].length-1; j++) {
                    Result[row][i] += Matrix1[row][j] * Matrix2[j][i];


            }

        }

    }
}
