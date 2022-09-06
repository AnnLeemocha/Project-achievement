package lesson4;

/**
 * 猜數字遊戲：
 * 1.亂數(random)
 * 2.重複次數
 * 3.給予範圍
 */

import java.util.Random;
import java.util.Scanner;

//// 物件導向開始，只能有一個是公開的(同檔名)，才需要進入點

//// 輔助主要類別
// class Person {
//
// }

//// 主要類別
public class GuessGame {
    public static void main(String[] args) {

        //// 亂數測試
        // 產生亂數
        Random rand = new Random();
        // System.out.println(rand); // java.util.Random@24d46ca6
        // 【0~9 隨機產出一數字】
        int number = rand.nextInt(10);
        System.out.println(number);
        System.out.println("------------------------------------");
        for (int i = 0; i < 10; i++) {
            number = rand.nextInt(10);
            System.out.println(number);
        }
        System.out.println("------------------------------------");

        while (true) {
            number = rand.nextInt(10);
            System.out.println(number);
            if (number == 9) {
                break;
            }
        }
        System.out.println("------------------------------------");

        // 【1~10 隨機產出一數字】
        number = rand.nextInt(10) + 1;
        System.out.println(number);
        while (true) {
            number = rand.nextInt(10) + 1;
            System.out.println(number);
            if (number == 10) {
                break;
            }
        }
        System.out.println("------------------------------------");

        //// 猜數字遊戲
        int maxNum = 50, minNum = 0;
        number = rand.nextInt(maxNum) + 1;
        boolean bingo = false;
        Scanner input = new Scanner(System.in);
        System.out.println("猜數字遊戲：(僅有？次機會)");
        while (true) {
            // 輸入數字
            System.out.println("請猜一數字(" + minNum + "~" + maxNum + ", -1:結束)：");
            // System.out.println("請猜一數字(1~50, -1:結束)：");
            while (!input.hasNextInt()) {
                System.out.println("請猜一數字(" + minNum + "~" + maxNum + ", -1:結束)：");
                input.next();
            }

            // 開始猜數字 & 輸出
            int guess = input.nextInt();
            //// 方法一：
            // // 遊戲結束
            // if (guess == -1) {
            // System.out.println("正確數字為 " + number);
            // bingo = false;
            // break;
            // }
            // // 猜測結果
            // if (guess == number) {
            // System.out.println("你猜對了！");
            // System.out.println("恭喜中獎！！");
            // bingo = true;
            // break;
            // } else {
            // if (guess > number) {
            // maxNum = guess;
            // System.out.println("請猜小一點~");
            // } else {
            // minNum = guess;
            // System.out.println("請猜大一點~");
            // }
            // System.out.println("( " + minNum + " ~ " + maxNum + " )");
            // }

            //// 方法二：
            // 遊戲結束 Game Over
            if (guess == -1) {
                bingo = false;
                break;
            }
            // 猜測結果 Win
            if (guess == number) {
                System.out.println("你猜對了！");
                bingo = true;
                break;
            }
            // 猜測結果 Again (Range)
            if (guess > number) {
                maxNum = guess;
                System.out.println("請猜小一點~");
            } else {
                minNum = guess;
                System.out.println("請猜大一點~");
            }
            // System.out.println("( " + minNum + " ~ " + maxNum + " )");

        }

        if (bingo) {
            System.out.println("恭喜中獎！！");
        } else {
            System.out.println("遊戲失敗，正確答案為：" + number);
        }

        input.close();
    }
}
