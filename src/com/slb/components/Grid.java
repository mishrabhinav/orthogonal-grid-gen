package com.slb.components;

import java.util.HashMap;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Grid {

    private HashMap<Integer, Cell> cells;

    public Grid() {
        this.cells = new HashMap<Integer, Cell>();
    }

    public HashMap<Integer, Cell> getCells() {
        return cells;
    }
}
