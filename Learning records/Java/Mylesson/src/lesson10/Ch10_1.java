package lesson10;

/**
 * 
 */
public class Ch10_1 {
    public static void main(String[] args) {
        // 抽象(父)類別不可宣告為實體
        // Shape shape = new Shape();
        // Circle circle= new Circle(10.0);
        SuperCircle circle = new SuperCircle(10.0);
        // 抽象(子)類別不可宣告為實體
        Rectangle rectangle = new Rectangle(100, 200);

        // 多型陣列 - 向上轉型
        Shape[] shapes = { rectangle, circle };
        // Shape[] shapes = { shape, rectangle };

        for (Shape s : shapes) {
            System.out.println(s.getArea());
            // Circle 為抽象(子)類別不可宣告為實體，所以判斷式不會錯誤
            if (s instanceof Circle) {
                // 多型 - 向下轉型
                Circle c = (Circle) s;
                System.out.println(c.getRadius());
                System.out.println(((Circle) s).getPerimeter());
            }
        }
    }
}
