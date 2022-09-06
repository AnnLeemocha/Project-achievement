package lesson5;

import java.util.Scanner;

public class Ch5_5 {
    public static void main(String[] args) {
        // 輸入班級人數
        Scanner input = new Scanner(System.in);
        System.out.println("請問班級有幾位同學?");
        while (!input.hasNextInt()) {
            System.out.println("請輸入正確人數");
            input.next();
        }
        int num = input.nextInt();

        // 輸入所有人成績
        float[] scores = new float[num];
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("請輸入第%d位分數:%n", i + 1);
            while (!input.hasNextFloat()) {
                System.out.println("請輸入正確分數(0~100)");
                input.next();
                // scores[i] = input.nextFloat();
                // if (scores[i] >= 0 && scores[i] <= 100) {
                // input.next();
                // }
            }
            scores[i] = input.nextFloat();
        }
        // 計算全班成績
        double total = 0;
        for (float s : scores) {
            total += s;
        }
        // 輸出
        System.out.printf("共%d位同學 總合為:%.2f 平均分為:%.2f",
                num, total, total / scores.length);
        input.close();
    }

}
