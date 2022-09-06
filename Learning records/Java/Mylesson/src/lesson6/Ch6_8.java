package lesson6;

import java.util.Arrays;

public class Ch6_8 {
    public static void main(String[] args) {
        // 函式中，可變長度的參數 (以 sum 為範例)
        // 若要輸入兩個不知長度的陣列，該方法不適用，因不知結束點在哪
        sum(1);
        double x = sum(1, 2);
        double y = sum(1, 2, 3);
        double z = sum(1, 2, 3, 4);
        System.out.println("------------------");
        System.out.println(x + " , " + y + " , " + z);
        System.out.println("------------------");
        // 比大小的函式
        System.out.println(max(10, 20));
        System.out.println(max(0, 11, -1000, -100, 1000));
        System.out.println("------------------");
        total(100);
        total(2, 100);
        total(2, 100, 2);
        total(2, 100, 2, 1);
        total();
        int[] value = { 2, 100, 2 };
        total(value);
        System.out.println("------------------");

    }

    // 函式中，可變長度的參數
    public static double sum(double... nums) {
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));
        double total = 0;
        for (double d : nums) {
            total += d;
        }
        return total;
    }

    // 比大小的函式 (兩值)
    // 兩值
    public static int max(int a, int b) {
        int bigger;
        if (a > b) {
            bigger = a;
        } else {
            bigger = b;
        }
        return bigger;
    }

    // 起始值，比較陣列
    public static int max(int a, int... b) {
        int bigger = a; // 預設最大值
        for (int i = 0; i < b.length; i++) {
            if (b[i] > bigger) {
                bigger = b[i];
            }
        }
        return bigger;
    }

    // total，可變長度的參數
    public static double total(int... args) {
        // System.out.println(Arrays.toString(args));
        int start = 0, end = 0, step = 1;
        int size = args.length;
        if (size == 1) {
            end = args[0];
        } else if (size == 2) {
            start = args[0];
            end = args[1];
        } else if (size == 3) {
            start = args[0];
            end = args[1];
            step = args[2];
        } else {
            System.out.println("引數個數有誤");
            return -3;
        }

        if (start > end) {
            System.out.println("起始與終止值有誤！ (start > end)");
            return -1;
        }
        if (step > end) {
            System.out.println("步階錯誤！ (step > end)");
            return -2;
        }
        double total = 0;
        for (int i = start; i < end + 1; i += step) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %.0f\n",
                start, end, step, total);
        return total;
    }

}
