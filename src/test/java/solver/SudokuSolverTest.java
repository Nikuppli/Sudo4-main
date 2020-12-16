package solver;

import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Test;

//Solver Test Board
public class SudokuSolverTest {

    @Test
    public void givenBoard_whenSudokuSolve_thenReturnSolvedBoard() {
        //given
        int[][] givenBoard = {
                {9, 0, 0, 1, 0, 0, 0, 0, 5},
                {0, 0, 5, 0, 9, 0, 2, 0, 1},
                {8, 0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 6, 0, 0, 9},
                {2, 0, 0, 3, 0, 0, 0, 0, 6},
                {0, 0, 0, 2, 0, 0, 9, 0, 0},
                {0, 0, 1, 9, 0, 4, 5, 7, 0}
        };

        //when
        SudokuSolver sudoku = new SudokuSolver();
        sudoku.setGrid(givenBoard);
        int[][] board = sudoku.getBoard();
        assertArrayEquals(givenBoard, board);
        sudoku.solve();

        //then
        int[][] expectedBoard = {
                {9, 3, 4, 1, 7, 2, 6, 8, 5},
                {7, 6, 5, 8, 9, 3, 2, 4, 1},
                {8, 1, 2, 6, 4, 5, 3, 9, 7},
                {4, 2, 9, 5, 8, 1, 7, 6, 3},
                {6, 5, 8, 7, 3, 9, 1, 2, 4},
                {1, 7, 3, 4, 2, 6, 8, 5, 9},
                {2, 9, 7, 3, 5, 8, 4, 1, 6},
                {5, 4, 6, 2, 1, 7, 9, 3, 8},
                {3, 8, 1, 9, 6, 4, 5, 7, 2}

        };
        board = sudoku.getBoard();
        assertArrayEquals(expectedBoard, board);
    }
}

