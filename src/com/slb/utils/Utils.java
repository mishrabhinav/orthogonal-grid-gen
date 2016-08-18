package com.slb.utils;

import com.slb.components.cells.Cell;
import com.slb.components.Grid;
import com.slb.components.Vector;

public class Utils {

    private Grid parentGrid;
    private boolean gridSupplied;

    public Utils() {
       this.gridSupplied = false;
    }

    public Utils(Grid parentGrid) {
        this.parentGrid = parentGrid;
        this.gridSupplied = true;
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

        int numVertices = cell.getVertices().size();

        for (int i = 0; i < numVertices/2 + 2; i ++) {
            if(!arePointsOnSameSide(cell, i, cell.pointInside, v))
                return false;
        }

        return true;
    }

    public Vector vectorToCentre(Cell cell, int faceNum) {

        if(gridSupplied) {
            Cell neighbour = parentGrid.getCells().get(cell.getNeighbours().get(faceNum));

            return new Vector(neighbour.getCentre().x - cell.getCentre().x,
                    neighbour.getCentre().y - cell.getCentre().y,
                    neighbour.getCentre().z - cell.getCentre().z);
        } else {
            System.out.println("PARENT GRID NOT SUPPLIED. RETURNING NULL VECTOR.");
            return new Vector(0,0,0);
        }
    }

    public Vector faceNormal(Cell cell, int faceNum) {

        Vector[] vertices = cell.getFace(faceNum);

        Vector A = new Vector(vertices[2].x - vertices[0].x,
                    vertices[2].y - vertices[0].y,
                    vertices[2].z - vertices[0].z);

        Vector B = new Vector(vertices[1].x - vertices[0].x,
                    vertices[1].y - vertices[0].y,
                    vertices[1].z - vertices[0].z);


        Vector result = A.cross(B);

        //System.out.println("A: " + A.x + ", " + A.y + ", " + A.z);
        //System.out.println("B: " + B.x + ", " + B.y + ", " + B.z);
        //System.out.println(result.x + ", " + result.y + ", " + result.z + ", Face: " + faceNum);

        if (vertices.length == 3 || valueWithPlane(vertices[0], vertices[1], vertices[2], vertices[3]) == 0)
            return result;

        Vector C = new Vector(vertices[3].x - vertices[0].x,
                    vertices[3].y - vertices[0].y,
                    vertices[3].z - vertices[0].z);

        Vector D = new Vector(vertices[2].x - vertices[0].x,
                    vertices[2].y - vertices[0].y,
                    vertices[2].z - vertices[0].z);

        result.add(faceNum % 2 != 0 ? D.cross(C) : C.cross(D));

        return result;
    }

    public double angleBetweenVectors(Vector A, Vector B) {
        return Math.acos(A.dot(B)/(A.magnitude() * B.magnitude()));
    }

    private double calculateAverageAngles(Cell cell) {

        double sum_theta = 0;
        int numVertices = cell.getVertices().size();

        for (int i = 0; i < (numVertices/2 + 2); i++) {
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

    public double directSearch(Cell cell) {

        double step = Globals.INITIAL_STEP;
        int stepSize = CommandUtils.getCommand().getStepSize();
        Vector bestPosition;
        Vector currentPosition = cell.getCentre();
        Vector originalCentre = cell.getCentre().clone();
        double currentBest = 0.0;

        while (step > Globals.INITIAL_STEP/stepSize) {
            boolean changed = false;
            currentBest = calculateAverageAngles(cell);
            Vector[] positions = probablePositions(cell.getCentre(), step);

            for(Vector v : positions) {
                cell.setCentre(v);
                double probableBest = calculateAverageAngles(cell);

                if (probableBest < currentBest) {
                    currentPosition = v;
                    currentBest = probableBest;
                    changed = true;
                }
            }

            if (changed && insideCell(cell, currentPosition)) {
                bestPosition = currentPosition;
                cell.setCentre(bestPosition);
                originalCentre = currentPosition;
            } else {
                cell.setCentre(originalCentre);
                step /= 2;
            }
        }

        DebugUtils.printOrthogonality(cell, currentBest);

        return currentBest;
    }
}
