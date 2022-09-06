package lesson9.animal;

public class Test {
    public static void main(String[] args) {
        Rabbit r = new Rabbit("小兔", 3.5);
        Panda p = new Panda();
        Fox f = new Fox("小狐", 15);

        Animal animal; // 說明父類包容子類，子類可以向上轉型
        // 向上轉型
        animal = new Rabbit("小兔", 3.5);
        animal.eat();
        System.out.println(animal);
        animal = new Panda();
        animal.eat();
        System.out.println(animal);
        animal = new Fox("小狐", 30);
        animal.eat();
        System.out.println(animal);

        System.out.println("--------------------------------");
        System.out.println(r.sex);
        System.out.println(p.sex);
        System.out.println(f.sex);

        System.out.println("--------------------------------");
        checkAnimal(r);
        checkAnimal(p);
        checkAnimal(f);

    }

    // 多型的使用
    // 父類 = 子類 (向上轉型)
    // 函式可輸入子類 會向上轉型
    public static void checkAnimal(Animal animal) {
        System.out.println(animal);
        animal.eat();
    }

    // public static void checkAnimal(Rabbit rabbit) {
    // System.out.println(rabbit);
    // rabbit.eat();
    // }

    // public static void checkAnimal(Panda panda) {
    // System.out.println(panda);
    // panda.eat();
    // }

    // public static void checkAnimal(Fox fox) {
    // System.out.println(fox);
    // fox.eat();
    // }
}
