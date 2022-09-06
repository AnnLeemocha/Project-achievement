package lesson10;

/**
 * 類別繼承抽象類別後也可以抽象化
 * 1.
 * 2.
 */
public abstract class Circle extends Shape {

    protected double radius;
    // private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    // 抽象類別，即使為子類，也可不進行實作
    // @Override
    // public double getArea() {
    // area = Math.pow(radius, 2) * Math.PI;
    // return area;
    // }

    protected abstract double getPerimeter();

    public double getRadius() {
        return radius;
    }
}
