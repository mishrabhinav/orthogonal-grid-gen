package com.slb.components;

import com.slb.components.cells.Cell;

import java.util.HashMap;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Grid {

    private String gridName;
    private int numberOfCells;
    private int gridType;
    private HashMap<Integer, Cell> cells;

    public Grid() {
        this.cells = new HashMap<>();
    }

    public HashMap<Integer, Cell> getCells() {
        return cells;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName;
    }

    public int getNumberOfCells() {
        return numberOfCells;
    }

    public void setNumberOfCells(int numberOfCells) {
        this.numberOfCells = numberOfCells;
    }

    public int getGridType() {
        return gridType;
    }

    public void setGridType(int gridType) {
        this.gridType = gridType;
    }
}
