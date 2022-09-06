package lesson2;

public class Ch2_6 {
    public static void main(String[] args) {

        float rate = 0.02f;
        int money = 50000;
        float interest = money * rate;
        double amount = money + interest;
        String name = "張三";

        // 沒有強制換行功能
        System.out.printf("(1). %s %d %3.2f %6.2f %8.2f",
                name, money, rate, interest, amount);
        System.out.println();
        // 字串不能直接換行
        System.out.printf("(2). 存款人：%10s 存款金額：%d 年利率：%3.2f " +
                "年利息：%6.2f 本利和：%8.2f\n",
                name, money, rate, interest, amount);
        // 百分比 -> %%
        // 換行 -> \n or %n
        System.out.printf("(3). 存款人：%5s , 存款金額：%d , 年利率：%3.2f %% " +
                ", 年利息：%6.2f , 本利和：%8.2f %n",
                name, money, rate, interest, amount);
        // 加在 % 與 數字間：
        // 數字前加 + (+)
        // 補 0 (0)
        // 千分為分隔 (,)
        // 靠左輸出 (-)
        System.out.printf("(3). 存款人：%-5s , 存款金額：%+08d , 年利率：%3.2f %% " +
                ", 年利息：%6.2f , 本利和：%,8.2f %n",
                name, money, rate, interest, amount);
        System.out.println("結束計算!");

    }
}
