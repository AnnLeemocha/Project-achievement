package lesson13;

import java.io.File;
import java.util.ArrayList;

/**
 * 使用遞迴概念，抓取某資料夾下所有檔案
 * (包含旗下之資料夾中的檔案，不附資料夾名稱)
 * ArrayList<String> & ArrayList<File>
 * 都可用 add (目的增加物件數目)
 */

public class Ch13_4 {
    public static void main(String[] args) {

        String path = "src/lesson10/";

        findAllFiles(path);

        // ArrayList<String> fileList = new ArrayList<String>();
        // getAllFiles(path, fileList);
        // System.out.println("----------------------------------------------------------------------------");
        // System.out.println("目前共有" + fileList.size() + "個檔案");
        // fileList.forEach(f -> {
        // System.out.println("----------------------------------------------------------------------------");
        // System.out.println(f);
        // });
        // // fileList.forEach(f -> {System.out.println(f);}); // 單行輸出連在一起
        // // fileList.forEach(f -> System.out.println(f));

        // String ---> File
        ArrayList<File> fileList2 = new ArrayList<File>();
        getAllFiles(path, fileList2);
        System.out.println("目前共有" + fileList2.size() + "個檔案");
        fileList2.forEach(f -> {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(f.getName() + " , " + f.length());
        });
    }

    // 遞迴：指在函數的定義中使用函數自身的方法
    public static void findAllFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(f.getPath() + " --- Directory");
                // 遞迴 ---> 直到找到的資料夾下之檔案跑完自己的函式才回來跑下一筆
                findAllFiles(f.getPath());
                continue; // 不輸出目錄
            }
            System.out.println(f.getPath() + " --- File");
            // System.out.printf("名稱：%s ==> 檔案：%b 目錄：%b 大小：%d Byte\n",
            // f.getName(), f.isFile(), f.isDirectory(), f.length());
        }
    }

    // public static void getAllFiles(String path, ArrayList<String> fileList) {
    // File file = new File(path);
    // File[] files = file.listFiles();
    // for (File f : files) {
    // if (f.isDirectory()) {
    // getAllFiles(f.getPath(), fileList);
    // continue; // 不輸出目錄
    // }
    // // 傳址呼叫
    // fileList.add(f.getAbsolutePath());
    // }
    // }

    public static void getAllFiles(String path, ArrayList<File> fileList) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f.getPath(), fileList);
                continue; // 不輸出目錄
            }
            // 傳址呼叫
            fileList.add(f);
        }
    }
}
