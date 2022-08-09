package SecondSet.SudokuMultiThreaded;

public class SudokuProgram {

    private final SudokuBoard board;
    private final SudokuSolver solver;

    SudokuProgram(int[][] board) {
        this.board = new SudokuBoard(board);
        this.solver = new SudokuSolver();
    }


    public void startProgram() throws Exception {
        SudokuBoard result;
        System.out.println(this.board);
        result = solver.solve(this.board);
        System.out.println(result);
    }
}

