package lesson3;

import java.util.Scanner;

public class Ch3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入秒數：");
        long second = input.nextLong();
        // long second = 24 * 3600 + 3600 + 60 + 1; // 123456789;
        int min = 0, hour = 0, day = 0;

        min = (int) (second / 60);
        hour = min / 60;
        day = hour / 24;

        int leftSec = (int) (second % 60);
        int leftMin = min % 60;
        int lefHr = hour % 24;

        // System.out.println(leftSec);
        // System.out.println(leftMin);
        System.out.printf("%d 秒 = %d天:%d時:%d分:%d秒\n",
                second, day, lefHr, leftMin, leftSec);

        int second_i = 0;

        second_i = (int) (second % 60);
        min = min % 60;
        hour = hour % 24;

        System.out.printf("%d 秒 = %d天:%d時:%d分:%d秒\n",
                second, day, hour, min, second_i);

        input.close();
    }
}
