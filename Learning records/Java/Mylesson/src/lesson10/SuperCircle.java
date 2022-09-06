package lesson10;

public class SuperCircle extends Circle {

    SuperCircle(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        area = Math.pow(radius, 2) * Math.PI;
        return area;
    }

    @Override
    // 覆載時，可更改修飾子，但不能小於原本的修飾範圍 [public>protected>package>private]
    public double getPerimeter() {
        area = radius * 2 * Math.PI;
        return area;
    }

}
