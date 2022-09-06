package example;

/**
 * ■ 實作一個檢查質數的方法
 * ■ 除了1跟本身能整除之外 <-- 質數
 * ■ 最小的質數是2
 * ■ 可以輸入五次整數進行檢查
 */
import java.util.Scanner;

public class Ch6_ex3 {
    public static void main(String[] args) {

        while (true) {
            // 使用者輸入 (數字、次數)
            Scanner scanner = new Scanner(System.in);
            System.out.print("請輸入一個數字(質數檢查)[-1:exit]：");
            int number = getNextInt(scanner);

            if (number == -1) {
                System.out.println("質數檢查程式結束！");
                break;
            }
            // 質數檢查
            primeNumber(number);
        }
    }

    public static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("請輸入正確型態的數字(Int)：");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * 質數的查找
     * 
     * @param number
     * @return true -> 質數 / false -> 不是質數
     */
    public static boolean primeNumber(int number) {
        int count = 0;
        int half = (int) Math.round(number / 2. + 1);
        for (int i = 1; i < half; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count > 2 || count == 1) {
            System.out.println(number + " 不是質數");
            return false;
        } else if (count == 2) {
            System.out.println(number + " 是質數");
            return true;
        }
        return false;
    }

}
