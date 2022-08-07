package SecondSet.MatrixMultiplicationMultiThreaded;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    public static int[][] multiply(int[][] Matrix1, int[][] Matrix2, int[][] Result) {
        List<Object> threads = new ArrayList<>();
        int Rows1 = Matrix1.length;
        for (int i = 0; i < Rows1; i++) {
            RowMultiplier task = new RowMultiplier(Result, Matrix1, Matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }
        return Matrix1;
    }


}
