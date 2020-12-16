package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;


public class JsonReader {
    // read Json-file
    public JsonReaderResponse readJson(String filePath) throws IOException, ParseException {
        JsonReaderResponse response = new JsonReaderResponse();
        int [][] sudokuGrid = new int[9][9];

        if(filePath.isEmpty()) {
            //System.out.println("Given path is not valid!!");
            response.setHasErrors(true);
            response.setMessage("Given path is not valid");
            return response;
        }
        Reader reader = new FileReader(filePath);

        // creates a new JSONParser
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        if(!isValidInput(jsonObject)) {
            //System.out.println("Given input file is not valid!!");
            response.setHasErrors(true);
            response.setMessage("Given input file is not valid");
            return response;
        }

        //System.out.println(jsonObject);
        JSONArray sudokuGridInput = (JSONArray) jsonObject.get("sudokuGrid");
        for(int i = 0; i < sudokuGridInput.size(); i++) {
            JSONArray row = (JSONArray) sudokuGridInput.get(i);
            for(int j = 0; j < row.size(); j++) {
                Long value = (Long) row.get(j);
                sudokuGrid[i][j] = value.intValue();
            }
        }
        response.setSudokuGrid(sudokuGrid);
        response.setHasErrors(false);
        return response;
    }
    // check input
    private boolean isValidInput(JSONObject input) {
        JSONArray sudokuGridInput = (JSONArray) input.getOrDefault("sudokuGrid", null);
        if(sudokuGridInput == null) {
            return false;
        }
        if(sudokuGridInput.size() != 9) {
            return false;
        }
        for(int i = 0; i < sudokuGridInput.size(); i++) {
            JSONArray row = (JSONArray) sudokuGridInput.get(i);
            if(row.size() != 9) {
                return false;
            }
        }
        return true;
    }

}