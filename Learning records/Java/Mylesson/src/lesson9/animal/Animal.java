package lesson9.animal;

/**
 * 動物類別
 */

// public class Animal extends Object{ // Object 所有類別之父類別
// final public class Animal { // 最後一個類別不得繼承
public class Animal {
    public static final int MALE = 0;
    final public static int FEMALE = 1;

    public String name2;
    private String name;
    private double weight;
    private static int count;
    protected int sex; // 子類可使用
    int sex2;

    public Animal() {
        System.out.println("我是動物！");
        name = "無名氏";
        name2 = "無名氏";
        weight = 0.1;
        count++;
        sex = MALE;
    }

    public Animal(String name, double weight) {
        this();
        this.name = name;
        this.weight = weight;
    }

    // 行為特徵
    // final public void eat() { // 最終方法(不得覆載)
    public void eat() {
        System.out.println("I like eating!");
    }

    public void sleep() {
        System.out.println("I like sleeping!");
    }

    public void run() {
        System.out.println("I like running!");
    }

    public void info() {
        System.out.printf("姓名：%s \t 體重：%.2f\n", name, weight);
    }

    public static int getCounter() {
        return count;
    }

    // 獲取參數
    public String getName() {
        return name;
    }

    // 設定參數
    public void setName(String name) {
        if (this.name != "") {
            this.name = name;
        }
    }

    // 覆寫 (用覆載修改輸出結果)
    @Override
    public String toString() {
        return String.format("姓名：%s \t 體重：%.2f", name, weight);
        // // TODO Auto-generated method stub
        // return super.toString();
    }
}
