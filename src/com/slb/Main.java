package com.slb;

import com.slb.components.Cell;
import com.slb.components.Grid;
import com.slb.utils.DebugUtils;
import com.slb.utils.GridUtils;
import org.json.JSONException;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws JSONException, FileNotFoundException {
        DebugUtils.setupDebugUtils(args);

        GridUtils gridUtils = new GridUtils(args[0]);
        Grid grid = gridUtils.loadGrid();

//        for(int i = 0; i < 5; i++) {
//            System.out.print(grid.getCells().get(i).toString());
//        }
//
//        System.out.println();

        gridUtils.fixCells();

//        for(int i = 0; i < 5; i++) {
//            System.out.print(grid.getCells().get(i).toString());
//        }

        DebugUtils.checkIfDumpRequiredAndDump(grid);
    }
}
