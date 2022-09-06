package lesson3;

public class Ch3_6 {
    public static void main(String[] args) {
        int a = 10;

        System.out.println(a);
        // 移位運算子 (二進制數值進行向左 << 或向右 >> 移位)
        // 位元移動運算，速度較快

        // 向右移動1位等同於將數值/2
        System.out.println(a / 2);
        System.out.println(a >> 1);
        // 向右移動2位等同於將數值/4
        System.out.println(a / 4);
        System.out.println(a >> 2);

        // 向左移動1位等同於將數值*2
        System.out.println(a * 2);
        System.out.println(a << 1);
        // 向左移動2位等同於將數值*4
        System.out.println(a * 4);
        System.out.println(a << 2);

    }
}
