package lesson5;

import java.util.Scanner;

public class Ch5_7 {
    public static void main(String[] args) {
        // -------------------------------------------------------
        // 使用者輸入 (班級人數+型態除錯)
        Scanner input = new Scanner(System.in);
        System.out.println("請問班級有幾位同學?");
        while (!input.hasNextInt()) {
            System.out.println("請輸入正確人數");
            input.next();
        }
        // -------------------------------------------------------
        // 宣告
        // num 班級人數 | suject 科目數
        // names[] 姓名 | totals[] 總成績 | scores[][] 分數
        // 邏輯先做完，再處理輸入端 (***)
        int num = input.nextInt();
        // 方法一： ***
        // int suject = 3;
        // 方法二： ***
        String[] sujectName = { "國文", "英文", "數學" };
        String[] names = new String[num];
        float[] totals = new float[num];
        // float[][] scores = new float[num][suject];
        float[][] scores = new float[num][sujectName.length];
        // -------------------------------------------------------
        // 使用者輸入 (姓名、分數+型態除錯)
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("請輸入第 %d 位同學的姓名： ", i + 1);
            // names[i] = input.next();
            input.nextLine();
            names[i] = input.nextLine();
            // System.out.println(names[i]);
            for (int j = 0; j < scores[i].length; j++) {
                System.out.printf("請輸入 %s 分數 (0~100)： ", sujectName[j]);
                // System.out.printf("請輸入第%d科分數(0~100)： ", j + 1);
                while (!input.hasNextInt()) {
                    System.out.println("請輸入正確分數");
                    // scores[i][j]=input.nextFloat();
                    // if (scores[i][j]>=0 && scores[i][j]<=100) {
                    input.next();
                    // }
                }
                scores[i][j] = input.nextFloat();
            }
        }

        // ======================================================
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                // 每位學生成績計算 -----------------------
                totals[i] += scores[i][j];
            }
            // 輸出 --------------------------------------
            System.out.printf("輸入第%d位學生姓名：  %s \t 總成績為：%.1f \t 平均分為：%.2f\n",
                    i + 1, names[i], totals[i], totals[i] / scores[scores.length - 1].length);
        }

        input.close();

    }
}
