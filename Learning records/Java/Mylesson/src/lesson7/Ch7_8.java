package lesson7;

import lesson8.*;
// import lesson8.Circle;

public class Ch7_8 {
    public static void main(String[] args) {
        // Ch8 測試用 ======================================================

        // 類別方法沒有 public (限 package lesson8 區域使用)，
        // 所以要決定類別方法那些要公開

        // 取用 Circle 類別 ： 方法(一)
        // lesson8.Circle s1 = new lesson8.Circle();

        // 取用 Circle 類別 ： 方法(二)
        Circle s1 = new Circle();

        // 取用 Circle 類別方法之多載 (非 public -> package)
        // Circle s2 = new Circle(10.0);

        // (四) 取用 Circle 類別屬性 (非 public -> package)
        // s1.radius = 100;

        // (五) 圓面積
        System.out.printf("圓面積 = %.2f\n", s1.getArea());

        // (六) 圓周長
        System.out.printf("圓周長 = %.2f\n", s1.getPerimeter());

        // (七) 類別屬性 s1.radius 非 public 所以寫個 類別方法取 radius (類別屬性)
        System.out.printf("圓半徑 = %.2f\n", s1.getRadius());

        // (八) 同上，但為更改 radius (類別屬性)
        s1.setRadius(10);
        System.out.printf("圓半徑 = %.2f\n", s1.getRadius());
        s1.setRadius(-10);
        s1.setRadius(20000);

        // Ch8 - TV.java 測試用 ======================================================
        // TV tv = new TV(10, 3);
        TV_OPT tv = new TV_OPT(10, 3);
        tv.getInfo();
        tv.turnOn();
        tv.getInfo();
        System.out.println("--------------------------");

        // 修飾子 ---> package (package相同才可取用)
        // tv.setBrand("YYYY");
        System.out.println(tv.getInfo());

        // 修飾子 ---> private (只能用get函式獲取屬性資訊)
        // System.out.println(tv.brand);
        System.out.println(tv.getBrand());

        tv.getInfo();
        System.out.printf("品牌：%s \t開關：%b \t頻道：%d \t音量：%d\n",
                tv.getBrand(), tv.getOn(), tv.getChannel(), tv.getVolumeLevel());
    }

}
