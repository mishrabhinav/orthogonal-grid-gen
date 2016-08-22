package com.slb.utils;

public final class Globals {

    public static final double INITIAL_STEP                    = 2.0;
    public static final int    GRID_TYPE_HEX                   = 0;
    public static final int    GRID_TYPE_2D5                   = 1;

    public static final String JSON_DELIM                      = "\\Z";
    public static final String JSON_NAME                       = "name";
    public static final String JSON_GRID_TYPE                  = "type";
    public static final String JSON_GRID_LAYERS                = "layers";
    public static final String JSON_GRID_LAYER_HEIGHT          = "layerHeight";
    public static final String JSON_NUM_OF_CELLS               = "numberOfCells";
    public static final String JSON_CELLS                      = "cells";
    public static final String JSON_CELL_ID                    = "id";
    public static final String JSON_CELL_CENTRE                = "centre";
    public static final String JSON_CELL_VERTICES              = "vertices";
    public static final String JSON_CELL_NUM_OF_VERTICES       = "numberOfVertices";
    public static final String JSON_CELL_NEIGHBOURS            = "neighbours";
    public static final String JSON_VERTEX_X                   = "x";
    public static final String JSON_VERTEX_Y                   = "y";
    public static final String JSON_VERTEX_Z                   = "z";

    public static final String WARNING_DUMP_FAIL               = "WARNING: Dump setup failed. Data will not be dumped.";
    public static final String WARNING_ILLEGAL_ARG             = "WARNING: Unidentified argument '%s'.";
    public static final String WARNING_SETUP_COMMANDUTIL       = "WARNING: Setup CommandUtils before using it.";
    public static final String ERROR_JSON_FILE                 = "ERROR: JSON Grid file could not be opened.";
    public static final String ERROR_JSON_GRID                 = "ERROR: JSON Grid type not recognised.";
    public static final String ERROR_JSON_LOAD                 = "ERROR: JSON Grid data could not be loaded.";
    public static final String BUG_FACE_NULL                   = "BUG: Requested Face is NULL";
    public static final String BUG_GRID_MISSING                = "BUG: Parent grid missing. Returning zero vector.";

    public static final String PRINT_GRID_NAME                 = "Grid Name: %s\n";
    public static final String PRINT_NUM_OF_CELLS              = "Number of Cells: %d\n";
    public static final String PRINT_CELLS                     = "CELLS:";
    public static final String PRINT_VECTOR                    = "(%.2f, %.2f, %.2f)";
    public static final String PRINT_VECTOR_NAME               = "\t%s -> %s\n";
    public static final String PRINT_VERTEX_NAME               = "Vector %d";
    public static final String PRINT_CENTER                    = "Center";
    public static final String PRINT_CELL_ID                   = "Cell ID: %d\n";
    public static final String PRINT_CELL                      = "Cell ID: %d, Centre: %s\n";
    public static final String PRINT_FACE_NEIGHBOUR            = "\tFace %d -> Cell %d\n";
    public static final String PRINT_FACE_NO_NEIGHBOUR         = "\tFace %d -> No neighbour\n";
    public static final String PRINT_COST                      = "\nCost: %f";

    public static final String COMMAND_RUNS                    = "--runs";
    public static final String COMMAND_STEP                    = "--step";
    public static final String COMMAND_LIMIT                   = "--limit";
    public static final String COMMAND_DUMP_FILE               = "--gf";
    public static final String COMMAND_DUMP_STDOUT             = "--gs";
    public static final String COMMAND_DUMP_CONFLICT           = "WARNING: Cannot dump to both the file and STDOut. " +
                                                                 "Giving priority to file.";

    public static final String DEBUG_SECTION_LINE              = "\n------------------------------------------------";
    public static final String DEBUG_RUN_TITLE                 = "\n:-------------------:Run %3d:------------------:\n";
    public static final String DEBUG_RUN_LINE                  = "+----------------------------------------------+";
    public static final String DEBUG_RUN_TABLE_HEADER          = "| Cell ID |        Centre         |   Average  |";
    public static final String DEBUG_RUN_TABLE_ROW             = "| %-7d | (%-5.2f, %-5.2f, %-5.2f) | %-10.7f |";
    public static final String DEBUG_DUMP_FILE                 = "dump.txt";
    public static final String DEBUG_LIMIT_RUN                 = "******The last %3d runs had the same cost.******";
    public static final String DEBUG_CANCEL_RUN                ="******     CANCELLING REMAINING RUNS!     ******";
    public static final String DEBUG_SETUP_ERROR               = "Supplied Arguments not recognised.\n" +
                                                                 "Please use:\n" +
                                                                       "\t'-gf' to dump data to files or\n" +
                                                                       "\t'-gs' to dump data to stdout";
}
