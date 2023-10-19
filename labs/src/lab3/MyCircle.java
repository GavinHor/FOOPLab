package lab3;

import java.util.HashSet;
import java.util.Set;

public class MyCircle implements MyShape {
    double radius = 0;
    static double pi = 3.14159;
    Set<Set<Connector>> circles = new HashSet<>();

    public MyCircle(double radius) {
        this.radius = radius;
    }

    public MyCircle(double radius, Set<Set<Connector>> circles) {
        this.radius = radius;
        this.circles = circles;
    }
    public int testMethod (int intValue, double doubleValue, testClass test) {
        return 1;
    }

    public double area() {return pi * radius * radius;}

    class testClass {
        public int hello = 1;
    }
}
