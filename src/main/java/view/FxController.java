package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import org.json.simple.parser.ParseException;
import solver.SudokuSolver;
import controller.JsonReader;
import controller.JsonReaderResponse;
import java.io.File;
import java.io.IOException;

public class FxController {
    private SudokuSolver sudokuSolver = new SudokuSolver();

    // build the Grid Tables
    private void drawTables(TableView tableView){
        TableColumn<SudokuRow, String> tableColumn1 = new TableColumn("");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn<SudokuRow, String> tableColumn2 = new TableColumn("");
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("b"));
        TableColumn<SudokuRow, String> tableColumn3 = new TableColumn("");
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("c"));
        TableColumn<SudokuRow, String> tableColumn4 = new TableColumn("");
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("d"));
        TableColumn<SudokuRow, String> tableColumn5 = new TableColumn("");
        tableColumn5.setCellValueFactory(new PropertyValueFactory<>("e"));
        TableColumn<SudokuRow, String> tableColumn6 = new TableColumn("");
        tableColumn6.setCellValueFactory(new PropertyValueFactory<>("f"));
        TableColumn<SudokuRow, String> tableColumn7 = new TableColumn("");
        tableColumn7.setCellValueFactory(new PropertyValueFactory<>("g"));
        TableColumn<SudokuRow, String> tableColumn8 = new TableColumn("");
        tableColumn8.setCellValueFactory(new PropertyValueFactory<>("h"));
        TableColumn<SudokuRow, String> tableColumn9 = new TableColumn("");
        tableColumn9.setCellValueFactory(new PropertyValueFactory<>("i"));

        tableView.getColumns().add(tableColumn1);
        tableView.getColumns().add(tableColumn2);
        tableView.getColumns().add(tableColumn3);
        tableView.getColumns().add(tableColumn4);
        tableView.getColumns().add(tableColumn5);
        tableView.getColumns().add(tableColumn6);
        tableView.getColumns().add(tableColumn7);
        tableView.getColumns().add(tableColumn8);
        tableView.getColumns().add(tableColumn9);
    }

    @FXML
    private ListView<String> listViewLoad;
    @FXML
    private TableView tableViewLoad;
    @FXML
    private TableView tableViewSolved;
    @FXML
    private Label actionTargetLoad;
    @FXML
    private Label actionTargetSolved;
    @FXML
    private Label actionTarget;
    @FXML
    private String path;

    //on Button Load event choose a JSON-file an display it
    @FXML
    public void onLoad(ActionEvent event) throws IOException, ParseException{
        FileChooser fc = new FileChooser();


        fc.setTitle("Wähle ein Json-File aus");
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JSON", "*.json")
        );
        File seletedFile = fc.showOpenDialog(null);

        if (seletedFile != null) {
            listViewLoad.getItems().add(seletedFile.getAbsolutePath());
            sudokuSolver.getBoard();
            drawTables(tableViewLoad);
            JsonReader jsonReader = new JsonReader();
            JsonReaderResponse jsonReaderResponse = jsonReader.readJson(seletedFile.getPath());
            if(jsonReaderResponse.hasErrors()) {
                // show error message to user
                actionTarget.setText(jsonReaderResponse.getMessage());
            } else {
                int[][] board = jsonReaderResponse.getSudokuGrid();
                SudokuSolver sudoku = new SudokuSolver(board);
                sudoku.getBoard();
                int[][] solution = sudoku.getBoard();
                for(int r = 0; r < 9; r++) {
                    SudokuRow sudokuRow = new SudokuRow(
                            solution[r][0],
                            solution[r][1],
                            solution[r][2],
                            solution[r][3],
                            solution[r][4],
                            solution[r][5],
                            solution[r][6],
                            solution[r][7],
                            solution[r][8]);
                    tableViewLoad.getItems().add(sudokuRow);
                }
            }
            // show error message to user
            actionTarget.setText(jsonReaderResponse.getMessage());
            actionTargetLoad.setText("Loaded");
            path = seletedFile.getAbsolutePath();
        } else {
            actionTargetLoad.setText("Not found");
        }
    }

    //on Button Solve event show solved Grid
    @FXML
    protected void onSolve(ActionEvent event) throws IOException, ParseException {
        sudokuSolver.getBoard();
        drawTables(tableViewSolved);
        JsonReader jsonReader = new JsonReader();
        JsonReaderResponse jsonReaderResponse = jsonReader.readJson(path);
        if(jsonReaderResponse.hasErrors()) {
            // show error message to user
            System.out.println(jsonReaderResponse.getMessage());
        } else  {
            int[][] board = jsonReaderResponse.getSudokuGrid();
            SudokuSolver sudoku = new SudokuSolver(board);
            sudoku.solve();
            int[][] solution = sudoku.getBoard();
            for(int r = 0; r < 9; r++) {
                SudokuRow sudokuRow = new SudokuRow(
                        solution[r][0],
                        solution[r][1],
                        solution[r][2],
                        solution[r][3],
                        solution[r][4],
                        solution[r][5],
                        solution[r][6],
                        solution[r][7],
                        solution[r][8]);
                tableViewSolved.getItems().add(sudokuRow);
                actionTargetSolved.setText("Solved");
            }
        }
    }
}

