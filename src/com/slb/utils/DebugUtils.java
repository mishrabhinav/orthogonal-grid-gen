package com.slb.utils;

import com.slb.components.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by abhinavmishra on 03/08/2016.
 */
public final class DebugUtils {

    private static PrintStream output;

    private static boolean setup = false;
    private static boolean dumpFiles = false;

    private static void printVector(Vector v, String vectorName) {
        output.printf("\t%s -> (%.2f, %.2f, %.2f)\n", vectorName, v.x, v.y, v.z);
    }

    private static void printVertices(ArrayList<Vector> vertices, int length) {
        output.println();
        for(int i = 0; i < length; i++) {
            printVector(vertices.get(i), ("Vertex " + Integer.toString(i)));
        }
    }

    private static void printNeighbours(ArrayList<Integer> neighbours, int length) {
        output.println();
        for(int i = 0; i < length; i++) {
            if(neighbours.get(i) != -1)
                output.printf("\tFace %d -> Cell %d\n", i, neighbours.get(i));
            else
                output.printf("\tFace %d -> No neighbour\n", i);
        }
    }

    private static void printCell(Cell cell) {
        output.printf("Cell ID: %d\n", cell.getCellID());
        printVector(cell.getCentre(), "Centre");
        printVertices(cell.getVertices(), cell.getVertices().size());
        printNeighbours(cell.getNeighbours(), cell.getNeighbours().size());
    }

    private static void printGrid(Grid grid) {

        output.printf("Grid Name: %s\n", grid.getGridName());
        output.printf("Number of Cells: %d\n", grid.getNumberOfCells());
        output.println(Globals.DEBUG_SECTION_LINE);
        output.println("CELLS:");
        output.println();

        for(int i = 0; i < grid.getNumberOfCells(); i++) {
            printCell(grid.getCells().get(i));
            output.println(Globals.DEBUG_SECTION_LINE);
        }
    }

    public static void setupDebugUtils(String[] args) {
        if(args.length > 1) {
            dumpFiles = args[1].equals("-g");
            setup = true;
        }
    }

    public static void checkIfDumpRequiredAndDump(Grid grid) throws FileNotFoundException {
        if(dumpFiles && setup) {
            File dump = new File(Globals.DEBUG_DUMP_FILE);
            output = new PrintStream(dump);
            printGrid(grid);
        } else if(dumpFiles) {
            System.out.println("Could not dump files. DebugUtils not setup.");
        }
    }
}
