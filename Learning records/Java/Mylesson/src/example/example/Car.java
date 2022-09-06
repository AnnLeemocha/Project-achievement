package example.example;

/**
 * 汽車子類別 Car
 * ■ 宣告Car繼承Vehicle類別
 * _■ 屬性:增加載客數
 * _■ -loader:int
 * [Car(wheels,weight)]
 */
public class Car extends Vehicle {
    // 子類特有屬性
    private int loader = 4; // 載客數：駕駛+乘客

    public Car() {
        super();
        setWheels(4);
        setWeight(20);
    }

    public Car(int wheels, double weight) {
        super(wheels, weight);
    }

    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);

        setLoader(loader);
    }

    // setter
    public void setLoader(int loader) {
        if (loader > 0) {
            this.loader = loader;
        }
    }

    // getter
    public int getLoader() {
        return loader;
    }

    // 覆載
    @Override
    public String getInfo() {
        return String.format("""
                車輪數：%d
                重量：%.1f
                載客數：%d""",
                getWheels(), getWeight(), loader);
    }

    @Override
    public String toString() {
        return String.format("Vehicle{wheels=%d, weight=%.1f}    Taxi{loader=%d}",
                getWheels(), getWeight(), loader);
    }
}
