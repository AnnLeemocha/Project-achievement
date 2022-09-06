package example;

/**
 * ■ 使用Ch9_ex1
 * ■ 採用多型的方式取得三部車子的對應資訊
 * _■ 宣告靜態方法 checkCar(Vehicle v)
 * _■ instanceof比對
 */

// 載入
import example.example.Vehicle;
import example.example.Car;
import example.example.Truck;

public class Ch9_ex2 {
    public static void main(String[] args) {
        // 宣告
        Vehicle v1 = new Vehicle();
        Car c1 = new Car();
        Truck t1 = new Truck(6, 200, 2, 50);

        // 擺放至陣列
        Vehicle[] vs = { v1, c1, t1 };

        for (Vehicle v : vs) {
            System.out.println("===========================================");
            checkCar(v);
        }
    }

    public static void checkCar(Vehicle v) {
        // System.out.println(v.getInfo());
        System.out.println(v.getWheels());
        System.out.println(v.getWeight());
        // Truck繼承Car類別，判別會不只 Car ，也會出現 Truck
        if (v instanceof Truck) {
            System.out.println("Truck：" + ((Truck) v).getPayload());
        } else if (v instanceof Car) {
            System.out.println("Car：" + ((Car) v).getLoader());
        }

        // if (v instanceof Car && !(v instanceof Truck)) {
        // System.out.println("Car：" + ((Car) v).getLoader());
        // }
        // if (v instanceof Truck) {
        // System.out.println("Truck：" + ((Truck) v).getPayload());
        // }
    }

}
