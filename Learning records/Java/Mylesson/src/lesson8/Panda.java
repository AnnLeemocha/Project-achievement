package lesson8;

import lesson9.animal.Animal;

public class Panda extends Animal {

    Panda() {
        sex = FEMALE; // 保護，讓子類快速取到屬性
        System.out.println(sex);
        // System.out.println(sex2); // 不同 package
    }

    @Override
    public void eat() {
        System.out.println("我喜歡吃竹子");
    }
}
