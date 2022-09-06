package example;

/**
 * ■ 火車票價試算程式
 * ■ 1. 自強號 每公里 2.3 元
 * ■ 2. 莒光號 每公里 1.78元
 * ■ 3. 區間車 每公里 1.45元
 * ■ 使用者可以輸入公里數(整數) 跟選擇車種並輸出費用(四捨五入)
 */

import java.util.Scanner;

public class Ch4_ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("火車計費程式");
        System.out.println("1. 自強號 每公里 2.3  元");
        System.out.println("2. 莒光號 每公里 1.78 元");
        System.out.println("3. 區間車 每公里 1.45 元");
        System.out.println("請輸入選擇：");
        float carType = input.nextFloat();
        System.out.println("請輸入公里數：");
        // int km = input.nextFloat();
        float km = input.nextFloat();
        float payType = 0;
        String trainType = "";
        double pay = 0;
        boolean error = false;

        // 方法一：判斷式
        if (carType == 1) {
            payType = 2.3f;
            trainType = "自強號";
        } else if (carType == 2) {
            payType = 1.78f;
            trainType = "莒光號";
        } else if (carType == 3) {
            payType = 1.45f;
            trainType = "區間車";
        } else {
            error = true;
        }
        // 方法一：存入矩陣
        // String[] trainType = {"自強號", "莒光號", "區間車"};
        // double trainPrice[] = {2.3, 1.78, 1.45};
        // ......

        // 判斷式(一)
        if (km < 1) {
            pay = payType * 1.0;
        } else if (km >= 1) {
            pay = Math.round(km) * payType * 1.0; // 四捨五入 (float)
            // pay = Math.ceil(km)*payType; // 無條件進位 (double)
            // pay = Math.floor(km)*payType; // 無條件捨去 (double)
        } else {
            pay = -9999;
        }
        // // 判斷式(二)
        // pay = (km < 1) ? payType : Math.round(km) * payType;
        if (error) {
            System.out.println("輸入錯誤，無此車種，請重新輸入！");
        } else {
            System.out.printf("您的選擇是  %s\t共 %.0f 元\n",
                    trainType, pay);
        }

        input.close();
    }
}
