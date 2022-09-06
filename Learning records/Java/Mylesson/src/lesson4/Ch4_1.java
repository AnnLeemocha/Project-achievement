package lesson4;

import java.util.Scanner;

public class Ch4_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // int score = 59;
        System.out.print("請輸入分數(整數)：");
        int score = input.nextInt();

        String level, noGood;

        // 多向if判斷式
        if (score >= 100) {
            // System.out.println("A+");
            level = "A+";
        } else if (score >= 90) {
            // System.out.println("A");
            level = "A";
        } else if (score >= 80) {
            // System.out.println("B");
            level = "B";
        } else if (score >= 70) {
            // System.out.println("C");
            level = "C";
        } else if (score >= 60) {
            // System.out.println("D");
            level = "D";
        } else {
            // System.out.println("F~");
            level = "F~";
        }

        // 若不給 else 會報錯，因為可能會有else出現，不賦予level值
        System.out.printf("分數：%d\t評比：%s\n", score, level);
        System.out.println("評比結束...");

        // 越嚴苛的越前面，按照順序判讀，只要有一個判斷式為真就離開多向判斷式
        // 判斷式都沒成立則記得最後要加上(保留)else
        // score = 99;
        if (score == 100) {
            System.out.println("A+");
        } else if (score >= 60) {
            System.out.println("A");
        } else if (score >= 70) {
            System.out.println("B");
        } else if (score >= 80) {
            System.out.println("C");
        } else if (score >= 90) {
            System.out.println("D");
        } else {
            System.out.println("F~");
        }

        // 巢狀if判斷式
        if (score > 60) {
            noGood = "OK!";
            if (score >= 100) {
                // System.out.println("A+");
                level = "A+";
                System.out.println("優秀!");
            } else if (score >= 90) {
                // System.out.println("A");
                level = "A";
            } else if (score >= 80) {
                // System.out.println("B");
                level = "B";
            } else if (score >= 70) {
                // System.out.println("C");
                level = "C";
            } else {
                level = "D";
            }
        } else {
            level = "E";
            noGood = "罰寫";
            System.out.println("留校~");
            if (score > 50) {
                System.out.println("罰寫1次");
            } else if (score > 40) {
                System.out.println("罰寫2次");
            } else if (score > 40) {
                System.out.println("罰寫3次");
            } else if (score > 30) {
                System.out.println("罰寫4次");
            } else {
                System.out.println("罰寫5次");
            }
        }
        System.out.printf("分數：%d\t評比：%s\t%s\n", score, level, noGood);
        System.out.println("評比結束...");

        input.close();

    }
}
