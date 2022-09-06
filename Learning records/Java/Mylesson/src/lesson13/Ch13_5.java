package lesson13;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * 篩選檔案
 * 文字檔? 二進制檔?
 * 取得對應副檔名：{ ".jpg", ".png", ".bmp" }
 */
public class Ch13_5 {
    public static void main(String[] args) {

        // ArrayList<File> fileList = new ArrayList<File>();
        String path = "resoure/img";
        // listFiles 介面
        File[] files = new File(path).listFiles(new FileFilter() {

            private final String[] ext = { ".jpg", ".png" };

            @Override
            public boolean accept(File pathname) {
                // endsWith 從後面字元開始找
                for (String e : ext) {
                    if (pathname.getName().endsWith(e)) {
                        // if (pathname.getName().endsWith(".png") ||
                        // pathname.getName().endsWith(".jpg") ) {
                        return true;
                    }
                }
                return false;
            }
        });

        if (files != null) {

            for (File file : files) {
                System.out.println(file.getName());
            }
        }
        System.out.println("----------------------------------------------------------------------------");

        // filters 可接 null

        ArrayList<File> fileList2 = new ArrayList<File>();
        getAllFiles(path, fileList2, null);
        System.out.println("目前共有" + fileList2.size() + "個檔案");
        fileList2.forEach(f -> System.out.println(f.getName() + " , " + f.length()));
        System.out.println("----------------------------------------------------------------------------");

        fileList2 = new ArrayList<File>();
        String[] ext = { ".jpg", ".png" };
        getAllFiles(path, fileList2, ext);
        System.out.println("目前共有" + fileList2.size() + "個檔案");
        fileList2.forEach(f -> System.out.println(f.getName() + " , " + f.length()));
        System.out.println("----------------------------------------------------------------------------");

    }

    // // 優化
    // public static void getAllFiles(String path, ArrayList<File> fileList) {
    // final String[] filters = { ".jpg", ".png", ".bmp" };
    // File file = new File(path);
    // File[] files = file.listFiles();
    // for (File f : files) {
    // if (f.isDirectory()) {
    // getAllFiles(f.getPath(), fileList);
    // continue; // 不輸出目錄
    // }

    // for (String f2 : filters) {
    // if (f.getName().endsWith(f2)) {
    // // 傳址呼叫
    // fileList.add(f);
    // }
    // }
    // }
    // }

    public static void getAllFiles(String path, ArrayList<File> fileList, String[] filters) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f.getPath(), fileList, filters);
                continue; // 不輸出目錄
            }
            // 免篩選檔案
            if (filters == null) {
                fileList.add(f);
                continue;
            }
            // 篩選檔案
            for (String filter : filters) {
                if (f.getName().endsWith(filter)) {
                    // 傳址呼叫
                    fileList.add(f);
                    break;
                }
            }
        }
    }
}
