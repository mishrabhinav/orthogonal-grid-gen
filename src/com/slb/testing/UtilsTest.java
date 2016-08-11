package com.slb.testing;

import com.slb.components.cells.Cell;
import com.slb.components.Vector;
import com.slb.components.cells.HexCell;
import com.slb.utils.Utils;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Ignore
    @Test
    public void getBarycenter() throws Exception {

    }

    @Ignore
    @Test
    public void getFaceCenter() throws Exception {

    }

    @Ignore
    @Test
    public void valueWithPlane() throws Exception {

    }

    @Ignore
    @Test
    public void arePointsOnSameSide() throws Exception {

    }

    @Test
    public void insideCellTrue() throws Exception {
        Utils utils = new Utils();

        Cell c = new HexCell(0, new Vector(5, 5, 5));
        c.getVertices().add(0,new Vector(0,0,10));
        c.getVertices().add(1,new Vector(0,10,10));
        c.getVertices().add(2,new Vector(10,10,10));
        c.getVertices().add(3,new Vector(10,0,10));
        c.getVertices().add(4,new Vector(0,0,0));
        c.getVertices().add(5,new Vector(0,10,0));
        c.getVertices().add(6,new Vector(10,10,0));
        c.getVertices().add(7,new Vector(10,0,0));

        boolean inside = utils.insideCell(c, new Vector(7,7,7));

        assertEquals(true, inside);
    }

    @Test
    public void insideCellFalse() throws Exception {
        Utils utils = new Utils();

        Cell c = new HexCell(0, new Vector(5, 5, 5));
        c.getVertices().add(0,new Vector(0,0,10));
        c.getVertices().add(1,new Vector(0,10,10));
        c.getVertices().add(2,new Vector(10,10,10));
        c.getVertices().add(3,new Vector(10,0,10));
        c.getVertices().add(4,new Vector(0,0,0));
        c.getVertices().add(5,new Vector(0,10,0));
        c.getVertices().add(6,new Vector(10,10,0));
        c.getVertices().add(7,new Vector(10,0,0));

        boolean inside = utils.insideCell(c, new Vector(5,11,5));

        assertEquals(false, inside);
    }

    @Ignore
    @Test
    public void vectorToCentre() throws Exception {

    }

    @Test
    public void faceNormalPlanar() throws Exception {
        Utils utils = new Utils();

        Cell c = new HexCell(0, new Vector(0, 0, 0));
        c.getVertices().add(0, new Vector(1,2,1) );
        c.getVertices().add(1, new Vector(2,1,0) );
        c.getVertices().add(2, new Vector(3,1,1) );
        c.getVertices().add(3, new Vector(4,1,2) );

        Vector v = utils.faceNormal(c, 0);

        assertEquals(new Vector(2, 4, -2), v);
    }

    @Test
    public void faceNormalNonPlanar() throws Exception {
        Utils utils = new Utils();

        Cell c = new HexCell(0, new Vector(0, 0, 0));
        c.getVertices().add(0, new Vector(1,2,1) );
        c.getVertices().add(1, new Vector(2,1,0) );
        c.getVertices().add(2, new Vector(4,1,1) );
        c.getVertices().add(3, new Vector(4,1,2) );

        Vector v = utils.faceNormal(c, 0);

        assertEquals(new Vector(2, 6, -2), v);
    }

    @Test
    public void angleBetweenVectors() throws Exception {
        Utils utils = new Utils();
        assertEquals(Math.acos(1/Math.sqrt(2)), utils.angleBetweenVectors(new Vector(0,1,1), new Vector(0,1,0)), 0.00001);
    }

}