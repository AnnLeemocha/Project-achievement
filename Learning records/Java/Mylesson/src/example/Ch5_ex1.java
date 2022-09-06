package example;

/**
 * 【2022/06/22：版本1】--> 尚可改進(1***，二維矩陣)
 * 
 * ■ 眾數的查找
 * ■ 撰寫一個可以輸入10個整數的一維陣列
 * ■ 查找出最常出現的數字跟次數
 */

import java.util.Scanner;

public class Ch5_ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 宣告 ( 計數器 & 陣列 )
        int nNumber = 10;
        // int nLocation = 0;
        int nRepeat = 1;
        int maxNum = 0, maxCount = 0;
        float errorNum = -999.9f;
        int[] number = new int[nNumber];
        int[] count = new int[nNumber];

        // 使用者輸入 (+輸入資料型態除錯)
        System.out.println("請輸入10個數字");
        System.out.println("-----------------------------------");
        for (int i = 0; i < number.length; i++) {
            System.out.printf("請輸入第 %d 整數數字：", i + 1);
            while (!input.hasNextInt()) {
                System.out.println("輸入錯誤！！");
                System.out.printf("請重新輸入第 %d 整數數字：", i + 1);
                input.next();
            }
            number[i] = input.nextInt();
        }

        // 重複數字計數器
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (number[i] == number[j]) {
                    count[i]++;
                }
            }
        }

        // 眾數(數量出現最多次之數字)位置 (例外狀況：maxCount=1)
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= maxCount) {
                maxNum = number[i];
                maxCount = count[i];
                // nLocation = i;
            }
        }

        // 雙重確認 (例外狀況：眾數不只一個)
        for (int i = 0; i < count.length; i++) {
            if (maxCount == count[i] && maxNum != number[i] && errorNum != number[i]) {
                nRepeat++; // 重複次數
                errorNum = number[i];
                // Check Anser：maxNum & errorNum
                System.out.println(maxNum + " , " + (int) errorNum);
            }
            // Check Anser：count[i]
            // System.out.println(count[i]);
        }

        // 輸出結果
        System.out.println("===================================");
        if (maxCount == 1) {
            System.out.println("10個數字都只出現過一次~");
        } else if (nRepeat > 1) {
            System.out.println("多個數字出現次數相同~"); // 可嘗試輸出多個眾數 ***
        } else {
            System.out.printf("眾數為： %d (出現次數為 %d)",
                    maxNum, maxCount);
            // System.out.printf("眾數為： %d (出現次數為 %d)",
            // number[nLocation], count[nLocation]);
        }

        input.close();
    }
}
