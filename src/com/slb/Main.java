package com.slb;

import com.slb.gridcomponents.Cell;
import com.slb.gridcomponents.Grid;
import com.slb.utils.GridUtils;

public class Main {

    public static void main(String[] args) {

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
