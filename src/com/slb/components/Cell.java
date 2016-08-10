package com.slb.components;

import com.slb.utils.Globals;

import java.util.ArrayList;

public class Cell {

    private int cellID;
    private Vector centre;
    public Vector pointInside;
    private ArrayList<Vector> vertices;
    private ArrayList<Integer> neighbours;
    private int validNeighbours;

    public Cell(int cellID, Vector centre){
        this.cellID = cellID;
        this.centre = centre;
        this.pointInside = centre.clone();
        this.vertices = new ArrayList<>();
        this.neighbours = new ArrayList<>();
        this.validNeighbours = 0;
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

    public Vector[] getFace(int faceNum) {

        // NOTE: Face and Vector ordering is different in Intersect.
        Vector[] vertices = new Vector[4];

        switch (faceNum) {
            case 0:
                vertices[0] = this.vertices.get(0);
                vertices[1] = this.vertices.get(1);
                vertices[2] = this.vertices.get(2);
                vertices[3] = this.vertices.get(3);
                break;

            case 1:
                vertices[0] = this.vertices.get(4);
                vertices[1] = this.vertices.get(5);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(7);
                break;

            case 2:
                vertices[0] = this.vertices.get(3);
                vertices[1] = this.vertices.get(2);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(7);
                break;

            case 3:
                vertices[0] = this.vertices.get(0);
                vertices[1] = this.vertices.get(1);
                vertices[2] = this.vertices.get(5);
                vertices[3] = this.vertices.get(4);
                break;

            case 4:
                vertices[0] = this.vertices.get(0);
                vertices[1] = this.vertices.get(3);
                vertices[2] = this.vertices.get(7);
                vertices[3] = this.vertices.get(4);
                break;

            case 5:
                vertices[0] = this.vertices.get(1);
                vertices[1] = this.vertices.get(2);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(5);
                break;

            default:
                System.out.println("BUG: Face number should be in range 0-5.");
        }

        return vertices;
    }

    @Override
    public String toString() {
        return String.format(Globals.PRINT_CELL, cellID, centre.toString());
    }
}
