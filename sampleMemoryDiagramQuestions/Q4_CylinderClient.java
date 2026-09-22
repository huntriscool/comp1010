class Cylinder {
    public double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}

public class CylinderClient {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder(5.0, 10.0);
        Cylinder c2 = new Cylinder(c1.radius, c1.height);
        Cylinder c3 = c2;
        c2.height++;
        c2 = c1;
    }
}