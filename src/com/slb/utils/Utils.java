package com.slb.utils;

import com.slb.gridcomponents.Cell;
import com.slb.gridcomponents.Grid;
import com.slb.gridcomponents.Vector;

/**
 * Created by AMishra12 on 25/07/2016.
 */
public class Utils {

    private Grid parentGrid;
    private double INITIAL_STEP = 2;

    public Utils(Grid parentGrid) {
        this.parentGrid = parentGrid;
    }

    public Vector getBarycenter(Cell cell) {

        Vector barycenter = new Vector(0, 0, 0);

        for (Vector v : cell.getVertices())
            barycenter.add(v);

        double numVertices = cell.getVertices().size();
        barycenter.divide(numVertices, numVertices, numVertices);

        return barycenter;
    }

    public Vector getFaceCenter(Cell cell, int faceNum) {

        Vector[] faceVertices = cell.getFace(faceNum);
        Vector faceCenter = new Vector(0, 0, 0);

        for (Vector v : faceVertices)
            faceCenter.add(v);

        double numVertices = faceVertices.length;
        faceCenter.divide(numVertices, numVertices, numVertices);

        return faceCenter;
    }

    public double valueWithPlane(Vector a, Vector b, Vector c, Vector d) {

        Vector B = new Vector(b.x - a.x, b.y - a.y, b.z - a.z);
        Vector C = new Vector(c.x - a.x, c.y - a.y, c.z - a.z);
        Vector D = new Vector(d.x - a.x, d.y - a.y, d.z - a.z);

        double volume = B.x * (C.y * D.z - D.y * C.z)
                - B.y * (C.x * D.z - D.x * C.z)
                + B.z * (C.x * D.y - D.x * C.y);

        return volume;
    }

    public boolean arePointsOnSameSide(Cell cell, int facenum, Vector a, Vector b) {

        Vector[] faceVertices = cell.getFace(facenum);

        double val_a = valueWithPlane(faceVertices[0], faceVertices[1], faceVertices[2], a);
        double val_b = valueWithPlane(faceVertices[0], faceVertices[1], faceVertices[2], b);

        return (val_a < 0 && val_b < 0) || (val_a > 0 && val_b > 0) || (val_a == 0 && val_b == 0);

    }

    public boolean insideCell(Cell cell, Vector v) {

        for (int i = 0; i < 6; i ++) {
            if(!arePointsOnSameSide(cell, i, cell.pointInside, v))
                return false;
        }

        return true;
    }

    public Vector vectorToCentre(Cell cell, int faceNum) {

        Cell neighbour = parentGrid.getCells().get(cell.getNeighbours().get(faceNum));

        return new Vector(neighbour.getCentre().x - cell.getCentre().x,
                neighbour.getCentre().y - cell.getCentre().y,
                neighbour.getCentre().z - cell.getCentre().z);
    }

    public Vector faceNormal(Cell cell, int faceNum) {

        Vector[] vertices = cell.getFace(faceNum);

        Vector A = new Vector(vertices[3].x - vertices[0].x,
                    vertices[3].y - vertices[0].y,
                    vertices[3].z - vertices[0].z);

        Vector B = new Vector(vertices[1].x - vertices[0].x,
                    vertices[1].y - vertices[0].y,
                    vertices[1].z - vertices[0].z);

        Vector result = A.cross(B);

        if (valueWithPlane(vertices[0], vertices[1], vertices[2], vertices[3]) == 0)
            return result;

        Vector C = new Vector(vertices[3].x - vertices[2].x,
                    vertices[3].y - vertices[2].y,
                    vertices[3].z - vertices[2].z);

        Vector D = new Vector(vertices[1].x - vertices[2].x,
                    vertices[1].y - vertices[2].y,
                    vertices[1].z - vertices[2].z);

        result.add(D.cross(C));

        return result;
    }

    public double angleBetweenVectors(Vector A, Vector B) {
        // This could be a possible place for errros.
        return Math.acos((A.magnitude() * B.magnitude())/A.dot(B));
    }

    private double calculateAverageAngles(Cell cell) {

        double sum_theta = 0;

        for (int i = 0; i < 6; i++) {
            if (cell.getNeighbours().get(i) == -1)
                continue;

            sum_theta += angleBetweenVectors(faceNormal(cell, i), vectorToCentre(cell, i));
        }

        return sum_theta / (double)cell.getValidNeighbours();
    }

    private Vector[] probablePositions(Vector centre, double step) {

        Vector[] result = new Vector[6];

        step = Math.abs(step);

        result[0] = centre.clone().add(step, 0, 0);
        result[1] = centre.clone().subtract(step, 0, 0);

        result[2] = centre.clone().add(0, step, 0);
        result[3] = centre.clone().subtract(0, step, 0);

        result[4] = centre.clone().add(0, 0, step);
        result[5] = centre.clone().subtract(0, 0, step);

        return result;
    }

    public Vector directSearch(Cell cell) {

        double step = INITIAL_STEP;

        while (step > INITIAL_STEP/8) {

            Vector[] positions = probablePositions(cell.getCentre(), step);
        }

        return cell.getCentre();
    }
}
