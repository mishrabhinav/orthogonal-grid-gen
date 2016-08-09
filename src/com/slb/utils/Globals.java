package com.slb.utils;

/**
 * Created by abhinavmishra on 02/08/2016.
 */
public final class Globals {

    private Globals() {

    }

    // Direct Search Globals
    public static final double INITIAL_STEP = 2.0;

    // JSON Parser Globals
    public static final String GRID_NAME = "name";
    public static final String GRID_NUMBEROFCELLS = "numberOfCells";
    public static final String GRID_CELLS = "cells";
    public static final String GRID_CELL_ID = "id";
    public static final String GRID_CELL_CENTRE = "centre";
    public static final String GRID_CELL_VERTICES = "vertices";
    public static final String GRID_CELL_NUMBEROFVERTICES = "numberOfVertices";
    public static final String GRID_CELL_NEIGHBOURS = "neighbours";
    public static final String GRID_VERTEX_X = "x";
    public static final String GRID_VERTEX_Y = "y";
    public static final String GRID_VERTEX_Z = "z";

    // Debug Globals
    public static final String DEBUG_SECTION_LINE = "----------------------------------------";
    public static final String DEBUG_DUMP_FILE = "dump.txt";
}
