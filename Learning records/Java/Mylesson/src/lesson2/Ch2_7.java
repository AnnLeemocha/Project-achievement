package lesson2;

import java.util.Scanner;

public class Ch2_7 {
    public static void main(String[] args) {
        // String name = "Ann";
        // 會自動幫忙載入 java.util.Scanner ， 沒有就自動補上
        Scanner input1 = new Scanner(System.in);
        System.out.println("請輸入姓名：");

        // next (一定要讀取到有效字元後才可以結束輸入，跳過空格鍵、 Tab鍵或Enter鍵等結束符，只要有效字元) ,
        String name1 = input1.next();
        System.out.println("next()：" + name1); // Ann Lee 只取到 Ann

        // nextLine (一律接受，但Enter鍵直接結束)
        Scanner input2 = new Scanner(System.in);
        System.out.println("請輸入姓名：");
        String name2 = input2.nextLine();
        System.out.println("nextLine()：" + name2);

        //
        System.out.print("請輸入學號：");
        int id = input1.nextInt();
        System.out.print("請輸入分數：");
        double score = input1.nextDouble();

        System.out.println(name1 + "," + id + "," + score);
        System.out.printf("姓名：%s %n學號：%d %n分數：%.2f%n", name1, id, score);

        // 記得關閉螢幕輸入
        input1.close();
        input2.close();

    }
}
