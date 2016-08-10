package com.slb.components;

import com.slb.utils.Globals;

/**
 * Created by AMishra12 on 22/07/2016.
 */
public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Vector clone() {
        return new Vector(this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Vector))
            return false;
        else {
            Vector thatVector = (Vector) that;
            return thatVector.x == this.x && thatVector.y == this.y && thatVector.z == this.z;
        }
    }

    @Override
    public int hashCode() {
        return ((int) x) + ((int) y) + ((int) z);
    }

    @Override
    public String toString() {
        return String.format(Globals.PRINT_VECTOR, this.x, this.y, this.z);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector add(Vector b) {
        return add(b.x, b.y, b.z);
    }

    public Vector add(double scalarx, double scalary, double scalarz) {
        this.x += scalarx;
        this.y += scalary;
        this.z += scalarz;

        return this;
    }

    public Vector subtract(Vector b) {
        return subtract(b.x, b.y, b.z);
    }

    public Vector subtract(double scalarx, double scalary, double scalarz) {
        this.x -= scalarx;
        this.y -= scalary;
        this.z -= scalarz;

        return this;
    }

    public Vector multiply(double scalarx, double scalary, double scalarz) {
        this.x *= scalarx;
        this.y *= scalary;
        this.z *= scalarz;

        return this;
    }

    public Vector divide(double scalarx, double scalary, double scalarz) {
        this.x /= scalarx;
        this.y /= scalary;
        this.z /= scalarz;

        return this;
    }

    public double dot(Vector B) {
        return this.x * B.x + this.y * B.y + this.z * B.z;
    }

    public Vector cross(Vector B) {
        return new Vector(this.y * B.z - this.z * B.y, this.z * B.x - this.x * B.z, this.x * B.y - this.y * B.x);
    }


}
