package lab3;

import java.util.HashSet;
import java.util.Set;

public class MyCircle implements MyShape {
    double radius = 0;
    static double pi = 3.14159;

    Set<Connector> circles = new HashSet<>();

    public MyCircle(double radius) {
        this.radius = radius;
    }

    public MyCircle(double radius, Set<Connector> circles) {
        this.radius = radius;
        this.circles = circles;
    }

    public double area() {return pi * radius * radius;}
}
