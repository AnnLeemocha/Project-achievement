package lesson4;

import java.util.Scanner;

public class Ch4_3 {
    public static void main(String[] args) {
        int choice = 1;

        // if
        if (choice == 1) {
            System.out.println("選擇 1 ");
        } else if (choice == 2) {
            System.out.println("選擇 2 ");
        } else {
            System.out.println("選擇錯誤");
        }

        // switch
        switch (choice) {
            case 1:
                System.out.println("選擇 1 ");
                break; // [停止] 沒有 break 會繼續往下一個 case 跑直到遇到 break
            case 2:
                System.out.println("選擇 2 ");
                break;

            default:
                System.out.println("選擇錯誤");
                break;
        }

        //
        Scanner input = new Scanner(System.in);
        System.out.println("是否繼續？(y/n)");
        String choice_1 = input.next();

        // if
        if (choice_1.equals("y") || choice_1.equals("Y")) {
            System.out.println("繼續");
        } else {
            System.out.println("結束");
        }
        // switch (管理多個選項適用)
        switch (choice_1) {
            case "y":
            case "Y":
            case "YES":
            case "yes":
            case "Yes":
                System.out.println("繼續");
                break;

            default:
                System.out.println("結束");
                break;
        }

        input.close();
    }
}
