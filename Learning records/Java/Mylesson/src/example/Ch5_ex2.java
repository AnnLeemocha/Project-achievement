package example;

/**
 * 【2022/06/22：版本3】--> 尚可改進(可輸入，隨機抽取期數)
 * 
 * 產生樂透號碼：
 * ■ 每天的號碼不能重複
 * ■ 可在內迴圈使用do while進行陣列檢查是否重複
 * (範例顯示每期5碼)
 */

import java.util.Scanner;
import java.util.Arrays;

public class Ch5_ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //// 使用者輸入 (期數、開獎號碼數) --------------------------------------
        // System.out.println("請輸入樂透產生期數：");
        // int countDay = 0, countNum = 0;
        // while (!input.hasNextInt()) {
        // System.out.println("輸入錯誤！！");
        // System.out.printf("請輸入樂透產生期數：", i + 1);
        // input.next();
        // }
        // countDay = input.nextInt();
        // System.out.println("輸入錯誤！！");
        // System.out.println("請輸入樂透開獎號碼數：");
        // while (!input.hasNextInt()) {
        // System.out.printf("請輸入第 %d 整數數字：", i + 1);
        // input.next();
        // }
        // countNum = input.nextInt();

        //// 宣告 -----------------------------------------------------------
        int countDay = 10;
        int countNum = 5;
        int maxNum = 49; // (包含)
        int minNum = 0;
        int[][] lotto = new int[countDay][countNum];

        // 樂透號碼
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < lotto[i].length; j++) {
                // minNum~maxNum (minNum,minNum+1,...,maxNum)
                boolean duplicate = false;
                int number = 0;
                // 取亂數，判定重複數字就重取該數字
                do {
                    number = (int) (Math.random() * (maxNum - minNum + 1)) + minNum;
                    duplicate = false;
                    for (int n : lotto[i]) {
                        if (n == number) {
                            duplicate = true;
                        }
                    }
                } while (duplicate);
                // 存取不重複值
                lotto[i][j] = number;
            }
            // 重新排序 (小到大)
            // Arrays.sort(lotto[i]);
            Arrays.sort(lotto[i], 0, lotto[i].length - 1);
        }
        // 輸出
        int nDay = 0;
        for (int[] i : lotto) {
            int count = 0;
            System.out.println("                    第 " + (nDay + 1) + " 期");
            nDay++;
            for (int j : i) {
                if (count++ == i.length - 1) {
                    System.out.printf(" | 特別號：%2d  |\n", j);
                    continue;
                }
                System.out.printf("|   %2d  ", j);
            }
            System.out.println("================================================");
        }
        input.close();
    }
}
