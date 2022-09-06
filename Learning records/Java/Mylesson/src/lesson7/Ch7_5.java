package lesson7;

import java.util.Arrays;

public class Ch7_5 {
    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = { 1, 2, 3, 4, 5 };
        int[] z = { 2, 1, 3, 4, 5 };
        System.out.println(x == y); // 記憶體是否相等
        System.out.println(x.equals(y)); // 語意不詳，記憶體是否相等
        System.out.println(Arrays.equals(x, y)); // 值是否相等 (長度、位置、值)
        System.out.println("------------------------------");

        // x vs y
        boolean same = true; // 預設相等
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) {
                same = false;
                break; // 其中一值不等就陣列不相等
            }
        }
        if (same) {
            System.out.println("陣列相等");
        } else {
            System.out.println("陣列不相等");
        }

        // x vs z
        same = true; // 預設相等
        for (int i = 0; i < x.length; i++) {
            if (x[i] != z[i]) {
                same = false;
                break; // 其中一值不等就陣列不相等
            }
        }
        if (same) {
            System.out.println("陣列相等");
        } else {
            System.out.println("陣列不相等");
        }
        System.out.println("------------------------------");

        // 搜尋傳回位置，搜尋不到則傳回負數
        // Arrays.binarySearch(int[],number)
        int[] numbers = { 41, 33, 17, 80, 61, 5, 55, 100, 200, 66, 44 };
        // Arrays.sort(numbers);
        int source = 100;

        // 方法一： 二元搜尋法，較快，可進入函式參考
        int pos = Arrays.binarySearch(numbers, source);
        if (pos < 0) {
            System.out.println("該數字 %d 不再陣列內");
        } else {
            System.out.printf("%d 查找成功，在原始陣列第 %d 位置\n",
                    numbers[pos], pos);
        }

        // 方法二：若一萬筆會跑很久，耗資源，效率差 (排序候用猜數字區間找比較快)
        boolean find = false;
        int count = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (source == numbers[i]) {
                find = true;
                pos = i;
                break;
            }
        }
        for (int n : numbers) {
            count++;
            if (n == source) {
                find = true;
                break;
            }
        }
        System.out.println(find);
        if (count < 0) {
            System.out.println("該數字 %d 不再陣列內");
        } else {
            System.out.printf("%d 查找成功，在原始陣列第 %d 位置\n",
                    numbers[count], count);
        }
        System.out.println("------------------------------");

        // 填充陣列值
        // 預設
        int[] a = new int[10];
        System.out.println(Arrays.toString(a));

        // 1
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        System.out.println(Arrays.toString(a));

        // 2
        Arrays.fill(a, 2);
        System.out.println(Arrays.toString(a));
    }
}
