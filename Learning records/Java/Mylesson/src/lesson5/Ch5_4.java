package lesson5;

import java.util.Scanner;

public class Ch5_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        // double[] scores = new double[] { 100, 92, 83, 74, 65 };
        double[] scores = new double[5]; // 成績共幾科
        double total = 0;
        // 使用者輸入分數
        for (int i = 0; i < scores.length; i++) {
            System.out.println("請輸入第" + (i + 1) + "個分數");
            while (!input.hasNextDouble()) {
                System.out.println("請輸入正確分數");
                input.next();

            }
            scores[i] = input.nextDouble();
        }
        System.out.println("---------------------------------------");
        // 全部科目成績計算
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 0 && scores[i] <= 100) {
                total += scores[i];
                System.out.println(scores[i]);
                count++;
            } else {
                System.out.println("成績錯誤！");
            }
        }
        System.out.printf("有效成績：%d 科 \t 總分為:%.2f \t 平均分為:%.2f",
                count, total, total / count);

        // 正向輸出
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
        System.out.println("---------------------------------------");

        // 反向輸出
        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.println(scores[i]);
        }
        System.out.println("---------------------------------------");

        // for each 取第0~end (無法反向獲選取區段)
        for (double x : scores) {
            System.out.println(x);
        }

        input.close();
    }

}
