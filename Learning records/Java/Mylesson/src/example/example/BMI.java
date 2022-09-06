package example.example;

public class BMI {
    /**
     * 屬性資料
     */
    private String name;
    private int age;
    private double weight;
    private double height;
    private double bmi;

    /**
     * 方法資料 - 建構式
     */
    BMI() {
        age = 20;
    }

    public BMI(String newName, int newAge, double newWeight, double newHeight) {
        setName(newName);
        setAge(newAge);
        setWeight(newWeight);
        setHeight(newHeight);
        System.out.println("歡迎進入 BMI 計算程式~");
        System.out.println("請注意輸入單位：身高(cm)，體重(kg)");
    }

    public BMI(String newName, double newWeight, double newHeight) {
        this();
        setName(newName);
        setWeight(newWeight);
        setHeight(newHeight);
        System.out.println("歡迎進入 BMI 計算程式~");
        System.out.println("請注意輸入單位：身高(cm)，體重(kg)");
        System.out.println("年齡已預設為20歲");
    }

    /**
     * 方法資料 - 操作
     */
    public double getBMI() {
        if (isNotSet()) {
            return -1;
        }
        // 計算 BMI (BMI值計算公式: BMI = 體重(公斤) / 身高^2(公尺^2))
        // BMI < 18.5 => 體重過輕
        // 18.5 ≦ BMI < 24 => 正常範圍
        // 24 ≦ BMI < 27 => 體重過重
        // BMI ≧ 27 => 體重肥胖
        bmi = weight / Math.pow(height / 100, 2);
        return bmi;
    }

    /**
     * 資料顯示 - get 系列
     */
    // 身分狀況資訊
    public String getStatus() {
        if (isNotSet()) {
            return null;
        }
        return String.format("姓名：%s \t 年齡：%d \t BMI：%.2f", name, age, bmi);
    }

    // 身高資訊
    public double getHeight() {
        if (isNotSet()) {
            return -1;
        }
        return height;
    }

    // 體重資訊
    public double getWeight() {
        if (isNotSet()) {
            return -1;
        }
        return weight;
    }

    // 姓名資訊
    public String getName() {
        return name;
    }

    // 年齡資訊
    public int getAge() {
        return age;
    }

    /**
     * 資料修正 - set 系列
     */
    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        if (age <= 0) {
            System.out.println("年齡輸入錯誤！");
            return;
        }
        age = newAge;
    }

    public void setWeight(double newWeight) {
        weight = newWeight;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    /**
     * 確認輸入
     * 
     * @return
     */
    public boolean isNotSet() {
        if (weight <= 0 || height <= 0) {
            System.out.println("身高體重尚未輸入！");
            return true;
        }
        return false;

    }
}
