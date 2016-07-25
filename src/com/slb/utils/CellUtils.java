package com.slb.utils;

import com.slb.gridcomponents.Cell;
import com.slb.gridcomponents.Vector;

/**
 * Created by AMishra12 on 25/07/2016.
 */
public class CellUtils {

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
}
