package practise;

/**
 * ◆請使用選擇敘述撰寫程式,讓使用者輸入一個整數,判斷是否為 2 或 7 的倍數。
 *      ➢ 24 是 2 的倍數
 *      ➢ -21 是 7 的倍數
 *      ➢ 28 是 2 及 7 的倍數
 *      ➢ -13 不是 2 也不是 7 的倍數
 */

import java.util.Scanner;

public class Exercise_3_2號李旻恩 {
    public static void main(String[] args) {
        // 使用者輸入
        Scanner input = new Scanner(System.in);
        System.out.println("判斷是否為 2 或 7 的倍數");
        System.out.print("請輸入一個整數：");
        int num = input.nextInt();

        // 判斷倍數
        boolean multiple2 = false;
        boolean multiple7 = false;
        multiple2 = num % 2 == 0 ? true : false;
        multiple7 = num % 7 == 0 ? true : false;

        // 判斷輸出
        if (multiple2 && multiple7) { // 皆 true
            System.out.printf("%d --> 是 2 及 7 的倍數", num);
        } else if (multiple2) { // 2 true , 7 false
            // } else if (multiple2 && !multiple7) { // 2 true , 7 false
            System.out.printf("%d --> 僅是 2 的倍數", num);
        } else if (multiple7) { // 2 false , 7 true
            // } else if (!multiple2 && multiple7) { // 2 false , 7 true
            System.out.printf("%d --> 僅是 7 的倍數", num);
        } else { // 皆 false
            System.out.printf("%d --> 不是 2 也不是 7 的倍數", num);
        }

        // // 另一種方法
        // if (num % 2 == 0 && num % 7 == 0) {
        // System.out.printf("%d --> 是2及7的倍數%n", num);
        // } else if (num % 2 == 0) {
        // System.out.printf("%d --> 是2的倍數%n", num);
        // } else if (num % 7 == 0) {
        // System.out.printf("%d --> 是7的倍數%n", num);
        // } else {
        // System.out.printf("%d --> 不是2也不是7的倍數%n", num);
        // }

        input.close();
    }
}
