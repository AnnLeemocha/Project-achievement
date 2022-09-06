package lesson4;

import java.util.Scanner;

public class Ch4_2 { // 錯誤命名方式：Ch4_2-1 | 正確命名方式：Ch4_2_1
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入消費金額：");
        int cost = input.nextInt();

        // 方法一：
        if (cost >= 10000) {
            if (cost >= 100000) {
                System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%d\n",
                        cost, 75, (int) (cost * .75));
            } else if (cost >= 50000) {
                System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%d\n",
                        cost, 85, (int) (cost * .85));
            } else if (cost >= 30000) {
                System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%d\n",
                        cost, 9, (int) (cost * .9));
            } else {
                System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%d\n",
                        cost, 95, (int) (cost * .95));
            }
        } else {
            System.out.printf("消費金額:%d (無折扣)\n", cost);
        }

        // 方法二：
        float discount = 1.0f;

        if (cost >= 10000) {
            if (cost >= 100000) {
                discount = .75f; // 記得 float 要加上 f
            } else if (cost >= 50000) {
                discount = .85f;
            } else if (cost >= 30000) {
                discount = .9f;
            } else {
                discount = .95f;
            }
            if (discount % 10 == 0) {
                discount = discount / 10;
            }
            System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%.0f\n",
                    cost, (int) (discount * 100), cost * discount);
            // System.out.printf("消費金額:%d\t折扣:%.0f折\t金額為:%.0f\n",
            // cost, (discount * 100), cost * discount);
            // System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%f\n",
            // cost, (int) (discount * 100), cost * discount);
        } else {
            System.out.printf("消費金額:%d(無折扣)\n", cost);
        }

        // 使用 int 會無條件捨去
        // 使用 .0f 會四捨五入

        // 基本上就是越簡潔 變因越少越好

        input.close();
    }
}
