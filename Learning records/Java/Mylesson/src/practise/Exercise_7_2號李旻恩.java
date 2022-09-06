package practise;

/**
 * ◆ 請使用亂數產生介於 -15~130 的答案,然後進行猜數字的程式,
 * _ 並加入太大、太小、請重新輸入的判斷與輸入。
 * _ 並請在最後猜對時,輸出其總猜測次數。
 */

import java.util.Scanner;
import java.util.Random;

public class Exercise_7_2號李旻恩 {
    public static void main(String[] args) {
        // 宣告
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // java.util.Random random = new java.util.Random();
        int input = -100;
        int max = 130, min = -15;
        int range = Math.abs(max) + Math.abs(min) + 1;
        System.out.println(range);
        int count = 0;
        // 亂數 (0=<random<1)*range-|min| ==> -15 ~ 130 (頭尾包含)
        // 亂數產生方法一：
        int answer = random.nextInt(range) + min;
        // 亂數產生方法二：
        // int answer = (int) (Math.random() * (range) + min);
        // 輸入
        System.out.println("猜數字遊戲 ---> -15 ~ 130 請猜一整數");
        do {
            System.out.print("請輸入數字(int)：");
            input = getNextInt(scanner);
            while (input > 130 || input < -15) {
                System.out.println("超出範圍！");
                System.out.print("請重新輸入數字(int)：");
                input = getNextInt(scanner);
            }
            // 判斷大小
            if (input > answer) {
                max = input;
                System.out.printf(" %d 太大，請猜小一點 (介於 %d ~ %d 之間)\n", input, min, max);
            } else if (input < answer) {
                min = input;
                System.out.printf(" %d 太小，請猜大一點 (介於 %d ~ %d 之間)\n", input, min, max);
            }
            count++;
        } while (input != answer);
        // 輸出
        System.out.printf("恭喜您猜對了！ 答案為：%d\n", answer);
        System.out.println("遊戲結束！");
        System.out.printf("本次遊戲總猜測次數共 %d 次\n", count);
        scanner.close();
    }

    // 檢查輸入型態函式
    public static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("錯誤！請輸入整數！");
            System.out.print("請重新輸入數字(int)：");
            scanner.next();
        }
        return scanner.nextInt();
    }

}
