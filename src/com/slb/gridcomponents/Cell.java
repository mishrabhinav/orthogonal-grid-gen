package com.slb.gridcomponents;

import java.util.ArrayList;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Cell {

    private int cellID;
    private Vertex centre;
    private ArrayList<Vertex> vertices;
    private ArrayList<Integer> neighbours;

    public Cell(int cellID, Vertex centre, ArrayList<Vertex> vertices, ArrayList<Integer> neighbours){
        this.cellID = cellID;
        this.centre = centre;
        this.vertices = vertices;
        this.neighbours = neighbours;
    }

    public int getCellID() {
        return cellID;
    }

    public Vertex getCentre() {
        return centre;
    }

    public void setCentre(Vertex centre) {
        this.centre = centre;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Integer> getNeighbours() {
        return neighbours;
    }

}
