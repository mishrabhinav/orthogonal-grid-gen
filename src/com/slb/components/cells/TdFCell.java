package com.slb.components.cells;

import com.slb.components.Vector;
import com.slb.utils.Globals;

import java.util.ArrayList;

public class TdFCell extends Cell {

    public TdFCell(int cellID) {
        super(cellID, null);
    }

    @Override
    public Vector[] getFace(int faceNum) {
        ArrayList<Vector> faceVertices = new ArrayList<>();

        int numVertices = vertices.size();
        int lastFace = numVertices/2 + 1;

        if((numVertices/2) + 2 >  faceNum) {
            switch (faceNum) {
                case 0:
                    for(int i = 0; i < numVertices/2; i++)
                        faceVertices.add(i, vertices.get(i));
                    break;
                case 1:
                    for(int i = 0; i < numVertices/2; i++)
                        faceVertices.add(i, vertices.get(numVertices/2 + i));
                    break;
                default:
                    faceVertices.add(0, vertices.get(faceNum - 2));
                    faceVertices.add(1, vertices.get(numVertices/2 + faceNum - 2));
                    faceVertices.add(2, vertices.get(lastFace != faceNum ? numVertices/2 + faceNum - 1 : numVertices/2));
                    faceVertices.add(3, vertices.get(lastFace != faceNum ? faceNum - 1 : 0));
                    break;
            }
        } else {
            System.out.println(Globals.BUG_FACE_NULL);
        }

        Vector[] face = faceVertices.toArray(new Vector[faceVertices.size()]);

        return face;
    }
}
