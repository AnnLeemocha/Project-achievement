package lesson9.animal;

/**
 * 繼承一定要呼叫父類的建構式
 * super取用父類別
 * 繼承之後可以
 * [1]覆寫方法(同名稱/參數)將隱藏父類別同名方法
 * [2]使用super.方法(可以取用父類別的方法)
 */

public class Wolf extends Animal {
    // 若在宣告一次屬性會覆蓋，有問題

    // 多載 (Overload) --- 同名不同參數
    // 若Animal有空建構式，可通過，自動呼叫空建構式，多載時注意覆蓋問題
    public Wolf() { // <--- 自動產生，多載時注意覆蓋問題
        // 自動呼叫父類空建構式
        // super(); // <--- 自動產生，自動搜尋父類空建構式，父類多載時同樣注意覆蓋問題
        System.out.println("我是兔子！");
    }

    // 建構式，滿足基本條件，繼承一定要呼叫父類的建構式
    public Wolf(String name, double weight) {
        // 父類別建構式呼叫(取用父類別)，達成最基礎使時體產生之條件
        super(name, weight);
    }
    // 由子類輸入參數至父類

    public Wolf(String name, double weight, double height) {
        // 【若不呼叫，會一律自動呼叫父類空建構式，父類須有空建構式】
        // super(); // <--- 自動產生，自動搜尋父類空建構式，父類多載時同樣注意覆蓋問題
    }
    // 以上兩建構式同"覆載"的概念，子類名稱在此等同於父類，名稱相同參數相同

    // 覆載 (Override) --- 同父類方法，同名同參數
    // 隱藏父類別的該方法
    @Override // 強調為 覆載 (override)，但只能覆載，不能改成多載，不能改回傳型態，只可改內部邏輯
    public void eat() {
        // 使用super.關鍵字呼叫出父類別的該方法
        super.eat();
        System.out.println("喜歡吃肉");
    }

    // 多載
    public void eat(String food) {
        // 使用super.關鍵字呼叫出父類別的該方法
        super.eat();
        System.out.println("喜歡吃肉");
        System.out.println("更喜歡吃" + food);
    }

    @Override
    public void sleep() {
        // 使用super.關鍵字呼叫出父類別的屬性
        System.out.println(super.name2);
        super.name2 = "灰太郎";
        System.out.println(super.name2);
        System.out.println("夜行性動物，喜歡白天睡覺");
    }

    @Override
    // public void run(double weight) {
    public void run() {
        System.out.println("跑超級快");
    }

}
