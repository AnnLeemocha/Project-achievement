package lesson4;

import java.util.Scanner;

public class Movie_ticket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int price = 250; // 不要寫死 (好更改)
        float pay = 0;
        float totalPay = 0;
        int totalCount = 0;

        System.out.println("欣欣大戲院");
        System.out.println("(1) 全票一張250元");
        System.out.println("(2) 優待票 -> 全票打85折");
        System.out.println("(3) 敬老票 -> 優待票打8折");
        System.out.println("(4) 早場票 -> 優待票打8折");

        // 方法一：自己於最後決定何時停止
        for (int i = 0;; i++) {
            System.out.printf("第 %d 次輸入：\n", i + 1);
            System.out.print("請選擇票種：");
            int ticketType = input.nextInt();
            System.out.print("請選擇張數：");
            int ticketCount = input.nextInt();

            boolean error = false; // 放回圈內做初始化避免跑回圈時錯誤

            switch (ticketType) {
                case 1:
                    pay = price;
                    break;
                case 2:
                    pay = price * 0.85f;
                    break;
                case 3:
                case 4:
                    pay = price * 0.85f * 0.8f;
                    break;

                default:
                    error = true;
                    break;
            }
            if (error) {
                System.out.println("輸入錯誤");
            } else {
                totalPay += pay * ticketCount;
                totalCount += ticketCount;
                // System.out.printf("你選擇 %d 票價為： %.0f 元\n", ticketType, pay);
                System.out.printf("你選擇 %d 號票種 共 %d 張  總票價為： %.0f 元 (%.0f元/張)\n",
                        ticketType, ticketCount, pay * ticketCount, pay);
                System.out.println("累計購買金額： " + totalPay + " 元  累積購買張數： " + totalCount + " 張");
                System.out.printf("累計購買金額： %.0f 元  累計購買張數： %d 張\n",
                        totalPay, totalCount);
            }
            System.out.println("是否重新輸入？(y/n)");
            String choice = input.next();
            boolean endChoice = true;
            switch (choice) {
                case "y":
                case "Y":
                case "YES":
                case "yes":
                case "Yes":
                    endChoice = true;
                    System.out.println("繼續");
                    break;

                default:
                    endChoice = false;
                    System.out.println("結束");
                    break;
            }

            if (endChoice) {
                continue;
            } else {
                break;
            }

        }

        // 方法二：自己於最開始決定何時停止
        System.out.print("請選擇張數：");
        int ticketCount2 = input.nextInt();
        for (int i = 0; i < ticketCount2; i++) {
            System.out.printf("第 %d 次輸入：\n", i + 1);
            System.out.print("請選擇票種：");
            int ticketType2 = input.nextInt();

            boolean error = false; // 放回圈內做初始化避免跑回圈時錯誤

            switch (ticketType2) {
                case 1:
                    pay = price;
                    break;
                case 2:
                    pay = price * 0.85f;
                    break;
                case 3:
                case 4:
                    pay = price * 0.85f * 0.8f;
                    break;

                default:
                    error = true;
                    break;
            }
            if (error) {
                System.out.println("輸入錯誤");
            } else {
                totalPay += pay * ticketCount2;
                totalCount += ticketCount2;
                // System.out.printf("你選擇 %d 票價為： %.0f 元\n", ticketType, pay);
                System.out.printf("你選擇 %d 號票種 共 %d 張  總票價為： %.0f 元 (%.0f元/張)\n",
                        ticketType2, ticketCount2, pay * ticketCount2, pay);
                System.out.println("累計購買金額： " + totalPay + " 元  累積購買張數： " + totalCount + " 張");
                System.out.printf("累計購買金額： %.0f 元  累計購買張數： %d 張\n",
                        totalPay, totalCount);
            }
        }

        input.close();
    }
}
