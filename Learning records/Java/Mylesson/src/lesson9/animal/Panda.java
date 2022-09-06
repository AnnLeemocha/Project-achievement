package lesson9.animal;

public class Panda extends Animal {

    Panda() {
        sex = FEMALE; // 保護，讓子類快速取到屬性
        System.out.println(sex);
        // System.out.println(sex2); // 不同 package
    }

    public Panda(String name, double weight) {
        super(name, weight);
    }

    public void attack() {
        System.out.println("功夫熊貓");
    }

    @Override
    public void eat() {
        System.out.println("我喜歡吃竹子");
    }
}
