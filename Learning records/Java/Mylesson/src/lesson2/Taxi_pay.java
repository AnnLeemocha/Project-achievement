package lesson2;

import java.util.Scanner;

public class Taxi_pay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("請輸入公里數：");
        float km = input.nextFloat();

        int pay = (int) ((km - 1) * 20 + 70); // 記得把要轉型的範圍()起來
        float payp = ((km - 1) * 20 + 70);
        // 注意 <1km 的情況
        if (km < 1) {
            pay = 70;
            payp = 70;
        }

        System.out.printf("里程數:%.3f\t費用:%d(元)\t (原始費用:%.2f)\n",
                km, pay, payp);
        // 若格式化輸出，注意字串中輸入的數字型態，後面輸入數字變數前面記得加上強制轉型
        System.out.printf("里程數:%.3f\t費用:%d(元)\t (原始費用:%.2f)\n",
                km, (int) payp, payp);
        // 或是反過來調整字串中輸入的數字型態
        System.out.printf("里程數:%.3f\t費用:%.0f(元)\t (原始費用:%.2f)\n",
                km, payp, payp);

        input.close();
    }
}
