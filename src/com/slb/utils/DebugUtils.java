package com.slb.utils;

import com.slb.components.cells.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public final class DebugUtils {

    private static PrintStream output;

    public static void setupDebugUtils() throws FileNotFoundException {
        CommandUtils commander = CommandUtils.getCommand();

            if(commander.isDumpToFile())
                output = new PrintStream(new File(Globals.DEBUG_DUMP_FILE));
            else if (commander.isDumpToSTDOut())
                output = new PrintStream(System.out);

            if(output == null)
                System.out.println(Globals.DEBUG_SETUP_ERROR);

    }

    public static void checkAndDump(Grid grid, int stage) {
        if(output != null)
            printGrid(grid);
    }

    private static void printVector(Vector v, String vectorName) {
        output.printf(Globals.PRINT_VECTOR_NAME, vectorName, v.toString());
    }

    private static void printVertices(ArrayList<Vector> vertices, int length) {
        output.println();
        for(int i = 0; i < length; i++) {
            printVector(vertices.get(i), String.format(Globals.PRINT_VERTEX_NAME, i));
        }
    }

    private static void printNeighbours(ArrayList<Integer> neighbours, int length) {
        output.println();
        for(int i = 0; i < length; i++) {
            if(neighbours.get(i) != -1)
                output.printf(Globals.PRINT_FACE_NEIGHBOUR, i, neighbours.get(i));
            else
                output.printf(Globals.PRINT_FACE_NO_NEIGHBOUR, i);
        }
    }

    private static void printCell(Cell cell) {
        output.printf(Globals.PRINT_CELL_ID, cell.getCellID());
        printVector(cell.getCentre(), Globals.PRINT_CENTER);
        printVertices(cell.getVertices(), cell.getVertices().size());
        printNeighbours(cell.getNeighbours(), cell.getNeighbours().size());
    }

    private static void printGrid(Grid grid) {

        output.println(Globals.DEBUG_SECTION_LINE);
        output.println(Globals.PRINT_CELLS);
        output.println();

        for(int i = 0; i < grid.getNumberOfCells(); i++) {
            printCell(grid.getCells().get(i));
            output.println(Globals.DEBUG_SECTION_LINE);
        }
    }

    public static void printDetails(Grid grid) {
        output.printf(Globals.PRINT_GRID_NAME, grid.getGridName());
        output.printf(Globals.PRINT_NUM_OF_CELLS, grid.getNumberOfCells());

    }

    public static void printRun(int runNum) {
        output.println(String.format(Globals.DEBUG_RUN_TITLE, runNum));
        output.println(Globals.DEBUG_RUN_LINE);
        output.println(Globals.DEBUG_RUN_TABLE_HEADER);
        output.println(Globals.DEBUG_RUN_LINE);
    }

    public static void printOrthogonality(Cell cell, double average) {
        output.println(String.format(Globals.DEBUG_RUN_TABLE_ROW, cell.getCellID(), cell.getCentre().x, cell.getCentre().y, cell.getCentre().z, average));
    }

    public static void printMessage(String message) {
        output.println(message);
    }
}
