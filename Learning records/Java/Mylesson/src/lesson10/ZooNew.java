package lesson10;

import lesson10.animal.*;

public class ZooNew {
    public static void main(String[] args) {
        Animal[] animals = {
                new Rabbit("兔嘰", 3),
                new Fox("福貍", 3.5),
                new Parrot("飛飛", 2.0),
                new Panda("胖達", 10.0),
                new Wolf("灰太郎", 5)
        };
        System.out.println("-------------------------------");
        for (Animal a : animals) {
            System.out.println(a);
            a.eat();
            a.sound();
            if (a instanceof Parrot) {
                Parrot p = (Parrot) a;
                p.fly();
            }
            System.out.println("===========");
        }

        System.out.println("動物園目前共有" + Animal.getCounter() + "隻動物");
    }
}
