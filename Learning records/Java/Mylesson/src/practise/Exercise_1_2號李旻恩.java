package practise;

/**
 *  請計算下面圖形的面積,並輸出總面積。
 * 1. 圓的半徑=5,PI=3.1415926,圓面積計算公式:半徑平方*PI。
 * 2. 三角形的底=10,高=5,三角形面積公式:底*高/2。
 * 3. 長方形的長=5,寬=10,長方形面積公式:長*寬。
 * 4. 總面積=圓面積+三角形面積+長方形面積,執行結果如範例圖。
 */

public class Exercise_1_2號李旻恩 {
    public static void main(String[] args) {

        // ---------------------------------------------------------
        // 圓面積計算公式:半徑平方*PI。

        // 輸入
        final float PI = 3.1415926f;
        float radius = 5f;
        // 計算
        float circleArea = radius * radius * PI;
        // float circleArea = (float) Math.pow(radius, 2) * PI;
        // 輸出
        System.out.println("圓面積為：" + circleArea);
        // System.out.printf("圓面積為：%f %n", circleArea);

        // ---------------------------------------------------------
        // 三角形面積公式:底*高/2。

        // 輸入
        float base = 10f, height = 5f;
        // 計算
        float triangleArea = base * height / 2;
        // 輸出
        System.out.println("三角形面積為：" + triangleArea);

        // ---------------------------------------------------------
        // 長方形面積公式:長*寬。

        // 輸入
        float length = 5f, width = 10f;
        // 計算
        float rectangleArea = length * width; // 計算
        // 輸出
        System.out.println("長方形面積為：" + rectangleArea);

        // ---------------------------------------------------------
        // 總面積=圓面積+三角形面積+長方形面積

        // 計算
        float totalArea = circleArea + triangleArea + rectangleArea; // 計算
        // 輸出
        System.out.println("總面積為：" + totalArea);

    }
}
