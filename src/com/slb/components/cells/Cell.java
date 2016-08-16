package com.slb.components.cells;

import com.slb.components.Vector;
import com.slb.utils.Globals;

import java.util.ArrayList;

public abstract class Cell {

    protected int cellID;
    protected Vector centre;
    public Vector pointInside;
    protected ArrayList<Vector> vertices;
    protected ArrayList<Integer> neighbours;
    protected int validNeighbours;

    public Cell(int cellID, Vector centre){
        this.cellID = cellID;
        this.centre = centre;
        this.vertices = new ArrayList<>();
        this.neighbours = new ArrayList<>();
        this.validNeighbours = 0;

        if(centre != null)
            this.pointInside = centre.clone();
    }

    public int getCellID() {
        return cellID;
    }

    public Vector getCentre() {
        return centre;
    }

    public void setCentre(Vector centre) {
        this.centre = centre;
    }

    public void setPointInside(Vector v) {
        this.pointInside = v.clone();
    }

    public ArrayList<Vector> getVertices() {
        return vertices;
    }

    public ArrayList<Integer> getNeighbours() {
        return neighbours;
    }

    public int getValidNeighbours() {
        if(validNeighbours == 0) {
            for (int n : neighbours)
                validNeighbours += n != -1 ? 1 : 0;
        }

        return validNeighbours;
    }

    public abstract Vector[] getFace(int faceNum);

    @Override
    public String toString() {
        return String.format(Globals.PRINT_CELL, cellID, centre.toString());
    }
}
