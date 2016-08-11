package com.slb.parser;

import com.slb.components.cells.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;
import com.slb.components.cells.HexCell;
import com.slb.components.cells.TdFCell;
import com.slb.utils.Globals;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by abhinavmishra on 01/08/2016.
 */
public class GridParser {

    private Grid grid;
    private JSONObject gridObject;

    public GridParser(Grid grid) {
        this.grid = grid;
    }

    public void loadFile(String inputFile) throws JSONException, FileNotFoundException {

        String jsonData = (new Scanner(new File(inputFile))).useDelimiter("\\Z").next();
        gridObject = new JSONObject(jsonData);
        grid.setGridName(gridObject.getString(Globals.JSON_NAME));
        grid.setNumberOfCells(gridObject.getInt(Globals.JSON_NUM_OF_CELLS));
    }

    public void parseFile() throws JSONException {

        int numberOfCells = gridObject.getInt(Globals.JSON_NUM_OF_CELLS);
        int gridType = gridObject.getInt(Globals.JSON_GRID_TYPE);
        JSONArray cells = gridObject.getJSONArray(Globals.JSON_CELLS);

        for(int i = 0; i < numberOfCells; i++) {
            JSONObject cellObject = cells.getJSONObject(i);
            JSONObject cellCentre = cellObject.getJSONObject(Globals.JSON_CELL_CENTRE);
            JSONArray cellVertices = cellObject.getJSONArray(Globals.JSON_CELL_VERTICES);
            int numberOfVertices = cellObject.getInt(Globals.JSON_CELL_NUM_OF_VERTICES);

            Cell cell = null;

            if(gridType == Globals.GRID_TYPE_HEX) {
                cell = new HexCell(i, new Vector(cellCentre.getDouble(Globals.JSON_VERTEX_X),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Y),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Z)));
            } else if(gridType == Globals.GRID_TYPE_2D5) {
                cell = new TdFCell(i, new Vector(cellCentre.getDouble(Globals.JSON_VERTEX_X),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Y),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Z)));
            } else {
                System.out.println(Globals.ERROR_JSON_GRID);
                System.exit(1);
            }

            ArrayList<Vector> vertices = cell.getVertices();
            ArrayList<Integer> neighbours = cell.getNeighbours();

            // Add all the vertices of the grid cell.
            for(int j = 0; j < numberOfVertices; j++) {
                JSONObject vertex = cellVertices.getJSONObject(j);
                vertices.add(j, new Vector(vertex.getDouble(Globals.JSON_VERTEX_X),
                                           vertex.getDouble(Globals.JSON_VERTEX_Y),
                                           vertex.getDouble(Globals.JSON_VERTEX_Z)));

            }

            // Add all the neighbours of the grid cell.
            for(int j = 0; j < 6; j++)
                neighbours.add(j, cellObject.getJSONArray(Globals.JSON_CELL_NEIGHBOURS).getInt(j));

            grid.getCells().put(cellObject.getInt(Globals.JSON_CELL_ID), cell);
        }
    }
}
