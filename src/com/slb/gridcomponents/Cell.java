package com.slb.gridcomponents;

import java.util.ArrayList;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Cell {

    private Vertex centre;
    private ArrayList<Vertex> vertices;
    private ArrayList<Integer> neighbours;

    public Cell(Vertex centre){
        this.centre = centre;
        this.vertices = new ArrayList<Vertex>();
        this.neighbours = new ArrayList<Integer>();
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
