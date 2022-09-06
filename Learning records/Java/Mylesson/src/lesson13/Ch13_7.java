package lesson13;

// import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 檔案讀寫
 * 1. 輸出流 [2.輸入流]
 * 1.字元 [2. 位元]
 * 空檔，不存在，有內容(覆蓋變成空)
 */
public class Ch13_7 {
    public static void main(String[] args) {
        // String fileName = "resoure/txt/test.txt";
        String fileName = "Ch13_test_4.txt";
        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter = null;
        try {
            // fileWriter = new FileWriter(fileName); // 有內容(覆蓋變成空)
            fileWriter = new FileWriter(fileName, true); // 附加在後面
            System.out.println(fileWriter);

            fileWriter.write("123\n456\n中文測試\n"); // 最後記得家換行，續寫會連在後面
            System.out.println("輸入內容：");
            while (!scanner.next().equals("-1")) {
                String s = scanner.next();
                if (s == "-1") {
                    break;
                }
                fileWriter.write(s);
            }
            System.out.println("寫入成功！");

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    scanner.close();
                    System.out.println("檔案關閉");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
