package com.slb.utils;

import com.slb.components.Grid;
import com.slb.parser.GridParser;
import org.json.JSONException;

import java.io.FileNotFoundException;

public class GridUtils {

    private Grid       grid;
    private GridParser parser;
    public  Utils      utils;

    public GridUtils() throws JSONException, FileNotFoundException {

        this.grid   = new Grid();
        this.parser = new GridParser(this.grid);
        this.parser.loadFile();
    }

    public Grid loadGrid() throws JSONException {

        parser.parseFile();
        utils = new Utils(grid);

        return grid;
    }

    public double fixCells() {

        double runCost = 0.0;

        for(int i = 0; i < grid.getNumberOfCells(); i++) {
            runCost += utils.directSearch(grid.getCells().get(i));
        }

        DebugUtils.printMessage(String.format(Globals.PRINT_COST, runCost));

        return runCost;
    }
}
