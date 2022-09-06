package lesson5;

/**
 * 記憶體位置
 */

import java.util.Arrays;

public class Ch5_13 {
    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4, 5 };
        System.out.println(x);
        System.out.println(Arrays.toString(x));

        int[] y = x;
        System.out.println(y);
        System.out.println(x == y);
        System.out.println(x == y ? "x & y 兩個相等" : "x & y 不相等");
        System.out.println(Arrays.equals(x, y));
        System.out.println(Arrays.equals(x, y) ? "兩個相等" : "不相等");

        // 記憶體位置相同，連動更改
        y[0] = 11;
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        // 完整複製 (釋放-->實體)
        y = null;
        System.out.println(y);
        y = new int[x.length];
        System.out.println(y);

        for (int i = 0; i < y.length; i++) {
            y[i] = x[i];
        }

        // 記憶體位置不同
        System.out.println(x == y);
        System.out.println(x == y ? "兩個相等" : "不相等");
        // 陣列值一樣
        System.out.println(Arrays.equals(x, y));
        System.out.println(Arrays.equals(x, y) ? "兩個相等" : "不相等");

        // 記憶體位置不相同，x,y獨立，更改不連動
        y[0] = 21;
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

    }
}
