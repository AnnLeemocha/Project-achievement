package lesson13;

import java.io.File;
import java.util.Arrays;

public class Ch13_3 {
    public static void main(String[] args) {
        String path = "resoure/txt/";
        // 取得目錄底下檔案
        String[] fileName = new File(path).list();
        for (String f : fileName) {
            System.out.println(f);
        }
        System.out.println("-------------------");

        // 取得目錄底下檔案(回傳檔案物件)
        File[] files = new File(path).listFiles();
        for (File f : files) {
            System.out.println(f + " ,  " + f.isDirectory());
        }
        System.out.println("-------------------");

        //
        File file = new File(path);
        System.out.println(file);
        System.out.println(file.list());
        System.out.println(Arrays.toString(file.list()));
        System.out.println("-------------------");

        // 一層目錄全輸出 (檔案加目錄資料夾)
        path = "src/lesson10/";
        File[] files2 = new File(path).listFiles();
        for (File f : files2) {
            System.out.printf("名稱：%s ==> 檔案：%b  目錄：%b  大小：%d Byte\n",
                    f.getName(), f.isFile(), f.isDirectory(), f.length());

            // // 使用權限
            // System.out.println(f.canRead());
            // System.out.println(f.canWrite());
        }

    }

}
