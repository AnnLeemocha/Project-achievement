package lesson4;

import java.util.Scanner;

public class Ch4_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("學生成績輸入系統");
        // double score = 0, total = 0;
        float score = 0, total = 0;
        int num = 0; // count
        boolean exit = false;

        // while 要給予終止條件 true --> false
        while (!exit) {
            num++;
            System.out.printf("請輸入第 %d 位分數：", num);
            // score = input.nextDouble();
            score = input.nextFloat();
            total += score;
            // total += input.nextDouble();

            System.out.println("是否結束?(y/n) --> ");
            // 直接都轉成小寫，好判斷
            // // input.next()
            // // [不吃 Enter，不拿換行資源]
            // exit = input.next().toLowerCase().equals("n") ? false : true;
            // exit = input.next().toLowerCase().equals("y") ? true : false;
            // // input.nextLine()
            // // [吃 Enter，拿換行資源
            // // (即上一筆非input.nextLine()的Enter，可用上一行輸入input.nextLine()吃掉Enter解決)]
            input.nextLine();
            exit = input.nextLine().toLowerCase().equals("y") ? true : false;
            // exit = input.nextLine().toLowerCase().equals("n") ? false : true;
            // 其他輸出寫法
            // String ans = input.next().toLowerCase();
            // if (ans.equals("y")) {
            // exit=true;
            // }
            // exit = ans.equals("n") ? true : false;
            // exit = input.next().equals("y") ? true : false;
        }

        System.out.println("總和為：" + total);
        System.out.println("輸入次數：" + num);
        System.out.println("平均：" + total / num);

        System.out.printf("共 %d 位同學 \t 總分為:%.2f \t 平均分為:%.2f",
                num, total, total / num);
        // %f 預設為小數點6位

        input.close();

    }
}
