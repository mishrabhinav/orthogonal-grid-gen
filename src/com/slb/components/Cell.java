package com.slb.components;

import java.util.ArrayList;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Cell {

    private int cellID;
    private Vector centre;
    public Vector pointInside;
    private ArrayList<Vector> vertices;
    private ArrayList<Integer> neighbours;

    public Cell(int cellID, Vector centre){
        this.cellID = cellID;
        this.centre = centre;
        this.pointInside = new Vector(centre.x, centre.y, centre.z);
        this.vertices = new ArrayList<Vector>();
        this.neighbours = new ArrayList<Integer>();
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
        int valid = 0;

        for(int n : neighbours)
            valid += n != -1 ? 1 : 0;

        return valid;
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
                System.out.println("Face number should be in range 0-5.");
        }

        return vertices;
    }

    @Override
    public String toString() {
        return "Cell ID: " + cellID + ", Centre: (" + centre.x + ", " + centre.y + ", " + centre.z + ")\n";
    }
}
