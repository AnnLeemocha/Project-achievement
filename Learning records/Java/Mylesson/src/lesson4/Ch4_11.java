package lesson4;

import java.util.Scanner;

public class Ch4_11 {
    public static void main(String[] args) {

        boolean first = false;

        // while
        while (first) {
            System.out.println("while：被執行了一次");
        }

        // do while
        do {
            System.out.println("do while：被執行了一次");
        } while (first);
        System.out.println("===================================================");

        // ch4_10.java [do while]
        Scanner input = new Scanner(System.in);
        int count = 0;
        float score = 0.0f, total = 0.0f;
        do {
            System.out.printf("請輸入第%d位分數:", ++count);
            score = input.nextFloat();
            total += score;
            System.out.printf("是否繼續?(y/n)");
        } while (input.next().equals("y"));
        System.out.println("-----------------------------------------");
        System.out.printf("總和為:%.2f 平均分為:%.2f\n", total, total /
                count);
        // input.close();
        System.out.println("===================================================");

        // break (只能用在迴圈)
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("===================================================");

        // ch4_10.java 優化版本 [while (true)]
        // Scanner input = new Scanner(System.in);
        // int count = 0;
        // float score = 0.0f, total = 0.0f;
        // input = new Scanner(System.in);
        count = 0;
        score = 0.0f;
        total = 0.0f;
        while (true) {
            System.out.printf("請輸入第%d位分數:", ++count);
            score = input.nextFloat();
            total += score;
            System.out.printf("是否離開?(y/n)");
            if (input.next().toLowerCase().equals("y")) {
                break;
            }
        }
        System.out.println("-----------------------------------------");
        System.out.printf("總和為:%.2f 平均分為:%.2f\n", total, total / count);
        // input.close();
        System.out.println("===================================================");

        // ch4_10.java 更優化版本(連續輸入)
        // Scanner input = new Scanner(System.in);
        // int count = 0;
        // float score = 0.0f, total = 0.0f;
        // input = new Scanner(System.in);
        count = 0;
        score = 0.0f;
        total = 0.0f;
        while (true) {
            System.out.printf("請輸入第%d位分數(-1:exit/離開):", count + 1);
            score = input.nextFloat();
            if (score == -1) {
                break;
            }
            total += score;
            count++;
        }
        System.out.println("-----------------------------------------");
        System.out.printf("共輸入%d位同學 總和為:%.2f 平均分為:%.2f\n",
                count, total, total / count);
        input.close();

    }
}
