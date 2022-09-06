package lesson9;

import lesson9.animal.*;

public class Zoo_多型 { // 原型在 lesson9.animal 中的 Test.java
    public static void main(String[] args) {
        Rabbit r = new Rabbit("小兔", 3.5);
        Fox f = new Fox("小狐", 15);
        Panda p = new Panda("團圓", 50);
        // 多型向下轉型
        Animal a = new Parrot("阿飛", 8);
        Parrot parrot = (Parrot) a;

        System.out.println("--------------------------------");
        Animal animal = r; // 說明父類包容子類，子類可以向上轉型
        animal.eat();
        animal.sleep();
        // 優先呼叫子類別覆載的方法
        animal = parrot;
        animal.eat();
        // 父類不會知道子類特有的屬性和方法
        // 向上轉型無法引用，但向下轉型可以處理
        // animal.fly; // XX
        parrot.fly();
        // 多型的使用
        // 需先向上轉型，在向下轉型
        // 讓父類可取用到子類特有的屬性和方法 (向下轉型)
        // 強制轉型 [要先轉型，在取得方法] ---> 子物件=(子類別)父物件
        ((Parrot) animal).fly(); // OO

        System.out.println("--------------------------------");
        checkAnimal(r);
        checkAnimal(f);
        checkAnimal(p);
        checkAnimal(parrot);

        System.out.println("--------------------------------");
        Animal aa = new Animal("金剛XO", 5);
        // 多型
        // 函式雛形，測試
        Animal[] animals = { r, f, p, parrot, aa };
        for (Animal an : animals) {
            System.out.println(an);
            an.eat();
            // checkAnimal(an);
            // 確認型態 instanceof
            if (an instanceof Parrot) {
                ((Parrot) an).fly();
            }
            if (an instanceof Panda) {
                ((Panda) an).attack();
            }
            // System.out.println();
        }

        System.out.println("--------------------------------");
        Animal[] animals2 = { r, f, p, parrot, new Parrot(),
                new Animal("金剛", 5),
                new Parrot("阿揚", 5),
                new Fox("九尾", 7),
                new Rabbit("小白", 3),
                new Panda("胖達", 10) };
        System.out.println(animals2);
        // 目前有幾隻動物產生
        System.out.println("動物園目前共有" + Animal.getCounter() + "隻動物");

    }

    // 多型的使用
    // 父類 = 子類 (向上轉型)
    // 函式可輸入子類 會向上轉型
    public static void checkAnimal(Animal animal) {
        // System.out.println(animal);
        animal.eat();
        animal.info();
        // // 向上轉型只能使用父類有的
        // animal.attack();
        // animal.fly();
        // 讓父類可取用到子類特有的屬性和方法 (向下轉型)
        // 先向上轉型，在向下轉型
        // 子物件=(子類別)父物件
        // 確認型態 instanceof
        if (animal instanceof Parrot) {
            ((Parrot) animal).fly();
        }
        if (animal instanceof Panda) {
            ((Panda) animal).attack();
        }
    }

    // 重複邏輯，優化使用多型 (向上轉型)
    // 同時存在多型與多載，會以多載為主 (最準確的)
    // 多載
    ////////// 向上
    // public static void checkAnimal(Rabbit rabbit) {
    // System.out.println(rabbit);
    // rabbit.eat();
    // }
    // public static void checkAnimal(Fox fox) {
    // System.out.println(fox);
    // fox.eat();
    // }
    ////////// 向下
    // public static void checkAnimal(Panda panda) {
    // System.out.println(panda);
    // panda.eat();
    // panda.attack();
    // }
    // public static void checkAnimal(Parrot parrot) {
    // System.out.println(parrot);
    // parrot.eat();
    // parrot.fly();
    // }
}
