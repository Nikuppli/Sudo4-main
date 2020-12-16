package controller;

public class JsonReaderResponse {

    private int [][] sudokuGrid;
    private String message;
    private boolean hasErrors;

    public int[][] getSudokuGrid() {
        return sudokuGrid;
    }

    public void setSudokuGrid(int[][] sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean hasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
}
