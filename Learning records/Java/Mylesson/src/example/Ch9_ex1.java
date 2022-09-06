package example;

/**
 * 測試程式碼
 * 汽車父類別 Vehicle
 * 汽車子類別 Car , Truck
 */

// 載入
import example.example.Car;
import example.example.Truck;
import example.example.Vehicle;

public class Ch9_ex1 {
    public static void main(String[] args) {
        // 有依照作業結果顯示去調整預設值

        Vehicle v1 = new Vehicle();
        System.out.println(v1);

        Car c1 = new Car();
        System.out.println(c1);

        Car c2 = new Car(4, 50);
        c2.setLoader(4);
        System.out.println(c2);

        Truck t1 = new Truck(6, 200, 2, 50);
        System.out.println(t1);

        // Info 輸出格式測試
        // System.out.println(v1.getInfo());
        // System.out.println(c1.getInfo());
        // System.out.println(c2.getInfo());
        // System.out.println(t1.getInfo());
    }
}
