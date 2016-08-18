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
            DebugUtils.printDetails(grid);
        } catch(FileNotFoundException e) {
            System.out.println(Globals.ERROR_JSON_FILE);
            System.exit(1);
        } catch(JSONException e) {
            System.out.println(Globals.ERROR_JSON_LOAD);
            e.printStackTrace();
            System.exit(1);
        }

        DebugUtils.checkAndDump(grid, 0);

        int runCounter = 0;
        Double runCost = 0.0;
        Double tempRunCost = 0.0;

        for(int i = 0; i < commander.getNumberOfRuns(); i++) {
            DebugUtils.printRun(i+1);
            tempRunCost = gridUtils.fixCells();
            if(tempRunCost.equals(runCost))
                runCounter++;
            else {
                runCost = tempRunCost;
                runCounter = 0;
            }

            if(runCounter == 10) {
                DebugUtils.printMessage("\n*******Last 10 Runs have the same cost. Stopping future runs*******\n");
                break;
            }
        }

        DebugUtils.checkAndDump(grid, 2);
    }
}
