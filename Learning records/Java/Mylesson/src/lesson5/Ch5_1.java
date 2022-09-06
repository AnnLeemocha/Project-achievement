package lesson5;

/**
 * 陣列
 */

import java.util.Arrays;

public class Ch5_1 {
    public static void main(String[] args) {
        int x = 10;
        float y = 10;
        System.out.println(x == y);

        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        int[] c = a;
        int[] e = { 3, 2, 1 };
        System.out.println(a + " , " + b); // [I@5ca881b5 , [I@24d46ca6 (記憶體位置)
        System.out.println(a == b); // 記憶體位置不同
        System.out.println(a == c); // 同一個記憶體位置
        System.out.println(Arrays.equals(a, b)); // 矩陣的值相等比較
        System.out.println(Arrays.equals(a, e)); // 比較實位置對位置 (依序)
    }
}
