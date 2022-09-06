package lesson3;

import java.util.Scanner;

public class Score_pass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入國文分數：");
        float chineseScore = input.nextFloat();
        System.out.print("請輸入數學分數：");
        float mathScore = input.nextFloat();
        System.out.print("請輸入英文分數：");
        float englishScore = input.nextFloat();

        boolean pass = (chineseScore >= 60 || mathScore >= 60) && englishScore >= 60;
        // boolean pass = (chineseScore >= 60 || mathScore >= 60) && englishScore > 60;

        if (pass) {
            System.out.println("合格! (PASS!)");
        } else {
            System.out.println("沒通過! (FATL~)");
        }

        //
        String pass_o = "";
        if ((chineseScore >= 60 || mathScore >= 60) && englishScore >= 60) {
            pass_o = "恭喜通過!";
        } else {
            pass_o = "留校察看~";
        }

        System.out.println(pass_o);

        // 三元運算 (判斷式 ? 為True運算式 : 為False運算式)
        String pass_three;
        pass_three = (chineseScore >= 60 || mathScore >= 60) && englishScore >= 60 ? "恭喜通過!" : "留校察看~";
        System.out.println("Way 1：" + pass_o + "\t Way 2 ：" + pass_three);
        System.out.println(
                (chineseScore >= 60 || mathScore >= 60) && englishScore >= 60 ? "恭喜通過!" : "留校察看~");

        input.close();
    }
}
