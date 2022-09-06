package lesson10;

public class Rectangle extends Shape {
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 子類別繼承父類別，父類別為抽象類別時，一定要實作(覆寫)抽象方法，要不然會報錯
    @Override
    public double getArea() {
        area = height * width;
        return area;
    }

}
