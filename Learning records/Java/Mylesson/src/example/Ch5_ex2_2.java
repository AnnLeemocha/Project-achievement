package example;

/**
 * 【2022/06/22：版本2】--> 尚可改進(精簡省資源，可輸入，隨機抽取期數)
 * 
 * 產生樂透號碼：
 * ■ 每天的號碼不能重複
 * ■ 可在內迴圈使用do while進行陣列檢查是否重複
 * (範例顯示每期5碼)
 */

import java.util.Scanner;
import java.util.Random;
// import java.util.Arrays;

public class Ch5_ex2_2 {
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
        int rangeNum = 50;
        int[][] lotto = new int[countDay][countNum];
        Random random = new Random();
        int nSame = 0;

        //// countDay 期數迴圈 ---------------------------------------------
        for (int i = 0; i < lotto.length; i++) {
            //// 隨機生產 countNum 碼迴圈 -----------------------------------
            for (int j = 0; j < lotto[i].length; j++) {
                // 樂透號碼 (1~rangeNum)
                lotto[i][j] = (int) (random.nextInt(rangeNum) + 1);
            }

            //// 檢查該期是否重複 (方法二) ------------------------------
            // 重複 ---> 該期數字全部重新選取
            do {
                nSame = 0;
                // 隨機生產 countNum 碼迴圈
                for (int j = 0; j < lotto[i].length; j++) {
                    // 樂透號碼 (1~rangeNum)
                    lotto[i][j] = (int) (random.nextInt(rangeNum) + 1);
                }
                // 檢查該期是否重複
                for (int j = 0; j < lotto[i].length; j++) {
                    for (int k = 0; k < lotto[i].length; k++) {
                        if (lotto[i][j] == lotto[i][k] && j != k) {
                            nSame++;
                            break;
                        }
                    }
                }
                // 樂透碼重複，則該期數字全部重新選取
            } while (nSame > 0);

            // 輸出結果 -------------------------------------------------
            System.out.println("     第 " + (i + 1) + " 期");
            // System.out.println("--------------------");
            for (int is : lotto[i]) {
                System.out.printf("%2d  ", is);
            }
            System.out.println();
            System.out.println("====================");
        }

        input.close();
    }
}
