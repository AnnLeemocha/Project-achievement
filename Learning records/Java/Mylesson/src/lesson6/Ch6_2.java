package lesson6;

// import lesson6.Ch6_1;

public class Ch6_2 {
    public static void main(String[] args) {
        // 只要是全公開(public)都可以呼叫到，同[package]下不用 import lesson6.Ch6_1
        Ch6_1.sum(10, 20);

        // 不公開 (只在[package]lesson6可以使用)
        Ch6_1.sum2(10, 20);

        // 全私有 (只在Ch6_1可以使用)
        // Ch6_1.sum3(10, 20);

    }
}
