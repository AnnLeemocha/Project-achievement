package lesson5;

import java.util.Arrays;

public class Ch5_12 {
    public static void main(String[] args) {

        String[] names = { "Jerry", "Mary", "Kevin" };
        // 三個同學，四個學期，三科分數
        double[][][] scores = {
                { { 100, 88, 77 }, { 99, 88, 66 }, { 100, 88, 77 }, { 99, 88, 66 } }, // 同學 1
                                                                                      // {學期1{科目1,科目2,科目3},學期2,學期3,學期4}
                { { 100, 88, 77 }, { 99, 88, 66 }, { 100, 88, 77 }, { 99, 88, 66 } }, // 同學 2
                { { 100, 88, 77 }, { 99, 88, 66 }, { 100, 88, 77 }, { 99, 88, 66 } }, // 同學 3
        };
        // 自己寫的：
        // 一樣大小
        double[][] total = new double[scores.length][scores[0].length];
        double[] totalSum = new double[scores.length];
        // double totalSumAll;

        // 學生
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + " ---------------");
            // 學期
            for (int j = 0; j < scores[i].length; j++) {
                // 科目
                for (int k = 0; k < scores[i][j].length; k++) {
                    total[i][j] += scores[i][j][k];
                    System.out.print(scores[i][j][k] + " , ");
                }
                System.out.println();
                totalSum[i] += total[i][j];
            }
        }

        System.out.println("-----------------------");
        for (int i = 0; i < total.length; i++) {
            System.out.println("===================");
            System.out.println("學生姓名：" + names[i]);
            System.out.println("===================");
            for (int j = 0; j < total[i].length; j++) {
                System.out.println("=== 第 " + (j + 1) + " 學期 ===");
                System.out.println(Arrays.toString(scores[i][j]));
                System.out.printf("總分：%.1f 平均：%.2f\n",
                        (total[i][j]), (total[i][j] / scores[0][0].length));
                // System.out.println("總分：" + (total[i][j]) + " 平均：" + (total[i][j] /
                // scores[0][0].length));
            }
            System.out.println("===================");
            System.out.printf("總平均：%.2f",
                    (totalSum[i]) / (scores[0][0].length * scores[0].length));
            // System.out.println("總平均：" + (totalSum[i]) / (scores[0][0].length *
            // scores[0].length));
        }

        // // 講義範例：
        // double[] avgs = new double[names.length];
        // double highAvg = 0;
        // for (int i = 0; i < names.length; i++) {
        // System.out.println("====================================");
        // System.out.println(names[i]);
        // System.out.println("====================================");
        // // 學期
        // double totalAvg = 0;
        // for (int j = 0; j < scores[i].length; j++) {
        // System.out.printf("第%d個學期==>%n", j + 1);
        // double total = 0, avg = 0;
        // for (int k = 0; k < scores[i][j].length; k++) {
        // total += scores[i][j][k];
        // System.out.println(scores[i][j][k]);
        // }
        // avg += total / scores[i][j].length;
        // totalAvg += avg;
        // System.out.printf("總分%.2f 平均分:%.2f%n", total, avg);
        // }
        // System.out.println("------------------------------------");
        // System.out.printf("總平均為:%.2f%n", totalAvg / scores[i].length);
        // avgs[i] = totalAvg / scores[i].length;
        // // 紀錄目前最高平均分
        // if (avgs[i] > highAvg) {
        // highAvg = avgs[i];
        // }
        // }
        // for (int i = 0; i < avgs.length; i++) {
        // if (avgs[i] == highAvg) {
        // System.out.printf("第一名是%s 平均分為:%.2f%n", names[i], avgs[i]);
        // break;
        // }
        // }

    }
}
