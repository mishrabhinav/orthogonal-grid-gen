package com.slb.components.cells;

import com.slb.components.Vector;

public class HexCell extends Cell {

    public HexCell(int cellID, Vector centre){
       super(cellID, centre);
    }

    @Override
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
                vertices[1] = this.vertices.get(7);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(5);
                break;

            case 2:
                vertices[0] = this.vertices.get(0);
                vertices[1] = this.vertices.get(4);
                vertices[2] = this.vertices.get(5);
                vertices[3] = this.vertices.get(1);

                break;

            case 3:
                vertices[0] = this.vertices.get(1);
                vertices[1] = this.vertices.get(5);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(2);

                break;

            case 4:
                vertices[0] = this.vertices.get(3);
                vertices[1] = this.vertices.get(2);
                vertices[2] = this.vertices.get(6);
                vertices[3] = this.vertices.get(7);

                break;

            case 5:
                vertices[0] = this.vertices.get(0);
                vertices[1] = this.vertices.get(3);
                vertices[2] = this.vertices.get(7);
                vertices[3] = this.vertices.get(4);

                break;

            default:
                System.out.println("BUG: Face number for a hex cell should be in range 0-5.");
        }

        return vertices;
    }
}
