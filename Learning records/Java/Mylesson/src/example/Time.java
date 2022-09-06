package example;

public class Time {
    public static void main(String[] args) {

        // 程式執行時間計數
        long start = System.currentTimeMillis();

        // 測試
        double x1 = 10;
        for (long i = 0; i < 10000000; i++) {
            x1 *= 2;
        }

        System.out.println((System.currentTimeMillis() - start) / 1000.0 + "秒");
        System.out.println(x1);

    }
}
