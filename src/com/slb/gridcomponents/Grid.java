package com.slb.gridcomponents;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Grid {

    private HashMap<Integer, Cell> cells;

    public Grid(HashMap<Integer, Cell> cells) {
        this.cells = cells;
    }

    public HashMap<Integer, Cell> getCells() {
        return cells;
    }
}
