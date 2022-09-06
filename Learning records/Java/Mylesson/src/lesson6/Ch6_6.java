package lesson6;

public class Ch6_6 {
    public static void main(String[] args) {

        // end
        total(100);
        // start, end
        total(0, 100);
        total(10, 100);
        // start, end, step
        total(0, 100, 2);
        total(0, 100, 0.5);

    }

    // 自訂函式 (迴圈累加) ============================================
    // start, end, step
    public static double total(int start, int end, int step) {
        double total = 0;
        for (int i = start; i < end + step; i += step) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %.2f\n",
                start, end, step, total);
        return total;
    }

    // start, end
    public static double total(double start, double end, double step) {
        double total = 0;
        for (double i = start; i < end + step; i += step) {
            total += i;
        }
        System.out.printf("%.2f ~ %.2f (間距：%.2f) = %.2f\n",
                start, end, step, total);
        return total;
    }

    // end
    public static double total(int start, int end) {
        double total = 0, step = 1;
        for (int i = start; i < end + step; i++) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %.0f\n",
                start, end, 1, total);
        return total;
    }

    public static double total(int end) {
        double total = 0, step = 1;
        for (int i = 0; i < end + step; i++) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %.2f\n",
                0, end, 1, total);
        return total;
    }

    // 自訂函式
    // 多個 return
    // 函式的說明：
    /**
     * 計算總和的函式：
     * 
     * @param start(起始值)
     * @param end(終止值)
     * @param step(步進值)
     * @return 回傳結果 (-1 start error | -2 step error)
     */
    public static double accumulate3(int start, int end, int step) {
        if (start > end) {
            System.out.println("參數有誤！ (start > end)");
            return -1; // 同 break 直接離開函式
            // 記得要回傳值，通常回傳 -1 錯誤沒意義
            // 但也可以賦予其他值，但一定要賦值
        }
        if (step > end) {
            System.out.println("步階錯誤！ (step > end)");
            return -2;
        }
        double total = 0;
        for (int i = start; i < end + 1; i += step) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %d\n",
                start, end, step, total);
        return total;
    }

}
