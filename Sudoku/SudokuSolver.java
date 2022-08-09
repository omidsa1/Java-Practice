package SecondSet.SudokuMultiThreaded;

import java.util.Arrays;

public class SudokuSolver {

    private SudokuBoard result = null;

    public SudokuSolver() {
    }


    public SudokuBoard solve(SudokuBoard board) throws Exception {
        if (board != null) {

            ThreadBoardSudoku thread1 = new ThreadBoardSudoku(board, board.getEmpty());
            thread1.start();
            thread1.join();

            if (result != null) {
                return result;
            }
            throw new Exception("Sorry :( Could not solve the given board!");
        }
        throw new Exception("An error occurred: sudoku board not found.");
    }


    public void returnBoard(SudokuBoard board) {
        result = board;
    }


    public class ThreadBoardSudoku extends Thread {

        private final SudokuBoard board;
        private final int[][] empty;

        public ThreadBoardSudoku(SudokuBoard _board, int[][] _empty) {
            board = _board;
            empty = _empty;
        }

        @Override
        public void run() {
            if (empty.length == 0) {
                returnBoard(this.board);
            } else {
                int x = empty[0][0];
                int y = empty[0][1];

                try {
                    int[] valid = board.getValidValues(x + 1, y + 1);
                    if (valid.length != 0) {
                        ThreadBoardSudoku[] threadList = new ThreadBoardSudoku[valid.length];
                        for (int i = 0; i < valid.length; i++) {

                            threadList[i] = new ThreadBoardSudoku(
                                    board.setNumber(x + 1, y + 1, valid[i]),
                                    Arrays.copyOfRange(empty, 1, empty.length)
                            );
                            threadList[i].start();
                        }

                        for (ThreadBoardSudoku threadBoardSudoku : threadList) {
                            threadBoardSudoku.join();
                        }
                    }
                } catch (Exception e) {
                    returnBoard(null);
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
