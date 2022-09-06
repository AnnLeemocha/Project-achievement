package example;

/**
 * ■ 計算BMI身體質量指數
 * ■ 輸入身高跟體重進行BMI值的計算
 *     ■ 輸入為double型態
 *     ■ 輸出為.2f格式化
 */

import java.util.Scanner;

public class Ch2_ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("請輸入身高 (cm)："); // 188
        float height = input.nextFloat();

        System.out.println("請輸入體重 (kg)："); // 78
        float weight = input.nextFloat();

        // 計算 BMI (BMI值計算公式: BMI = 體重(公斤) / 身高^2(公尺^2))
        // 體重正常範圍為 BMI=18.5～24
        double bmi = weight / Math.pow(height / 100, 2);

        // System.out.println("====================== 以下輸出 ======================");

        System.out.printf("BMI is %.2f%n", bmi); // 20.7

        input.close();

    }
}
