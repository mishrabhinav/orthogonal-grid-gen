package com.slb.components.cells;

import com.slb.components.Vector;

public class TdFCell extends Cell {

    public TdFCell(int cellID, Vector centre) {
        super(cellID, centre);
    }

    @Override
    public Vector[] getFace(int faceNum) {
        return new Vector[0];
    }
}
