package com.slb.utils;

import com.slb.components.Grid;
import com.slb.parser.GridParser;
import org.json.JSONException;

import java.io.FileNotFoundException;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class GridUtils {

    private Grid grid;
    public Utils utils;
    private GridParser parser;

    public GridUtils(String inputFile) throws JSONException, FileNotFoundException {
        this.grid = new Grid();
        this.parser = new GridParser(this.grid);
        this.parser.loadFile(inputFile);
    }

    /*
     * The top face vertices are specified first followed by the bottom four.
     * Follow the ordering Sheleem mentioned.
     */
    public Grid loadGrid() throws JSONException {
        parser.parseFile();
        utils = new Utils(grid);

        return grid;
    }

    public void fixCells() {
        for(int i : new int[]{0,1,2,3,4})
            utils.directSearch(grid.getCells().get(i));
    }
}
