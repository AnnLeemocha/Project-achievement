package lesson9;

public class Rabbit2 {
    private String name;
    private double weight;

    // public Rabbit2(){
    // }

    // 強制輸入，不要空建構式
    public Rabbit2(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // 行為特徵
    public void eat() {
        System.out.println("喜歡吃草");
    }

    public void sleep() {
        System.out.println("喜歡睡覺");
    }

    public void run() {
        System.out.println("跑很快");
    }

    public void info() {
        System.out.printf("姓名：%s \t 體重：%.2f\n", name, weight);
    }
}
