package lesson4;

import java.util.Scanner;

public class Ch4_14 {
    public static void main(String[] args) {

        //// 檢查數字是否是質數(除了1跟自己本身的數字可以整除的數)
        // 使用者迴圈輸入
        Scanner input = new Scanner(System.in);
        // for (int j = 0; j < 3; j++) {
        while (true) {
            System.out.print("請輸入數字(整數)(-1:exit): ");
            int number = input.nextInt();
            if (number == -1) {
                break;
            }
            int count = 0;
            for (int i = 1; i <= number; i++) { // (節省：number/2+1)
                // 倍數判斷與累加
                if (number % i == 0) {
                    count++;
                }
                // 非質數判斷
                if (count > 2) {
                    break;
                }
            }
            // 輸出結果
            if (count == 2) { // 去除數字 1 的非質數
                System.out.printf("%d 是質數%n", number);
            } else {
                System.out.printf("%d 不是質數%n", number);
            }

        }
        // }

        // ====================================================================

        //// 檢查輸入值的(數字)型態正確與否? (ex. hasNextInt(), ... [正確輸出 true])
        System.out.print("請輸入數字(整數): ");
        // 檢查
        while (!input.hasNextInt()) {
            // 【注意!! input.hasNextInt() 會保留原本輸入】
            System.out.println("輸入錯誤！");
            System.out.print("請重新輸入正確數字(整數): ");
            // 【清除輸入，重新輸入新值，再進入 while 迴圈】
            input.next();
        }

        // 輸出
        // 【若 input.hasNextInt() 為 true ， input.nextInt() 會繼承該輸入】
        int number = input.nextInt();
        System.out.printf("你輸入的是:%d", number);

        input.close();

    }
}
