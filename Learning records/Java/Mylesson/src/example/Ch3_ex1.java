package example;

/**
 * ■ 請撰寫一程式，可輸入三個分數，並計算出總分跟平均分
 *     ■ 平均成績在60分以上及格
 *     ■ 輸出如下格式
 */

import java.util.Scanner;

public class Ch3_ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("學生成績輸入系統");
        System.out.print("請輸入國文分數：");
        float chScore = input.nextFloat();
        System.out.print("請輸入數學分數：");
        float maScore = input.nextFloat();
        System.out.print("請輸入英文分數：");
        float enScore = input.nextFloat();
        float total = chScore + maScore + enScore;
        float average = total / 3;
        boolean pass = average >= 60;
        System.out.println("=============================================");
        // System.out.printf("chinence\t english\t math\t total\t average\n" +
        // "%.0f\t %.0f\t %.0f\t %.0f\t %.1f\n",
        int len = 8;
        System.out.printf("%" + len + "s\t %" + len + "s\t %" + len + "s\t %" + len + "s\t %" + len + "s\n",
                "chinence", "english", "math", "total", "average");
        System.out.printf("%" + len + ".0f\t %" + len + ".0f\t %" + len + ".0f\t %" + len + ".0f\t %" + len + ".1f\n",
                chScore, enScore, maScore, total, average);
        if (pass) {
            System.out.println("此次考試成績合格！");
        } else {
            System.out.println("此次考試成績不及格!");
        }
        input.close();

    }
}
