package lesson13;

import java.io.File;
import java.io.IOException;

public class Ch13_2 {
    public static void main(String[] args) throws IOException {

        // 建立目錄 (假設目錄不存在)
        String path = "resoure/txt/";
        // 單層路徑使用
        new File(path).mkdir();
        // 多層路徑使用
        new File(path).mkdirs();

        // 建立檔案
        String file = "test.txt";
        if (new File(path + file).createNewFile()) {
            // 若檔案以存在則不執行，不會覆寫
            System.out.println(file + "建立成功！");
        }
        // file.delete(); // 不能使用
        new File(path).delete();

        // 建立檔案含路徑(目錄)
        file = "test3.txt";
        if (new File(path, file).createNewFile()) {
            // 若檔案以存在則不執行，不會覆寫
            System.out.println(file + "建立成功！");
        }

        // 練習： 建立 1.txt~10.txt ==> resoure/txt/temp
        path = "resoure/txt/temp/";
        new File(path).mkdirs();
        for (int i = 0; i < 10; i++) {
            file = (i + 1) + ".txt";
            // System.out.println(file);
            if (new File(path, file).createNewFile()) {
                System.out.println(file + " 建立成功！");
            }
        }

    }
}
