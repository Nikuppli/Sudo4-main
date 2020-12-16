package solver;

import java.util.Arrays;

public class SudokuSolver{

    private int[][] board;
    public static final int EMPTY = 0;
    public static final int SIZE = 9;


    String test = "abc";
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }

    public int[][] getBoard() {
        return board;
    }
    public SudokuSolver () {
    }
    public void setGrid(int[][] board) {
        this.board = board;
    }
    public SudokuSolver(int[][] board) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
                //Arrays.copyOf(board[i][j], 0);
                //Copy of Arrays Anschauen
            }
        }
    }
    //fill numbers in row
    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[row][i] == number)
                return true;
        return false;
    }
    //fill numbers in column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (board[i][col] == number)
                return true;
        return false;
    }
    //fill numbers in box(3x3)
    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;
        return false;
    }
    //check numbers in box(3x3), row and col ok?
    private boolean isOk(int row, int col, int number) {
        return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
    }


    //Teil auslagern
    // solve the puzzle/board
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOk(row, col, number)) {
                            board[row][col] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    //show board
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

