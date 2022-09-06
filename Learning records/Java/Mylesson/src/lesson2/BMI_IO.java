package lesson2;

import java.util.Scanner;

public class BMI_IO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("輸入姓名：");
        String name = input.nextLine();

        System.out.println("請輸入身高 (cm)：");
        float height = input.nextFloat();

        System.out.println("請輸入體重 (kg)：");
        float weight = input.nextFloat();

        // 計算 BMI (BMI值計算公式: BMI = 體重(公斤) / 身高^2(公尺^2))
        // double bmi = weight / ((height / 100) * (height / 100));
        // 內鍵函式做次方 Math.pow(要平方之公式 , 次方數)
        double bmi = weight / Math.pow(height / 100, 2);

        System.out.printf("姓名：%s 身高：%.2f 體重：%.2f BMI：%.2f%n",
                name, height, weight, bmi);
        System.out.println((int) bmi);
        System.out.printf("姓名：%s 身高：%.2f 體重：%.2f BMI：%d",
                name, height, weight, (int) bmi);

        input.close();

    }
}
