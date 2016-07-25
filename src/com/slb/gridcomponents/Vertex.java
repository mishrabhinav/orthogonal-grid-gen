package com.slb.gridcomponents;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Vertex {

    public double x;
    public double y;
    public double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(Vertex b) {
        add(b.x, b.y, b.z);
    }

    public void add(double scalarx, double scalary, double scalarz) {
        this.x += scalarx;
        this.y += scalary;
        this.z += scalarz;
    }

    public void subtract(Vertex b) {
        subtract(b.x, b.y, b.z);
    }

    public void subtract(double scalarx, double scalary, double scalarz) {
        this.x -= scalarx;
        this.y -= scalary;
        this.z -= scalarz;
    }

    public void multiply(double scalarx, double scalary, double scalarz) {
        this.x *= scalarx;
        this.y *= scalary;
        this.z *= scalarz;
    }

    public void divide(double scalarx, double scalary, double scalarz) {
        this.x /= scalarx;
        this.y /= scalary;
        this.z /= scalarz;
    }

}
