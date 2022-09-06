package lesson5;

// import java.util.Random;
/**
 * 樂透產生器
 */
import java.util.Arrays;
import java.util.Random;

public class Ch5_10 {
    public static void main(String[] args) {

        Random random = new Random();
        int x1 = (int) (random.nextInt(11));
        double x2 = random.nextDouble(0, 11);
        System.out.println(x1);
        System.out.println(x2);

        //// 宣告 -----------------------------------------------------------
        int countDay = 10;
        int countNum = 5;
        int[][] lotto = new int[countDay][countNum];

        // 樂透號碼
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < lotto[i].length; j++) {
                // 1~49 (1,2,...,49)
                while (true) {
                    int number = (int) (Math.random() * 49) + 1;

                    boolean duplicate = false;
                    for (int n : lotto[i]) {
                        if (n == number) {
                            duplicate = true;
                            break;
                        }
                    }
                    // 不重覆 離開迴圈
                    if (!duplicate) {
                        lotto[i][j] = number;
                        break;
                    }
                }

            }
            // 重新排序 (小到大)
            // Arrays.sort(lotto[i]);
            // sort可以指定起始與結束點
            Arrays.sort(lotto[i], 0, countNum - 1);
        }
        // 輸出
        for (int[] i : lotto) {
            int count = 0;
            for (int j : i) {
                if (count++ == i.length - 1) {
                    System.out.printf(" | 特別號：%2d\n", j);
                    continue;
                }
                System.out.printf("|   %2d  ", j);
            }
            // System.out.println();
        }

    }
}
