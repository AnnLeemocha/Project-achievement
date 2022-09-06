package lesson10.animal;

public class Parrot extends Animal implements Fly, Skill {
    // protected int wings;

    // // 第二種解法 (進行 winds 預設)
    // protected int winds=2;

    public Parrot() {
        System.out.println("我是鸚鵡！");
        // wings = 2;
    }

    public Parrot(String name, double weight) {
        super(name, weight);
        // 不會進入 Parrot() 中，進行 winds 預設
        // // 第一種解法
        // System.out.println("我是鸚鵡！");
        // wings = 2;
    }

    // ------------------------------------------------

    @Override
    public void eat() {
        System.out.println("我吃蟲子！");
    }

    @Override
    public void sound() {
        System.out.println("逼逼逼~");
    }

    @Override
    public void fly() {
        System.out.printf("我有%d個翅膀，我能飛~\n", Fly.WINGS);
    }

    @Override
    public String toString() {
        return String.format("姓名：%s \t 體重：%.2f \t 我有%d雙翅膀",
                getName(), getWeight(), Fly.WINGS);
    }

    @Override
    public void skill() {
        System.out.println("語言精通！");
    }
}
