package controller;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    private final JsonReader jsonReader = new JsonReader();

    @Test
    void shouldBuildSudokuGrid() throws IOException, ParseException {
        // given
        String filePath = "src/test/resources/valid-sudoku-input.json";
        int[]expectedLine1 = {9,0,0,1,0,0,0,0,5};
        int[]expectedLine2 = {0,0,5,0,9,0,2,0,1};
        int[]expectedLine3 = {8,0,0,0,4,0,0,0,0};
        int[]expectedLine4 = {0,0,0,0,8,0,0,0,0};
        int[]expectedLine5 = {0,0,0,7,0,0,0,0,0};
        int[]expectedLine6 = {0,0,0,0,2,6,0,0,9};
        int[]expectedLine7 = {2,0,0,3,0,0,0,0,6};
        int[]expectedLine8 = {0,0,0,2,0,0,9,0,0};
        int[]expectedLine9 = {0,0,1,9,0,4,5,7,0};


        // when
        JsonReaderResponse jsonReaderResponse = jsonReader.readJson(filePath);
        int[][] sudokuGrid = jsonReaderResponse.getSudokuGrid();

        // then
        assertFalse(jsonReaderResponse.hasErrors());
        assertEquals(9, sudokuGrid.length);
        assertArrayEquals(expectedLine1, sudokuGrid[0]);
        assertArrayEquals(expectedLine2, sudokuGrid[1]);
        assertArrayEquals(expectedLine3, sudokuGrid[2]);
        assertArrayEquals(expectedLine4, sudokuGrid[3]);
        assertArrayEquals(expectedLine5, sudokuGrid[4]);
        assertArrayEquals(expectedLine6, sudokuGrid[5]);
        assertArrayEquals(expectedLine7, sudokuGrid[6]);
        assertArrayEquals(expectedLine8, sudokuGrid[7]);
        assertArrayEquals(expectedLine9, sudokuGrid[8]);
    }

    @Test
    void shouldReturnInputPathError() throws IOException, ParseException {
        // given
        String filePath = "";

        // when
        JsonReaderResponse jsonReaderResponse = jsonReader.readJson(filePath);

        // then
        assertTrue(jsonReaderResponse.hasErrors());
        assertEquals("Given path is not valid", jsonReaderResponse.getMessage());
    }

    @Test
    void shouldReturnInputFileError() throws IOException, ParseException {
        // given
        String filePath1 = "src/test/resources/invalid-sudoku-input.json";
        String filePath2 = "src/test/resources/invalid-sudoku-input2.json";

        // when
        JsonReaderResponse jsonReaderResponse1 = jsonReader.readJson(filePath1);
        JsonReaderResponse jsonReaderResponse2 = jsonReader.readJson(filePath2);

        // then
        assertTrue(jsonReaderResponse1.hasErrors());
        assertTrue(jsonReaderResponse2.hasErrors());
        assertEquals("Given input file is not valid", jsonReaderResponse1.getMessage());
        assertEquals("Given input file is not valid", jsonReaderResponse2.getMessage());
    }

}
