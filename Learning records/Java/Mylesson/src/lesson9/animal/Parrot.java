package lesson9.animal;

public class Parrot extends Animal {
    protected int winds;

    // // 第二種解法 (進行 winds 預設)
    // protected int winds=2;

    public Parrot() {
        System.out.println("我是鸚鵡！");
        winds = 2;
    }

    public Parrot(String name, double weight) {
        super(name, weight);
        // 不會進入 Parrot() 中，進行 winds 預設
        // // 第一種解法
        // System.out.println("我是鸚鵡！");
        winds = 2;
    }

    public void fly() {
        System.out.printf("我有%d個翅膀，我能飛~\n", winds);
    }

    @Override
    public void eat() {
        System.out.println("我吃蟲子！");
    }

}
