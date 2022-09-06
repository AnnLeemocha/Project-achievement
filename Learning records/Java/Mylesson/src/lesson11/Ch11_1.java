package lesson11;

import java.io.File;

public class Ch11_1 {
    public static void main(String[] args) {
        // 例外處理
        // 導致整個程式中斷無法運行

        // 所有例外類別的父類別 Throwable (主要子類別有Exception， Error)

        // Error (系統級別的錯誤，非邏輯的無法處理的)

        // Exception (子類分 (1)不一定要處理 RuntimeException (2)一定要處理 IOException)
        // (1) 執行期的錯誤，不會報錯，"不一定要處理" ---> RuntimeException
        // ___ 沒有使用任何的例外處理機制，故例外發生時由main函式拋出給JRE，導致程式中止執行
        // (2) 編譯時會報錯，"一定要處理" ---> IOException

        // => 除了Error以及RuntimeException 類別， 其餘都必須強制處理否則會編譯失敗

        // 例外處理的兩個方式
        // 其一： 使用例外處理語句進行捕捉 (try…catch)
        // 其二： 發生例外時暫不處理並由方法呼叫者進行處理 (拋出處理) ---> atm
        // _____ 拋出例外使用throws
        // _____ 主要應用在函式(方法)
        // _____ 自行拋出例外方式 [1.]

        System.out.println("======================================================");
        int[] numbers = { 1, 2, 3, 4, 5 };
        // 【只要 try 遇到錯誤就會跳至 catch ，不會執行 try 中後續內容】
        // try {
        // System.out.println(10 / 0);
        // System.out.println(numbers[numbers.length]);
        // } catch (ArrayIndexOutOfBoundsException ex) {
        // System.out.println(ex);
        // System.out.println("陣列超出範圍");
        // } catch (java.lang.ArithmeticException ex) {
        // System.out.println(ex);
        // System.out.println("除數不能為0");
        // } finally {
        // System.out.println("到達finally...");
        // }

        System.out.println("======================================================");
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5
        // out of bounds for length 5
        // at lesson11.Ch11_1.main(Ch11_1.java:39)

        try {
            // 終止情況 ： 陣列超出範圍
            System.out.println(numbers[numbers.length]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            // } catch (java.lang.ArrayIndexOutOfBoundsException) {
            System.out.println("錯誤資訊輸出：" + ex); // (1)
            System.out.println(ex.getMessage()); // (2)
            System.out.println("陣列超出範圍"); // (3) xxx.log 文字檔 (輸出錯誤資訊)
            ex.printStackTrace(); // (4)
        } finally {
            System.out.println("這部分不一定要有，為最後輸出");
            System.out.println("到達finally...");
        }

        System.out.println("======================================================");

        try {
            // 終止情況 ： 算術異常
            System.out.println(10 / 0);
        } catch (ArithmeticException ex) {
            // } catch (java.lang.ArithmeticException ex) {
            System.out.println(ex);
            System.out.println("除數不能為0");
        } finally {
            System.out.println("這部分不一定要有，為最後輸出");
            System.out.println("到達finally...");
        }

        System.out.println("======================================================");

        File file = null;
        try {
            file = open("test.txt");
            file.canWrite();
            file.canRead();
        } catch (Exception e) {
            if (file != null) {
                // file.close();
            }
        }

        System.out.println("======================================================");

        // 若無例外處理，前面程式中斷無法運行
        System.out.println("done!");

    }

    private static File open(String string) {
        return null;
    }
}
