package example;

public class Ch9_ex1_2 {
    // 測試程式碼
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        System.out.println(v1);

        Car c1 = new Car();
        System.out.println(c1);

        Car c2 = new Car(4, 50);
        c2.setLoader(4);
        System.out.println(c2);

        Truck t1 = new Truck(6, 200, 2, 50);
        System.out.println(t1);
    }

}

// Truck繼承Car類別
class Truck extends Car {
    // 屬性
    private double payload;

    // 建構式
    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight);
        setLoader(loader);
        setPayload(payload);
    }

    // 方法
    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f} Taxi{loader=%d} Truck{playload=%.0f}",
                getWheels(), getWeight(), getLoader(), payload);
    }
}

// Car繼承Vehicle類別
class Car extends Vehicle {
    // 屬性
    private int loader;

    // 建構式
    public Car() {
        setWeight(20);
        setWheels(4);
        loader = 4;
    }

    public Car(int wheels, double weight) {
        super(wheels, weight);
        loader = 4; // 按題意之測試方式，可以不寫
    }

    // 方法
    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f} Taxi{loader=%d}",
                getWheels(), getWeight(), loader);
    }
}

// Vehicle類別
class Vehicle {
    // 屬性
    private int wheels;
    private double weight;

    // 建構式
    public Vehicle() {

    }

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    // get方法
    public int getWheels() {
        return wheels;
    }

    public double getWeight() {
        return weight;
    }

    // set方法
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f}",
                wheels, weight);
    }

}
