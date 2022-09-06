package example;

/**
 * ■ 銀行利息計算
 * ■ 請設計一程式可以輸入存款金額及年利率，計算出每個月
 * 的利息及一年到期的本利和。
 */

import java.util.Scanner;

public class Ch3_ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入存款金額：");
        int money = input.nextInt();
        System.out.print("請輸入年利率 (%)：");
        float rate = input.nextFloat() / 100;

        float interest = money * rate;
        float interestMonth = interest / 12;
        double amount = money + interest;

        System.out.printf("每月利息為： %.0f\n", interestMonth);
        System.out.printf("年收益為： %.0f\n", amount);

        // System.out.printf("(月利率為:%f%%) 每月利息為:%.0f%n", rate / 12, interestMonth);
        // System.out.printf("(年利率為:%f%%) 年收益為:%.0f%n", rate, amount);

        input.close();
    }
}
