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

public class Ch4_ex3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name = "";
        int count = 0;
        float score = 0.0f, total = 0.0f;

        while (true) {
            // System.out.println("請輸入第 " + (++count) + " 位學生姓名：");
            System.out.printf("請輸入第 %d 位學生姓名:\n", count + 1);
            name = input.nextLine();

            System.out.printf("請輸入 %s 成績 (0~100)： ", name);
            score = input.nextFloat();
            if (score > 100 || score < 0) {
                System.out.println("輸入錯誤請重新輸入正確分數...");
                input.nextLine();
                continue;
            }
            // } else {
            // break;
            // }

            total += score;
            count++;
            input.nextLine();

            System.out.printf("是否離開？(y/n) ");
            if (input.next().toLowerCase().equals("y")) {
                break;
            }
        }
        System.out.println("-----------------------------------------");
        if (count > 0) {
            System.out.printf("共輸入 %d 位同學 \n總分為：%.2f \n平均分為：%.2f\n",
                    count, total, total / count);
        } else { // 除以 0 error
            System.out.println("共輸入 " + count + " 位同學 ");
        }
        // System.out.printf("共輸入 %d 位同學 \t 總分為：%.2f \t 平均分為：%.2f\n",
        // count, total, total / count);
        // System.out.printf("共輸入%d位學生\n", count);
        // System.out.printf("總分為%d\n", total);
        // System.out.printf("平均分為%.1f\n", (float) total / count);

        input.close();
    }
}
