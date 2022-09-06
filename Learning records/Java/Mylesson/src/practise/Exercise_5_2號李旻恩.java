package practise;

/**
 * ◆ 請使用迴圈敘述撰寫一程式,讓使用者輸入一個正整數 a,
 * 利用迴圈計算從 1 到 a 之間(包含a),所有 7 之倍數數字總和。
 */

import java.util.Scanner;

public class Exercise_5_2號李旻恩 {
    public static void main(String[] args) {
        // 宣告
        Scanner scanner = new Scanner(System.in);
        int a;
        int maxCount, count;
        int multiple = 7;
        int total;

        // 輸入
        System.out.println("計算從 1 到 a 之間(包含a),所有 7 之倍數數字總和");
        System.out.print("請輸入一個正整數 a ：");
        a = getNextInt(scanner);
        while (a <= 0) {
            System.out.println("請輸入 >0 的整數：");
            a = getNextInt(scanner);
        }
        System.out.println("------------------------------------------------");

        // 迴圈累加計算：
        System.out.println("方法一："); // 較耗資源
        total = 0;
        count = 0; // 測試用
        for (int i = 1; i < a + 1; i++) {
            if (i % multiple == 0) {
                total += i;
                count++; // 測試用
            }
        }
        // 方法一輸出
        System.out.printf("從 1 ~ %d 的 %d 之倍數總和： %d\n",
                a, multiple, total);

        // 測試用
        System.out.println("------------------------------------------------");
        System.out.printf("確定 %d 倍數最大出現次數：%d == %d is %b\n",
                multiple, count, (a / multiple), count == (a / multiple));
        // 除法檢查：
        // System.out.println("整數除法：" + (a / 7));
        // System.out.println("小數除法：" + (a / 7.0));
        System.out.println("------------------------------------------------");

        // 迴圈累加計算：
        System.out.println("方法二：");
        maxCount = a / multiple;
        total = 0;
        for (int i = 1; i < maxCount + 1; i++) {
            if (i * multiple <= a) {
                total += i * multiple;
            }
        }
        // 方法二輸出
        System.out.printf("從 1 ~ %d 的 %d 之倍數總和： %d\n",
                a, multiple, total);

        // 迴圈累加計算：
        System.out.println("方法三："); // 最快
        total = 0;
        for (int i = 0; i < a + 1; i += multiple) {
            total += i;
        }
        // 方法三輸出
        System.out.printf("從 1 ~ %d 的 %d 之倍數總和： %d\n",
                a, multiple, total);

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

}
