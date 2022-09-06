package lesson7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * wrapper(包裹類別)
 * Integer.valueOf("35") [String-->Integer]
 * Double.value("35.5") [String-->Double]
 * int
 */

public class Ch7_4 {
    public static void main(String[] args) {
        // 基礎資料型別
        // ---> 純粹的資料型態，除了自身資料之外，沒有其他方法可操作
        int x = 10;
        float y = 10.5f;
        // System.out.println(x.);
        System.out.println(x);
        System.out.println(y);

        // 包裹類別 (字首大寫)
        // ---> 使他們可以以物件的形式存在，攜帶更多的資訊並提供相對應的操作方法
        String z = "";
        // System.out.println(z.);
        System.out.println(z);

        // 使用包裹類別，進行輸入輸出型態轉換
        // [String-->Integer-->int]
        String ageStr = "17";
        System.out.println(ageStr + 1);
        int age = Integer.valueOf(ageStr); // (int) 整數包裹類別 Integer
        System.out.println(age + 1);

        Integer a = Integer.valueOf(ageStr);
        System.out.println(a + 1);
        System.out.println((double) a + 1);
        System.out.println(a.toString() + 1);

        // 輸出文字檔案
        System.out.println(a.toString());

        // 輸入流 (文字檔處理)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("請輸入姓名：");
            String name = br.readLine(); // 例外處理 IOException (可能發生檔案問題)

            // parse方法
            System.out.println("請輸入年齡：");
            int agebr = Integer.valueOf(br.readLine()); // 較直覺，回傳包裹型態，但可轉回基礎型態
            int _agebr = Integer.parseInt(br.readLine()); // 以基礎型態為主
            System.out.println(agebr);
            System.out.println(_agebr);
            double d2 = Float.parseFloat("123.3");
            System.out.println(d2);

            System.out.println("請輸入地址：");
            String address = br.readLine();

            System.out.println("請輸入身高：");
            double height = Double.valueOf(br.readLine());

            System.out.println("請輸入體重：");
            float weight = Float.valueOf(br.readLine());

            double bmi = weight / Math.pow(height / 100, 2);

            System.out.printf("姓名:%s  \t  BMI:%.2f\n", name, bmi);
            System.out.printf("地址:%s  \t  年齡:%d\n", address, agebr);

            br.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //
    }
}
