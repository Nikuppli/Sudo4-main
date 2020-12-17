package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import solver.SudokuSolver;
import controller.JsonReader;
import controller.JsonReaderResponse;

public class FxApp extends Application {

    private static Stage primaryStage;
    private static final JsonReader jsonReader = new JsonReader();
    protected static int[][] GRID_TO_SOLVE = new int[9][9];

    //Start Stage
    @Override
    public void start(Stage primaryStage) {
        FxApp.primaryStage = primaryStage;
        FxApp.primaryStage.setTitle("Sudoku-Solver");
        initRootLayout();
    }
    //initial fxml Layout
    private void initRootLayout() {
        try {
            BorderPane rootLayout = (BorderPane) FXMLLoader.loadFXML("layout", "fxml");
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Main Application
    public static void main(String[] args) throws IOException, ParseException {
        launch(args);

        JsonReaderResponse jsonReaderResponse = jsonReader.readJson("");

        GRID_TO_SOLVE = jsonReaderResponse.getSudokuGrid();
        SudokuSolver sudoku = new SudokuSolver(GRID_TO_SOLVE);
        sudoku.display();
        if (sudoku.solve()) {
            sudoku.display();
        }
    }


}
