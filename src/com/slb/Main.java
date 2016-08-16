package com.slb;

import com.slb.components.Grid;
import com.slb.utils.CommandUtils;
import com.slb.utils.DebugUtils;
import com.slb.utils.Globals;
import com.slb.utils.GridUtils;
import org.json.JSONException;

import java.io.FileNotFoundException;

public class Main {

    private static GridUtils gridUtils;
    private static Grid grid;

    public static void main(String[] args) {

        CommandUtils commander = CommandUtils.setupCommand(args);

        try {
            DebugUtils.setupDebugUtils();
        } catch(FileNotFoundException e) {
            System.out.println(Globals.WARNING_DUMP_FAIL);
        }

        try {
            gridUtils = new GridUtils();
            grid = gridUtils.loadGrid();
        } catch(FileNotFoundException e) {
            System.out.println(Globals.ERROR_JSON_FILE);
            System.exit(1);
        } catch(JSONException e) {
            System.out.println(Globals.ERROR_JSON_LOAD);
            e.printStackTrace();
            System.exit(1);
        }

        for(int i = 0; i < commander.getNumberOfRuns(); i++)
            gridUtils.fixCells();

        DebugUtils.checkAndDump(grid);
    }
}
