package com.slb.utils;

import com.slb.gridcomponents.Cell;
import com.slb.gridcomponents.Grid;
import com.slb.gridcomponents.Vector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class GridUtils {

    private String input;
    private Grid grid;

    public GridUtils(String input) {
        this.input = input;
        this.grid = new Grid();
    }

    /*
     * The top face vertices are specified first followed by the bottom four.
     * Follow the ordering Sheleem mentioned.
     */
    public Grid loadGrid() {
        return loadMockData();
    }

    private Grid loadMockData() {

        HashMap<Integer, Cell> cells = grid.getCells();

        Vector v0, v1, v2, v3, v4, v5, v6, v7;
        Cell cell;
        ArrayList<Vector> vertices;

        // Cell 0
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(0, cell);

        // Cell 1
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(2, cell);

        // Cell 3
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(3, cell);

        // Cell 4
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(4, cell);

        // Cell 5
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(5, cell);

        // Cell 6
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(6, cell);

        // Cell 7
        cell = new Cell(new Vector(0.5, 0.5, 0.5));

        v0 = new Vector(0,1,1);
        v1 = new Vector(0,0,1);
        v2 = new Vector(1,0,1);
        v3 = new Vector(1,1,1);
        v4 = new Vector(0,1,0);
        v5 = new Vector(0,0,0);
        v6 = new Vector(1,0,0);
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

        cells.put(7, cell);

        return grid;
    }
}
