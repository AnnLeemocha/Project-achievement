package lesson6;

import java.util.Arrays;

public class Ch6_7 {
    public static void main(String[] args) {

        // 傳值 & 傳址 呼叫 ===============================================

        // 傳值呼叫 (函式內 數值 x <--- 一般型態)
        int x = 10, y = 20, z = 30;
        System.out.println(x + " " + y + " " + z);
        sum(x, y, z);
        System.out.println(x + " " + y + " " + z);
        System.out.println("---------------");

        // 傳址呼叫 (函式內 矩陣 x[i] = 66 <--- 陣列跟物件)
        int[] zz = { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(zz));
        sum2(zz);
        System.out.println(Arrays.toString(zz));
        System.out.println("---------------");

        // 完全複製： 把矩陣傳入函式不改變原有矩陣 ==========================

        // 完全複製 方法一
        int[] xx = { 1, 88, 3, 4, 5, 6, 8, 10 };
        int[] copy_xx = new int[xx.length];
        for (int i = 0; i < copy_xx.length; i++) {
            copy_xx[i] = xx[i];
        }
        System.out.println(Arrays.toString(xx));
        sum2(copy_xx);
        System.out.println(Arrays.toString(xx));
        System.out.println(Arrays.toString(copy_xx));
        System.out.println("---------------");

        // 完全複製 方法二 ()
        // (System.arraycopy(來源, 起始索引, 目的, 起始索引,複製長度))
        System.arraycopy(xx, 0, copy_xx, 0, xx.length);
        System.out.println(xx == copy_xx);
        System.out.println(Arrays.toString(xx));
        System.out.println(Arrays.toString(copy_xx));
        System.out.println("---------------");

        // 完全複製 方法三 (自訂函式)
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] b = copy(a);
        System.out.println(a == b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println("---------------");

        // 反轉陣列 ----------------------------------------

        int[] c = reverse(a);
        System.out.println(Arrays.toString(c));

    }

    // 函式 =================================================
    // sum --------------------------------------------------
    public static int sum(int x, int y, int z) {
        int total = x + y + z;
        x++;
        y++;
        z = 66;
        System.out.println(x + " " + y + " " + z);
        return total;
    }

    public static void sum2(int[] x) {
        x[1]++;
        x[0] = 10;
        System.out.println(Arrays.toString(x));
    }

    // 複製陣列 --------------------------------------------------

    // 複製陣列
    /**
     * 
     * @param source
     * @return
     */
    public static int[] copy(int[] source) {
        int[] copy = new int[source.length];
        // for (int i = 0; i < source.length; i++) {
        // copy[i] = source[i];
        // }
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    // 複製反轉陣列
    /**
     * 
     * @param source
     * @return
     */
    public static int[] reverse(int[] source) {
        int[] copy = new int[source.length];
        // int count = copy.length - 1;
        // for (int i = 0; i < copy.length; i++) {
        // // copy[i] = source[source.length - 1 - i]; // -1-i
        // copy[i] = source[count--];
        // }
        int count = 0;
        for (int i = copy.length - 1; i >= 0; i--) {
            // copy[i - source.length + 1] = source[i];
            copy[count++] = source[i];
        }
        return copy;
    }

}
