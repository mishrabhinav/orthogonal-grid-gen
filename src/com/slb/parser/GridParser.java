package com.slb.parser;

import com.slb.components.cells.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;
import com.slb.components.cells.HexCell;
import com.slb.components.cells.TdFCell;
import com.slb.utils.Globals;
import com.slb.utils.Utils;
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
        grid.setGridName(gridObject.getString(Globals.JSON_NAME));
        grid.setNumberOfCells(gridObject.getJSONArray(Globals.JSON_CELLS).length());
    }

    public void parseFile() throws JSONException {

        int gridType = gridObject.getInt(Globals.JSON_GRID_TYPE);
        int cellLayers = gridType == Globals.GRID_TYPE_HEX ? 1 : gridObject.getInt("layers");

        JSONArray cells = gridObject.getJSONArray(Globals.JSON_CELLS);
        int numberOfCells =  gridObject.getJSONArray(Globals.JSON_CELLS).length() * cellLayers;

        for(int i = 0; i < numberOfCells; i++) {
            int j = i;

            if(gridType == Globals.GRID_TYPE_2D5)
                i = i % (numberOfCells / cellLayers);

            JSONObject cellObject = cells.getJSONObject(i);

            Cell cell = null;

            if(gridType == Globals.GRID_TYPE_HEX) {
                cell = initHexCell(cellObject, i);
            } else if(gridType == Globals.GRID_TYPE_2D5) {
                int layerHeight = gridObject.getInt("layerHeight");
                cell = init2D5Cell(cellObject, i, numberOfCells, cellLayers, layerHeight);
            } else {
                System.out.println(Globals.ERROR_JSON_GRID);
                System.exit(1);
            }

            grid.getCells().put(cellObject.getInt(Globals.JSON_CELL_ID), cell);

            i = j;
        }
    }

    private Cell initHexCell(JSONObject cellObject, int cellID) throws JSONException {
        JSONObject cellCentre = cellObject.getJSONObject(Globals.JSON_CELL_CENTRE);
        JSONArray cellVertices = cellObject.getJSONArray(Globals.JSON_CELL_VERTICES);
        int numberOfVertices = cellVertices.length();

        Cell cell = new HexCell(cellID, new Vector(cellCentre.getDouble(Globals.JSON_VERTEX_X),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Y),
                        cellCentre.getDouble(Globals.JSON_VERTEX_Z)));

        ArrayList<Vector> vertices = cell.getVertices();
        ArrayList<Integer> neighbours = cell.getNeighbours();

        for(int j = 0; j < numberOfVertices; j++) {
            JSONObject vertex = cellVertices.getJSONObject(j);
            vertices.add(j, new Vector(vertex.getDouble(Globals.JSON_VERTEX_X),
                                       vertex.getDouble(Globals.JSON_VERTEX_Y),
                                       vertex.getDouble(Globals.JSON_VERTEX_Z)));

        }

        for(int j = 0; j < 6; j++)
            neighbours.add(j, cellObject.getJSONArray(Globals.JSON_CELL_NEIGHBOURS).getInt(j));

        return cell;
    }

    private Cell init2D5Cell(JSONObject cellObject, int cellCount, int numCells, int layers, double layerHeight) throws JSONException {

        Cell cell = new TdFCell(cellCount);
        JSONArray cellVertices = cellObject.getJSONArray(Globals.JSON_CELL_VERTICES);
        int numberOfVertices = cellVertices.length();
        int currentLayer = cellCount / numCells;

        ArrayList<Vector> vertices = cell.getVertices();
        ArrayList<Integer> neighbours = cell.getNeighbours();


        for(int i = 0; i < 2 * numberOfVertices; i++) {
            JSONObject vertex = cellVertices.getJSONObject(i % numberOfVertices);
            vertices.add(i, new Vector(vertex.getDouble(Globals.JSON_VERTEX_X),
                                       vertex.getDouble(Globals.JSON_VERTEX_Y),
                                       vertex.getDouble(Globals.JSON_VERTEX_Z) - currentLayer * layerHeight));

        }

        Utils tempUtil = new Utils();
        cell.setCentre(tempUtil.getBarycenter(cell));

        for(int j = 0; j < numberOfVertices + 2; j++) {
            if (currentLayer == 0 && j == 0)
                neighbours.add(j, -1);
            else if (currentLayer == layers - 1 && j == 1)
                neighbours.add(j, -1);
            else if (j == 0)
                neighbours.add(j, cellCount - (numCells / layers));
            else if (j == 1)
                neighbours.add(j, cellCount + (numCells / layers));
            else
                neighbours.add(j, cellObject.getJSONArray(Globals.JSON_CELL_NEIGHBOURS).getInt(j - 2));
        }

        return cell;
    }
}
