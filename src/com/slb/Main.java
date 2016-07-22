package com.slb;

import com.slb.gridcomponents.Grid;
import com.slb.gridloader.GridLoader;

public class Main {

    public static void main(String[] args) {

        GridLoader loader = new GridLoader(args[0]);
        Grid grid = loader.loadGrid();
    }
}
