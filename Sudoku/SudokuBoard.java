package SecondSet.SudokuMultiThreaded;


import java.util.Arrays;

public class SudokuBoard {
    private final int[][] board;
    private final int boardSize;
    private final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuBoard(int[][] _board) {
            board = _board;
            boardSize = board.length;
    }

    private int[] findAllIndexOf(int[] a, int v) {
        if (a == null) {
            return new int[0];
        }
        int[] aux = new int[9];
        int size = 0;
        int len = a.length;
        int i = 0;
        while (i < len) {
            if (a[i] == v) {
                aux[size++] = i;
            }
            i++;
        }
        if (size == 0 || size > 9) {
            return new int[0];
        }
        return Arrays.copyOf(aux, size);
    }

    private int[] searchMissingItems(int[] searchArray, int[] valuesArray) {
        int[] res = new int[9];
        int res_size = 0;
        for (int value : valuesArray) {
            if (Arrays.binarySearch(searchArray, value) < 0) {
                res[res_size++] = value;
            }
        }
        if (res_size < 9) {
            res = Arrays.copyOf(res, res_size);
        }
        return res;
    }

    private int[] getBlock(int x, int y) throws Exception {
        int[] block = new int[9];
        int index = 0;
        int i_row = (x - 1) - (x - 1) % 3;
        int i_col = (y - 1) - (y - 1) % 3;
        for (int i = i_row; i < (i_row + 3); i++) {
            for (int j = i_col; j < (i_col + 3); j++) {
                block[index++] = board[i][j];
            }
        }
        return block;
    }

    private int[] getCol(int y) throws Exception {
        int[] column = new int[9];
        for (int i = 0; i < column.length; i++) {
            column[i] = board[i][y - 1];
        }
        return column;
    }

    private int[] getRow(int x) throws Exception {
        return Arrays.copyOf(board[x - 1], board[x - 1].length);
    }

    public int[][] getEmpty() throws Exception {
        int[][] emptyPositions = new int[9 * 9][2];
        int[] columns;
        int size = 0;
        int[] row;
        int[] row_valid;

        for (int i = 0; i < 9; i++) {
            columns = findAllIndexOf(board[i], 0);

            row = getRow(i + 1);
            // sort
            Arrays.sort(row);
            row_valid = searchMissingItems(row, values);

            if (columns.length != row_valid.length) {
                throw new Exception("An error occurred: sudoku board contain an error on row %d \n");
            }

            for (int column : columns) {
                emptyPositions[size][0] = i;
                emptyPositions[size][1] = column;
                size++;
            }
        }
        return Arrays.copyOf(emptyPositions, size);
    }


    public SudokuBoard setNumber(int x, int y, int value) throws Exception {
        int[][] newBoard = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = Arrays.copyOf(board[i], board.length);
        }
        if (value >= 1 && value <= 9) {
            newBoard[x - 1][y - 1] = value;
            return new SudokuBoard(newBoard);
        } else {
            throw new Exception("invalid value");
        }
    }

    public int[] getValidValues(int x, int y) throws Exception {
        if (board[x - 1][y - 1] > 0) {
            return null;
        }
        int[] block = getBlock(x, y);
        int[] row = getRow(x);
        int[] col = getCol(y);

        Arrays.sort(block);
        Arrays.sort(row);
        Arrays.sort(col);

        int[] block_valid = searchMissingItems(block, values);
        int[] row_valid = searchMissingItems(row, block_valid);
        return searchMissingItems(col, row_valid);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < boardSize; i++) {
            String[] strArray = Arrays.stream(board[i])
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            s += String.format(" %s %s %s   %s %s %s   %s %s %s \n", (Object[]) strArray);
        }
        return s;
    }
}
