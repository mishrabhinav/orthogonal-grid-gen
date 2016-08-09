package com.slb.parser;

import com.slb.components.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;
import com.slb.utils.Globals;
import com.sun.javafx.scene.control.GlobalMenuAdapter;
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
        grid.setGridName(gridObject.getString(Globals.GRID_NAME));
        grid.setNumberOfCells(gridObject.getInt(Globals.GRID_NUMBEROFCELLS));
    }

    public void parseFile() throws JSONException {

        int numberOfCells = gridObject.getInt(Globals.GRID_NUMBEROFCELLS);
        JSONArray cells = gridObject.getJSONArray(Globals.GRID_CELLS);

        for(int i = 0; i < numberOfCells; i++) {
            JSONObject cellObject = cells.getJSONObject(i);
            JSONObject cellCentre = cellObject.getJSONObject(Globals.GRID_CELL_CENTRE);
            JSONArray cellVertices = cellObject.getJSONArray(Globals.GRID_CELL_VERTICES);
            int numberOfVertices = cellObject.getInt(Globals.GRID_CELL_NUMBEROFVERTICES);

            Cell cell = new Cell(i, new Vector(cellCentre.getDouble(Globals.GRID_VERTEX_X),
                                               cellCentre.getDouble(Globals.GRID_VERTEX_Y),
                                               cellCentre.getDouble(Globals.GRID_VERTEX_Z)));

            ArrayList<Vector> vertices = cell.getVertices();
            ArrayList<Integer> neighbours = cell.getNeighbours();

            // Add all the vertices of the grid cell.
            for(int j = 0; j < numberOfVertices; j++) {
                JSONObject vertex = cellVertices.getJSONObject(j);
                vertices.add(j, new Vector(vertex.getDouble(Globals.GRID_VERTEX_X),
                                           vertex.getDouble(Globals.GRID_VERTEX_Y),
                                           vertex.getDouble(Globals.GRID_VERTEX_Z)));

            }

            // Add all the neighbours of the grid cell.
            for(int j = 0; j < 6; j++)
                neighbours.add(j, cellObject.getJSONArray(Globals.GRID_CELL_NEIGHBOURS).getInt(j));

            grid.getCells().put(cellObject.getInt(Globals.GRID_CELL_ID), cell);
        }
    }
}
