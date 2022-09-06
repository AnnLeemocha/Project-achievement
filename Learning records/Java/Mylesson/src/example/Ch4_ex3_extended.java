package example;

/**
 * ■ 改寫Ch4_14.java程式
 *     ■ 檢查輸入的分數正確性(<0 | >100)
 *     ■ 輸入錯誤時要該名學生要重新輸入
 */

/**
 * ■ 延伸練習
 *      ■ 改成輸入姓名(-1)離開
 *      ■ 可以不重複輸入該學生姓名(如果分數區 間錯誤)
 *      ■ 直到輸入正確為止
 */

import java.util.Scanner;

public class Ch4_ex3_extended {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name = "";
        int count = 0;
        float total = 0;

        while (true) {
            String nameError = "";
            System.out.printf("請輸入第 %d 位學生姓名(-1:EXIT)：\n", count + 1);
            name = input.nextLine();
            nameError = name.toLowerCase();
            if (nameError.equals("-1") || nameError.equals("exit")) {
                // count--;
                break;
            }

            // // 方法一
            // float score = 0;
            // while (true) {
            // System.out.printf("請輸入 %s 成績: ", name);
            // score = input.nextFloat();
            // if (score > 100 || score < 0) {
            // System.out.println("輸入錯誤請重新輸入...");
            // input.nextLine();
            // continue;
            // }
            // // total += score;
            // // count++;
            // // input.nextLine();
            // break;
            // }

            // 方法二 (較容易精簡，盡量不需要無作用之程式...)
            float score = 0;
            while (true) {
                System.out.printf("請輸入 %s 成績: ", name);
                score = input.nextFloat();
                if (score >= 0 && score <= 100) {
                    // total += score;
                    // count++;
                    // input.nextLine();
                    break;
                }
                System.out.println("輸入錯誤請重新輸入...");
                input.nextLine();
            }

            total += score;
            count++;
            input.nextLine();
        }
        System.out.println("-----------------------------------------");
        System.out.printf("共輸入 %d 位同學 \n總分為：%.2f \n平均分為：%.2f\n",
                count, total, total / count);
        // System.out.printf("共輸入 %d 位同學 \t 總分為：%.2f \t 平均分為：%.2f\n",
        // count, total, total / count);

        input.close();
    }
}
