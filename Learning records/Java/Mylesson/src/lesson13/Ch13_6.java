package lesson13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

/**
 * 檔案讀寫
 * [1. 輸出流] 2.輸入流
 * 1.字元 [2. 位元]
 */
public class Ch13_6 {
    public static void main(String[] args) {
        String fileName = "Ch13_test_2.txt"; // 原為 UTF-8 TERMINL 會輸出亂碼，請用 Launch Current File2 跑
        // fileName = "test.txt"; // 測試用 (不存在)
        // fileName = "Ch13_test_1.txt"; // 測試用 (空)
        // fileName = "Ch13_test_3.txt"; // 測試用 (已改存成ANSI(CP950))
        // 如果檔案不再之例外處理 (強制一定要寫)
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            System.out.println(fileReader);

            // 成功抓到檔案才繼續做
            try {
                // 單一字元讀取
                int b = fileReader.read(); // -1 代表讀取結束
                System.out.println((char) b); // 輸出：A
                System.out.println("------------------------");

                // // 迴圈連續字元讀取，直到 -1 結束停止 // 會吃掉後面讀取方式，先隱藏
                // // int b;
                // while ((b = fileReader.read()) != -1) {
                // System.out.print((char) b); // 文字檔有隱藏之換行符號，不用特別處理換行問題
                // }
                // System.out.println();
                // System.out.println("------------------------");

                // 一次讀取 (要先取得檔案大小/長度)
                // long size = new File(fileName).length();
                // char[] buffer = new char[(int) size];
                char[] buffer = new char[(int) (new File(fileName).length())];
                fileReader.read(buffer);
                System.out.println(buffer); // 字元陣列
                System.out.println(String.valueOf(buffer)); // 字串 (存成一行，非陣列)

            } catch (IOException e) {
                System.out.println(e);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println("檔案不存在");
        } finally { // 檔案關閉，最好寫在 finally 中，以免上面程式碼又遇到錯誤，寫這裡不管發生甚麼都會執行
            try {
                if (fileReader != null) {
                    fileReader.close();
                    System.out.println("檔案關閉");
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }

        // // 測試用
        // char[] a = { 'A', 'B', 'C' };
        // String[] b = { "Apple", "Bird", "Cat" };
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(String.valueOf(b));

    }
}
