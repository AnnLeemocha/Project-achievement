package lesson10.animal;

public class Rabbit extends Animal {
    /*
     * 子類別實體化後會先呼叫父類別的建構式
     * 如果沒有指定呼叫哪個父類別建構式則會
     * 自動呼叫無參數建構式為主，
     * 透過super()關鍵字
     */
    public Rabbit(String name, double weight) {
        super(name, weight);
        // 改成預設為女生
        sex = FEMALE; // 保護
        // System.out.println(name2);
    }

    @Override
    public void eat() {
        // // TODO Auto-generated method stub
        // super.eat();
        System.out.println("喜歡吃草");

    }

    @Override
    public void sound() {
        System.out.println("啾啾啾~");
    }
}
