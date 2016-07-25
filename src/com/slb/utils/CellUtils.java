package com.slb.utils;

import com.slb.gridcomponents.Cell;
import com.slb.gridcomponents.Vertex;

/**
 * Created by AMishra12 on 25/07/2016.
 */
public class CellUtils {

    public Vertex getBarycenter(Cell cell) {

        Vertex barycenter = new Vertex(0, 0, 0);

        for (Vertex v : cell.getVertices())
            barycenter.add(v);

        double numVertices = cell.getVertices().size();
        barycenter.divide(numVertices, numVertices, numVertices);

        return barycenter;
    }

    public Vertex getFaceCenter(Cell cell, int faceNum) {

        Vertex[] faceVertices = cell.getFace(faceNum);
        Vertex faceCenter = new Vertex(0, 0, 0);

        for (Vertex v : faceVertices)
            faceCenter.add(v);

        double numVertices = faceVertices.length;
        faceCenter.divide(numVertices, numVertices, numVertices);

        return faceCenter;
    }

    public double valueWithPlane(Vertex a, Vertex b, Vertex c, Vertex d) {

        Vertex B = new Vertex(b.x - a.x, b.y - a.y, b.z - a.z);
        Vertex C = new Vertex(c.x - a.x, c.y - a.y, c.z - a.z);
        Vertex D = new Vertex(d.x - a.x, d.y - a.y, d.z - a.z);

        double volume = B.x * (C.y * D.z - D.y * C.z)
                - B.y * (C.x * D.z - D.x * C.z)
                + B.z * (C.x * D.y - D.x * C.y);

        return volume;
    }

    public boolean arePointsOnSameSide(Cell cell, int facenum, Vertex a, Vertex b) {

        Vertex[] faceVertices = cell.getFace(facenum);

        double val_a = valueWithPlane(faceVertices[0], faceVertices[1], faceVertices[2], a);
        double val_b = valueWithPlane(faceVertices[0], faceVertices[1], faceVertices[2], b);

        return (val_a < 0 && val_b < 0) || (val_a > 0 && val_b > 0) || (val_a == 0 && val_b == 0);

    }
}
