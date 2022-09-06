package example;

import java.util.Scanner;

/**
 * ■ 使用switch case 選擇敘述
 * ■ 請撰寫一程式可以輸入兩個數字
 * ■ 進行(+,-,*,/)運算
 * ■ 除法要輸出到小數點2位數
 */

public class Ch4_ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("計算機程式");
        System.out.print("請輸入數字 1 ： ");
        float n1 = input.nextFloat();
        System.out.print("請輸入數字 2 ： ");
        float n2 = input.nextFloat();
        System.out.print("請輸入運算子(+-*/)： ");
        String operator = input.next();
        float ans = -9999f;
        boolean error = false;

        switch (operator) {
            case "+":
                ans = n1 + n2;
                break;
            case "-":
                ans = n1 - n2;
                break;
            case "*":
                ans = n1 * n2;
                break;
            case "/":
                ans = n1 / n2;
                break;

            default:
                error = true;
                break;
        }
        // 可惜不知道怎麼把字串轉成運算子使用...
        // System.out.println(n1 + Integer.parseInt(operator) + n2); // (XX)
        if (error) {
            System.out.println("運算子輸入錯誤!!");
        } else {
            System.out.printf("%.2f %s %.2f = %.2f\n", n1, operator, n2, ans);
        }

        input.close();
    }
}
