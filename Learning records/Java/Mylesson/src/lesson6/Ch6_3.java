package lesson6;

public class Ch6_3 {
    public static void main(String[] args) {
        int start = 0;
        int end = 100;
        int total = 0;
        for (int i = start; i < end + 1; i++) {
            total += 1;
        }
        System.out.println(total);
        start = 10;
        end = 100;
        total = 0;
        for (int i = start; i < end + 1; i++) {
            total += 1;
        }
        System.out.println(total);

        // 改成函式 ---> total
        // 與上面宣告的變數 total 不會互相干擾
        // 該給多少個值就要給多少
        total(0, 100);
        total(10, 100);

        //
        accumulate(0, 100, 2);
        accumulate(0, 1000, 2);
        int total1 = (int) accumulate2(0, 100, 1);
        int total2 = (int) accumulate2(100, 1000, 2);
        System.out.println("以上兩種總和為 = " + (total1 + total2));
        System.out.println("-------------------------------");
        System.out.println("以上兩種總和為 = " + (accumulate2(0, 100, 1) + accumulate2(100, 1000, 2)));
        System.out.println("-------------------------------");

        // 迴圈不動
        System.out.println(accumulate3(100, 0, 2));
        System.out.println(accumulate3(0, 100, 200));

        accumulate4(0, 100, 200, true);
    }

    // 自訂函式 (累加，間隔1)
    public static void total(int start, int end) {
        // start & end 不須重複宣告
        int total = 0;
        for (int i = start; i < end + 1; i++) {
            total += i;
        }
        System.out.println(total);
    }

    // 自訂函式 (累加，新增步進值) step
    public static void accumulate(int start, int end, int step) {
        int total = 0;
        for (int i = start; i < end + 1; i += step) {
            total += i;
        }
        System.out.printf("%d ~ %d = %d\n", start, end, total);
    }

    // 自訂函式 (累加，新增步進值) step
    // 透過 return 回傳(才能輸出)，void 改成回傳的資料型態
    public static double accumulate2(int start, int end, int step) {
        double total = 0;
        for (int i = start; i < end + 1; i += step) {
            total += i;
        }
        System.out.printf("%d ~ %d (間距：%d) = %d\n",
                start, end, step, total);
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

    // 正算反算 resverse
    public static int accumulate4(int start, int end, int step, boolean reverse) {
        int total = 0;
        if (reverse) {
            // 思考 ing
            System.out.println();
        } else {
            if (start > end) {
                System.out.println("參數有誤！ (start > end)");
                return -1;
            }
            if (step > end) {
                System.out.println("步階錯誤！ (step > end)");
                return -2;
            }
            for (int i = start; i < end + 1; i += step) {
                total += i;
            }
            System.out.printf("%d ~ %d (間距：%d) = %d\n",
                    start, end, step, total);
        }
        return total;
    }

}
