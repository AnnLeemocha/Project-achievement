package lesson10;

/**
 * 形狀
 */
/**
 * 抽象類別
 * 沒有抽象方法是不太正確的寫法
 * 但有抽象的方法一定要宣告為抽象的類別
 */

public abstract class Shape { // 抽象類別
    // private double width; // 子類無法取用該變數
    protected double width;
    protected double height;
    protected double area;

    public Shape() {
    }

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // public Shape(double width, double height, double area) {
    // this.width = width;
    // this.height = height;
    // this.area = area;
    // }

    public abstract double getArea(); // 抽象方法

    // public double getArea() {
    // // area=height*width;
    // return this.area;
    // }

    // ===================================================== //

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Shape width(double width) {
        setWidth(width);
        return this;
    }

    public Shape height(double height) {
        setHeight(height);
        return this;
    }

    public Shape area(double area) {
        setArea(area);
        return this;
    }

}
