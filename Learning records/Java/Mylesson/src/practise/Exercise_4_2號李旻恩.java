package practise;

/*
* ◆ 請寫出一個程式,可以依序輸入三個整數,之後會找出最大值和最小值。
*/

import java.util.Arrays;
import java.util.Scanner;

public class Exercise_4_2號李旻恩 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = 3;
        int[] nuumbers = new int[length];
        int[] check = new int[length];

        // 輸入
        System.out.println("請輸入依序整數，進行最大值最小值的查找");
        for (int i = 0; i < length; i++) {
            System.out.printf("第 %d 個整數：", i + 1);
            nuumbers[i] = getNextInt(scanner);
        }
        // 排序
        check = copy(nuumbers); // 不改變原來陣列，但若純比較，後續不在用到陣列，沒意義
        Arrays.sort(check);
        // 輸出 (方法一)
        System.out.printf("最大值：%d ， 最小值：%d\n",
                check[length - 1], check[0]);
        // 輸出 (方法二)
        System.out.printf("最大值：%d ， 最小值：%d\n",
                findMax(nuumbers), findMin(nuumbers));

        // 測試用 ========================================================
        // nuumbers=null;
        // nuumbers[0] = 10;
        // nuumbers[1] = 5;
        // nuumbers[2] = 200;
        // Arrays.sort(nuumbers);
        // System.out.println(Arrays.toString(nuumbers));
        // 測試用 ========================================================
        scanner.close();
    }

    // 檢查輸入型態函式
    public static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("請輸入正確型態的數字(Int)：");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * 最大值的查找
     * (可加上輸出最大/小值索引位置 & 多最大/小值數處理)
     * 
     * @param array
     * @return maximum number
     */
    public static int findMax(int... array) {
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * 最小值的查找
     * (可加上輸出最大/小值索引位置 & 多最大/小值數處理)
     * 
     * @param array
     * @return minimum number
     */
    public static int findMin(int... array) {
        int minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    /**
     * 完整複製陣列 (物件、陣列) (int)。
     * 兩陣列並非於同一記憶體位置下，
     * 更改其一另一者數值不會連動更改。
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
}
