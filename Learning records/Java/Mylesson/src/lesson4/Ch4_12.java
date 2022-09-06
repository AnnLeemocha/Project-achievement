package lesson4;

/**
 *  break(迴圈中斷) vs continue(迴圈回到起始)
 */

import java.util.Scanner;

public class Ch4_12 {
    public static void main(String[] args) {

        //// break & continue (後續不執行)
        // 【continue 與 if else 異曲同工，但可以讓程式使更乾淨、整齊、精簡(不錯亂，減少抓錯的時間)】
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue; // 0~4, 6~9
                // break; // 0~4
            }
            System.out.println(i);
        }

        // ====================================================================

        //// Ch4_11 修改跳離第四位學生
        // 宣告
        Scanner input = new Scanner(System.in);
        int count = 0;
        float score = 0.0f, total = 0.0f;
        boolean hasFour = false;
        // 使用者迴圈輸入
        while (true) {
            if (count + 1 == 4) {
                count++; // 3+1=4 --> 4+1=5
                hasFour = true;
                continue;
            }
            System.out.printf("請輸入第%d位分數(-1:exit):", count + 1);
            score = input.nextFloat();
            if (score == -1) {
                break;
            }
            total += score;
            count++;
        }
        // 結束會圈後，數值調整
        if (hasFour) {
            count--; // 多輸入一位，扣回
        }
        // 輸出
        System.out.printf("共輸入%d位同學 總和為:%.2f 平均分為:%.2f",
                count, total, total / count);
        input.close();
    }
}
