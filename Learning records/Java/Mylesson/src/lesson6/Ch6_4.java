package lesson6;

import java.util.Scanner;
import tools.Tool;

public class Ch6_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入數字： ");

        // 自製函式庫 tools.Tool;
        Tool.getNextInt(input);

        // 解決 null 輸入問題

        input.close();
    }

}
