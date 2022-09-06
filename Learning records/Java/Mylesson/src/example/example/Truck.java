package example.example;

/**
 * 汽車子類別 Truck
 * ■ 宣告Truck繼承Car類別
 * _■ 屬性:增加載重量
 * _■ -payload:double
 * [Truck(wheels,weight,loader,payload)]
 */
public class Truck extends Car {
    // 子類特有屬性
    private double payload = 500; // 載重量：500(kg)

    public Truck() {
        super();
    }

    public Truck(int wheels, double weight) {
        super(wheels, weight);
    }

    public Truck(int wheels, double weight, int loader) {
        super(wheels, weight, loader);
    }

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        setPayload(payload);
    }

    // setter
    public void setPayload(double payload) {
        if (payload > 0) {
            this.payload = payload;
        }
    }

    // getter
    public double getPayload() {
        return payload;
    }

    // 覆載
    @Override
    public String getInfo() {
        return String.format("""
                車輪數：%d
                重量：%.1f
                載客數：%d
                載重量：%.0f""",
                getWheels(), getWeight(), getLoader(), payload);
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f}    Taxi{loader=%d}    Truck{payload=%.0f}",
                getWheels(), getWeight(), getLoader(), payload);
    }
}
