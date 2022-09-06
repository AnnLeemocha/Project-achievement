package lesson10;

import lesson10.animal.*;;

public class Ch10_3 {
    // 例外處理 throws CloneNotSupportedException
    // public static void main(String[] args) throws CloneNotSupportedException {
    public static void main(String[] args) {
        Parrot parrot1 = new Parrot("飛1", 8);
        Parrot parrot2 = new Parrot("飛2", 10);

        Fox fox = new Fox("九尾", 5);
        Wolf wolf = new Wolf("嘯天狼", 30);

        Parrot[] flys = { parrot1, parrot2 };
        for (Parrot fly : flys) {
            System.out.println(fly);
            fly.eat();
            fly.fly();
        }

        System.out.println("========================");

        Animal[] animals = { parrot1, fox, wolf };

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.eat();
            if (animal instanceof Fly) {
                ((Fly) animal).fly();
            }
            if (animal instanceof Skill) {
                ((Skill) animal).skill();
            }
            System.out.println("-------------");
        }

        System.out.println("========================");
        // 記憶體位置是否相等(==) [FF]
        System.out.println(parrot1 == parrot2);
        System.out.println(parrot1.equals(parrot2));

        // 內容值是否相等(equals()) <--- 還是記憶體 [TT]
        Parrot parrot3 = parrot1;
        System.out.println(parrot1 == parrot3);
        System.out.println(parrot1.equals(parrot3));

        // 故覆寫 equals() 來比對物件，個屬性值是否相等 [FT]
        parrot3 = new Parrot("飛1", 8); // 設定同 parrot1
        System.out.println(parrot1 == parrot3);
        System.out.println(parrot1.equals(parrot3));

        // // 因每個類別都繼承來自於Object，所以(equals())可比對
        // // 照理說繼承不同父類不可以做比對
        // SuperCircle circle = new SuperCircle(10);
        // // System.out.println(circle==parrot1); // (X)
        // System.out.println(circle.equals(parrot1)); // (O)

        System.out.println("========================");
        // clone() 深拷貝
        // 等於 new 一個跟 parrot1 一模一樣的物件，但記憶體位置不同
        parrot1.setName("笨阿偉");
        Parrot parrot4 = null;
        try {
            parrot4 = (Parrot) parrot1.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(parrot1 == parrot4);
        System.out.println(parrot1.equals(parrot4));
        System.out.println(parrot4.getName());

    }
}
