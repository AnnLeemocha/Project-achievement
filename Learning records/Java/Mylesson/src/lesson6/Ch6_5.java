package lesson6;

public class Ch6_5 {

    public static void main(String[] args) {
        // 方形
        System.out.println("面積為： " + getArea(10, 20));
        System.out.println("面積為： " + getArea(10.5f, 20.5f));
        System.out.println("面積為： " + getArea(10.5, 20.5, 0));
        // 三角形
        System.out.println("面積為： " + getArea(10.5, 20.5, 1));
        getArea(10.5, 20.5, 1);
        // 圓型
        System.out.println("面積為： " + getCircleArea(10.5f));
        // 立方體
        System.out.println("面積為： " + getArea(10, 20, 30));
    }

    // 不變的變數宣告
    final static int rectangle = 0, trangle = 1;
    // 模擬 Math 中 public static final double PI = 3.14159265358979323846;

    // 圓形面積
    public static float getCircleArea(float radius) {
        // System.out.println("圓面積為：" + radius * radius * Math.PI);
        return (float) (Math.PI * radius * radius);
    }

    // 方形面積：
    // getArea() --> int
    public static int getArea(int width, int height) {
        int area = width * height;
        return area;
    }

    //// 「函式多載」 (method overloading)
    // 同一個類別中,允許方法宣告用相同的名稱
    // 引數必須是資料型别不同,個數或順序不同
    // 方形面積：
    // getArea() --> float
    public static float getArea(float width, float height) {
        float area = width * height;
        return area;
    }

    // 物件導向會有更好的解法
    // 方形面積： rectangle = 0
    // 三角形面積： trangle = 1
    // getArea() --> double
    public static double getArea(double width, double height, int type) {
        double area = 0;
        if (rectangle == type) {
            area = width * height;
        } else if (trangle == type) {
            area = width * height / 2;
        }
        return area;
    }

    // 圓面積
    // getArea() --> float --> circle
    public static float getArea(float radius) {
        // System.out.println("圓面積為：" + radius * radius * Math.PI);
        return (float) (Math.PI * radius * radius);
    }

    // 梯形

    // 立方體面積
    // getArea() --> double
    public static double getArea(double width, double height, double length) {
        double area = width * height * length;
        return area;
    }
}
