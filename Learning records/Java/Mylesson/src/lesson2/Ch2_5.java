package lesson2;

// 字串測試
public class Ch2_5 {
    public static void main(String[] args) {

        // float pi = 3.1415926f;
        // 常數宣告(不可變)，通常變數用大寫 (最多加_)
        final float PI = 3.1415926f;

        // float radius = 5.5f;
        int radius = 5;
        // radius*radius*pi
        double area = radius * radius * PI;

        // System.out.println("半徑：" + radius);
        // System.out.println("圓周率：" + pi);
        // System.out.println("圓面積：" + area);
        // System.out.println("圓周長：" + (radius * 2 * pi));
        System.out.println("半徑：" + radius + " 圓周率：" + PI + " 圓面積：" + area
                + " 圓周長：" + (radius * 2 * PI));
        System.out.printf("半徑：%10d 圓周率：%8.5f 圓面積：%.3f 圓周長：%6.2f\n",
                radius, PI, area, (radius * 2 * PI));
        // System.out.printf("半徑：%d 圓周率：%f 圓面積：%f 圓周長：%f\n",
        // radius, PI, area, (radius * 2 * PI));

    }
}
