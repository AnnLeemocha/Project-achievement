package example;

import java.util.Scanner;

import example.example.ATM;

/**
 * ■ 實作一個ATM類別
 * _ ■ -balance:int
 * _ ■ -loginSuccess:boolean
 * _ ■ -name:String
 * _ ■ -password:String
 * _ ■ +login():name:String,password:String
 * _ ■ +despoit():amount:int
 * _ ■ +withdraw():amount:int
 */
public class Ch8_ex1_ATMDemo {
    public static void main(String[] args) {

        // ATM.java 測試程式碼：

        Scanner scanner = new Scanner(System.in);
        System.out.println("第一次請設定帳號密碼");
        System.out.print("姓名：");
        String name = scanner.next();
        System.out.print("密碼：");
        String password = scanner.next();

        // String name = "Jerry";
        // String password = "123456";
        ATM atm = new ATM(name, password);
        System.out.println("密碼設定完成！");

        System.out.println("--------------------------------------");

        int count = 0, maxCount = 3;
        do {
            System.out.println("登入帳號密碼");
            System.out.print("姓名：");
            name = scanner.next();
            System.out.print("密碼：");
            password = scanner.next();

            atm.login(name, password);
            // atm.login("Jerry", "123456");
            count++;
            if (count >= maxCount) {
                break;
            }
            if (!atm.getloginSuccess()) {
                System.out.println("剩餘" + (maxCount - count) + "次機會");
            }
        } while (!atm.getloginSuccess());

        if (!atm.getloginSuccess()) {
            System.out.println("登入失敗" + maxCount + "次，鎖卡");
            scanner.close();
            return;
        }

        System.out.println("--------------------------------------");

        while (true) {
            System.out.println("(1)存款  (2)提款  (3)餘額  (4)離開");
            System.out.print("請選擇操作項目：");
            int choice = tools.Tool.getNextInt(scanner);
            if (choice == 4) {
                System.out.println("已登出！");
                break;
            }
            if (choice == 1) {
                System.out.print("請輸入存入金額：");
                int amount = tools.Tool.getNextInt(scanner);
                atm.despoit(amount);
            }
            if (choice == 2) {
                System.out.print("請輸入提出金額：");
                int amount = tools.Tool.getNextInt(scanner);
                atm.withdraw(amount);
            }
            if (choice == 3) {
                atm.getBalance();
            }
            System.out.println("----------------------------------");
        }

        System.out.println("--------------------------------------");
        // 測試例外：
        atm.despoit(-1000);
        atm.withdraw(1000);
        atm.withdraw(-500);
        atm.logout();
        atm.despoit(1000);
        atm.withdraw(500);

        scanner.close();
    }

}
