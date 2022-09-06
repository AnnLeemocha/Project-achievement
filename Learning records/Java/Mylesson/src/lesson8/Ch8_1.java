package lesson8;

public class Ch8_1 {
    // ■ Java 類別的宣告方式
    // [修飾子] class 類別名稱{
    // [修飾子] 類別的屬性
    // [修飾子] 類別的方法
    // }
    public static void main(String[] args) {
        // Circle 為全公開所以可以使用
        Circle s1 = null; // 沒給實體 null
        Circle s2 = new Circle(); // 產生實體 給記憶體位置
        Circle s3 = new Circle(5.5);

        System.out.println(s1); // 沒給實體 null
        System.out.println(s2); // 產生實體 給記憶體位置
        System.out.println(s3);

        // 呼叫方法
        // System.out.println(s1.getArea()); // 空(沒實體)物件不可顯示
        System.out.println(s2.getArea()); // 用預設值代入計算
        System.out.println(s3.getArea());

        // 取屬性
        // System.out.println(s1.radius);
        System.out.println(s2.radius);
        System.out.println(s3.radius);
        // 修改半徑
        s2.radius = 3.0;
        System.out.printf("s2 的面積為 %.2f\n", s2.getArea());

        // 圓面積
        System.out.printf("圓面積 = %.2f\n", s2.getArea());

        // 圓周長
        System.out.printf("圓周長 = %.2f\n", s2.getPerimeter());

        // 類別屬性 s1.radius 非 public 所以寫個 類別方法取 radius (類別屬性)
        System.out.printf("圓半徑 = %.2f\n", s2.getRadius());

        // 同上，但為更改 radius (類別屬性)
        s2.setRadius(10);
        System.out.printf("圓半徑 = %.2f\n", s2.getRadius());
        s2.setRadius(-10);
        s2.setRadius(20000);

    }

}
