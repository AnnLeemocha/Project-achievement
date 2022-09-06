package lesson9;

public class Fox2 {
    private String name;
    private double weight;

    // public Fox2(){
    // }

    // 強制輸入，不要空建構式
    public Fox2(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // 行為特徵
    public void eat() {
        System.out.println("喜歡吃肉");
    }

    public void sleep() {
        System.out.println("夜行性動物，喜歡白天睡覺");
    }

    public void run() {
        System.out.println("跑超級快");
    }

    public void info() {
        System.out.printf("姓名：%s \t 體重：%.2f\n", name, weight);
    }
}
