package com.slb;

import com.slb.components.Cell;
import com.slb.components.Grid;
import com.slb.utils.GridUtils;
import org.json.JSONException;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws JSONException, FileNotFoundException {

        GridUtils loader = new GridUtils(args[0]);
        Grid grid = loader.loadGrid();

        for(int i = 0; i < 5; i++) {
            System.out.print(grid.getCells().get(i).toString());
        }

        System.out.println();

        Cell test = loader.test1();

        for(int i = 0; i < 5; i++) {
            System.out.print(grid.getCells().get(i).toString());
        }
    }
}
