package com.slb;

import com.slb.gridcomponents.Grid;
import com.slb.utils.GridUtils;

public class Main {

    public static void main(String[] args) {

        GridUtils loader = new GridUtils(args[0]);
        Grid grid = loader.loadGrid();
    }
}
