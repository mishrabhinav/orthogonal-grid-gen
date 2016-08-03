package com.slb.utils;

import com.slb.components.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;
import com.slb.parser.GridParser;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class GridUtils {

    private String input;
    private Grid grid;
    public Utils utils;
    private GridParser parser;

    public GridUtils(String input) throws JSONException, FileNotFoundException {
        this.input = input;
        this.grid = new Grid();
        this.parser = new GridParser(this.grid);
        parser.loadFile(input);
    }

    /*
     * The top face vertices are specified first followed by the bottom four.
     * Follow the ordering Sheleem mentioned.
     */
    public Grid loadGrid() throws JSONException {
        //loadBigMockData();
        parser.parseFile();
        utils = new Utils(grid);

        return grid;
    }

    public Cell test1() {
        utils.directSearch(grid.getCells().get(0));

        return grid.getCells().get(0);
    }

    private void loadMockData() {

        HashMap<Integer, Cell> cells = grid.getCells();

        Vector v0, v1, v2, v3, v4, v5, v6, v7;
        Cell cell;
        ArrayList<Vector> vertices;

        // Cell 0
        cell = new Cell(0, new Vector(0.7, 0.7, 0.7));

        v0 = new Vector(0,0,1);
        v1 = new Vector(0,1,1);
        v2 = new Vector(1,1,1);
        v3 = new Vector(1,0,1);
        v4 = new Vector(0,0,0);
        v5 = new Vector(0,1,0);
        v6 = new Vector(1,1,0);
        v7 = new Vector(1,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cell.getNeighbours().add(0, -1);
        cell.getNeighbours().add(1, -1);
        cell.getNeighbours().add(2, 2);
        cell.getNeighbours().add(3, 4);
        cell.getNeighbours().add(4, 3);
        cell.getNeighbours().add(5, 1);
        cells.put(0, cell);

        // Cell 1
        cell = new Cell(1, new Vector(0.5, 1.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,2,1);
        v2 = new Vector(1,2,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,2,0);
        v6 = new Vector(1,2,0);
        v7 = new Vector(1,1,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(1, cell);

        // Cell 2
        cell = new Cell(2, new Vector(1.5, 0.5, 0.5));

        v0 = new Vector(1,0,1);
        v1 = new Vector(1,1,1);
        v2 = new Vector(2,1,1);
        v3 = new Vector(2,0,1);
        v4 = new Vector(1,0,0);
        v5 = new Vector(1,1,0);
        v6 = new Vector(2,1,0);
        v7 = new Vector(2,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(2, cell);

        // Cell 3
        cell = new Cell(3, new Vector(0.5, -0.5, 0.5));

        v0 = new Vector(0,-1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,-1,1);
        v4 = new Vector(0,-1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
        v7 = new Vector(1,-1,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(3, cell);

        // Cell 4
        cell = new Cell(4, new Vector(-0.5, 0.5, 0.5));

        v0 = new Vector(-1,0,1);
        v1 = new Vector(-1,1,1);
        v2 = new Vector(0,1,1);
        v3 = new Vector(0,0,1);
        v4 = new Vector(-1,0,0);
        v5 = new Vector(-1,1,0);
        v6 = new Vector(0,1,0);
        v7 = new Vector(0,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(4, cell);

    }

    private void loadBigMockData() {

        HashMap<Integer, Cell> cells = grid.getCells();

        Vector v0, v1, v2, v3, v4, v5, v6, v7;
        Cell cell;
        ArrayList<Vector> vertices;

        // Cell 0
        cell = new Cell(0, new Vector(7, 7, 7));

        v0 = new Vector(0,0,10);
        v1 = new Vector(0,10,10);
        v2 = new Vector(20,10,10);
        v3 = new Vector(10,0,10);
        v4 = new Vector(0,0,0);
        v5 = new Vector(0,10,0);
        v6 = new Vector(10,10,0);
        v7 = new Vector(10,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cell.getNeighbours().add(0, -1);
        cell.getNeighbours().add(1, -1);
        cell.getNeighbours().add(2, 2);
        cell.getNeighbours().add(3, 4);
        cell.getNeighbours().add(4, 3);
        cell.getNeighbours().add(5, 1);
        cells.put(0, cell);

        // Cell 1
        cell = new Cell(1, new Vector(5, 15, 5));

        v0 = new Vector(0,10,10);
        v1 = new Vector(0,20,10);
        v2 = new Vector(10,20,10);
        v3 = new Vector(10,10,10);
        v4 = new Vector(0,10,0);
        v5 = new Vector(0,20,0);
        v6 = new Vector(10,20,0);
        v7 = new Vector(10,10,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(1, cell);

        // Cell 2
        cell = new Cell(2, new Vector(15, 5, 5));

        v0 = new Vector(10,0,10);
        v1 = new Vector(20,10,10);
        v2 = new Vector(20,10,10);
        v3 = new Vector(20,0,10);
        v4 = new Vector(10,0,0);
        v5 = new Vector(10,10,0);
        v6 = new Vector(20,10,0);
        v7 = new Vector(20,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(2, cell);

        // Cell 3
        cell = new Cell(3, new Vector(5, -5, 5));

        v0 = new Vector(0,-10,10);
        v1 = new Vector(0,0,10);
        v2 = new Vector(10,0,10);
        v3 = new Vector(10,-10,10);
        v4 = new Vector(0,-10,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(10,0,0);
        v7 = new Vector(10,-10,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(3, cell);

        // Cell 4
        cell = new Cell(4, new Vector(-5, 5, 5));

        v0 = new Vector(-10,0,10);
        v1 = new Vector(-10,10,10);
        v2 = new Vector(0,10,10);
        v3 = new Vector(0,0,10);
        v4 = new Vector(-10,0,0);
        v5 = new Vector(-10,10,0);
        v6 = new Vector(0,10,0);
        v7 = new Vector(0,0,0);

        vertices = cell.getVertices();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);
        vertices.add(v7);

        cells.put(4, cell);

    }
}
