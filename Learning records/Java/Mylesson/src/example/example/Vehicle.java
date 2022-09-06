package example.example;

/**
 * 汽車父類別 Vehicle
 * ■ 屬性為 (車輪數,重量)
 * ■ -wheels:int
 * ■ -weight:double
 * ■ +Vehicle()
 * ■ +Vehicle(wheels:int,weight:double)
 * ■ 對應屬性的get/set方法
 */
public class Vehicle {
    // 屬性
    private int wheels; // 車輪數：4個
    private double weight; // 重量：1000(kg)
    private static int count; // 總共建立幾輛汽車

    // 建構式(一)
    public Vehicle() {
        // wheels = 4;
        // weight = 1000;
        count++;
    }

    // 建構式(二)
    public Vehicle(int wheels, double weight) {
        this();
        setWheels(wheels);
        setWeight(weight);
    }

    // setter
    public void setWheels(int wheels) {
        if (wheels > 0) {
            this.wheels = wheels;
        }
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    // getter
    public int getWheels() {
        return wheels;
    }

    public double getWeight() {
        return weight;
    }

    public static int getCounter() {
        return count;
    }

    // Info
    public String getInfo() {
        return String.format("""
                車輪數：%d
                重量：%.1f""",
                wheels, weight);
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f}", wheels, weight);
    }

}
