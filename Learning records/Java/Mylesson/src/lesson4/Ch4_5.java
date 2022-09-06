package lesson4;

import java.util.Scanner;

public class Ch4_5 {
    public static void main(String[] args) {
        // 可輸入起始值a跟終止值b，計算a~b之間的偶數值進行總和運算
        int totalSum = 0, evenSum = 0, oddSum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("計算a~b之間的偶數值進行總和運算");
        System.out.println("請輸入起始值a跟終止值b (兩數字以空格為間格)：");
        int start = input.nextInt(), end = input.nextInt();
        System.out.println("起始值 = " + start + " ~ 終止值 = " + end);
        if (start > end) {
            System.out.printf("起始值(%d)不能大於終止值(%d)\n", start, end);
        } else {
            for (int i = start; i <= end; i++) {
                totalSum += i;
                if (i % 2 == 1) { // 取奇數
                    oddSum += i;
                } else if (i % 2 == 0) { // 取偶數
                    evenSum += i; // total = total +i
                }
            }
            System.out.printf("%d ~ %d 的全部累加值為： %d\n",
                    start, end, totalSum);
            System.out.printf("%d ~ %d 的偶數累加值為： %d\n",
                    start, end, evenSum);
            System.out.printf("%d ~ %d 的奇數累加值為： %d\n",
                    start, end, oddSum);
        }

        input.close();

    }
}
