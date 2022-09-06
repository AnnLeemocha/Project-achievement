package lesson9;

import lesson9.animal.Animal;
import lesson9.animal.Fox;
import lesson9.animal.Rabbit;
import lesson9.animal.Wolf;

public class Zoo {
    public static void main(String[] args) {
        Animal animal = new Animal(); // Animal 覆寫 toString()
        System.out.println(animal); // 自帶 toString()
        System.out.println(animal.toString());
        // animal 原輸出
        // getClass().getName() + "@" + Integer.toHexString(hashCode());
        System.out.println(animal.hashCode());
        System.out.println(Integer.toHexString(animal.hashCode()));

        System.out.println("--------------------------------");
        Rabbit rabbit = new Rabbit("小兔", 3.5);
        Fox fox = new Fox("小狐", 15);
        Wolf wolf = new Wolf("小狼", 30);
        Wolf wolf2 = new Wolf();
        Wolf wolf3 = new Wolf("小狼", 30, 100);

        System.out.println("--------------------------------");
        rabbit.info();
        rabbit.eat();
        rabbit.sleep();
        rabbit.run();

        System.out.println("--------------------------------");
        fox.info();
        fox.eat();
        fox.sleep();
        fox.run();

        System.out.println("--------------------------------");
        wolf.info();
        wolf.eat();
        wolf.eat("水果"); // 多載
        wolf.sleep();
        wolf.run();

        System.out.println("--------------------------------");
        wolf2.info();
        wolf3.info();

        System.out.println("--------------------------------");
        System.out.println(Math.PI); // 為常數(不可改動)
        // public static final double PI = 3.14159265358979323846;
        // final public static double PI = 3.14159265358979323846;

        System.out.println("--------------------------------");
        // System.out.println(rabbit.sex); // 保護，不同 package 不可用
        // System.out.println(animal.sex);
    }
}
