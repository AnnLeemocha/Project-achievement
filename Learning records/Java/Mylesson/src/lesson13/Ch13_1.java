package lesson13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ch13_1 {
    public static void main(String[] args) {

        System.out.println("===========================================");
        String fileName = "Ch13_test_1.txt"; // 檔案名稱 (於同資料夾中)
        // 取得當下目錄位置 fileName = "";

        File file = new File(fileName);

        System.out.println(file.exists()); // 檔案是否存在
        System.out.println(file); // 只回傳檔案名稱
        System.out.println(file.length()); // 檔案大小 (byte)
        // 為何抓取不到資料，因目前存在之目錄位置不對
        System.out.println(file.getAbsolutePath());

        System.out.println("===========================================");
        // 直接寫檔案名稱，通常在專案目錄底下，可以看 TERMINAL 確認一下
        fileName = "Ch13_test_2.txt";
        file = new File(fileName);
        // System.out.println(file.exists());
        if (file.exists()) {
            System.out.println(file);
            System.out.println(file.length());
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("===========================================");
        // 相對路徑從當前運行目錄開始寫
        // 相對路徑 ===> Windows 路徑表達方式 (\\)
        fileName = "src\\lesson13\\Ch13_test_1.txt";
        // 相對路徑 ===> Linux 路徑表達方式 (/)
        fileName = "src/lesson13/Ch13_test_1.txt";
        // 絕對路徑 (通常為取非專案檔案中的檔案)
        fileName = "D:/Desktop/機器與深度學習課程/JAVA/JavaProject/Mylesson/src/lesson13/Ch13_test_1.txt";
        file = new File(fileName);
        // System.out.println(file.exists());
        if (file.exists()) {
            System.out.println(file);
            System.out.println(file.length());
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("===========================================");
        // 路徑測試，為檔案名稱
        fileName = "src/lesson13/Ch13_test_1.txt";
        file = new File(fileName);
        // System.out.println(file.exists());
        if (file.exists()) {

            System.out.println(file);

            System.out.println(file.getName());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println(file.isHidden());
            System.out.println(file.length());
            System.out.printf("%s ==> 檔案：%b  目錄：%b  大小：%d Byte\n",
                    file.getName(), file.isFile(), file.isDirectory(), file.length());
            System.out.printf("%s ==> 檔案：%b  目錄：%b  大小：%.2f KB\n",
                    file.getName(), file.isFile(), file.isDirectory(), (file.length() / 1024.0));
            System.out.println("----------------------------------------");
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            System.out.println(file.getParent());
            System.out.println(file.getParent());
        }
        // 上一層目錄查找最上只到專案資料夾，再往上即為 null
        fileName = "Ch13_test_2.txt";
        file = new File(fileName);
        System.out.println(file.getParent());

        System.out.println("===========================================");
        // fileName = "Ch13_test_2.txt";
        fileName = "Ch13_test_1.txt";
        file = new File(fileName);

        // 刪除 & 創建 檔案
        if (file.exists()) {
            System.out.println("檔案存在");
            // 得到檔案最近一次修改的時間
            System.out.println(file.lastModified());
            Scanner scanner = new Scanner(System.in);
            System.out.println("是否刪除檔案：");
            if (scanner.next().toLowerCase().equals("y")) {
                // 刪除檔案
                file.delete();
            }
            scanner.close();
        } else {
            System.out.println("檔案不存在");
            // 建立檔案
            try {
                if (file.createNewFile()) {
                    System.out.println("檔案建立成功");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        System.out.println("===========================================");
        // 若要取檔案中的所有資料
        // 路徑測試，為資料夾目錄
        String path = "d:\\Matlab";
        file = new File(path);
        if (file.exists()) {
            System.out.println(file.getName());
            System.out.println(file.length());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println(file.isHidden());
        }
    }
}
