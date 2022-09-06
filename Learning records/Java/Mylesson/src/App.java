public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(args); // ？ 記憶體位置，外部傳入，參數傳遞，所以要從外部傳遞進來
        // Terminal >> src
        // Terminal >> javac App.java
        // Terminal >> java App 123
        // System.out.println(args[0]); // 123
        // Terminal >> javac App.java
        // Terminal >> java App 123 ABC
        // System.out.println(args[0]); // 123
        // System.out.println(args[1]); // ABC
        for (int i = 0; i < args.length; i++) {
            System.out.println("(" + (i + 1) + ") " + "args ： " + args[i]);
        }

        System.out.println("Hello, World!");
        System.out.println("Ann");
        System.out.println("160");
        System.out.println("XX，println 自己單獨一行");
        System.out.print("XX print 與下一行連成一行");
        System.out.println(""); // 與上行連成一行

        // 計算 BMI (BMI值計算公式: BMI = 體重(公斤) / 身高^2(公尺^2))
        // System.out.println("BMI： " + 58 / (165 / 100) ^ 2);
        // * 要轉成浮點數運算，要不然會以整數型態算出錯誤答案
        System.out.println("BMI： " + 58 / ((165 / 100) * (165 / 100)));
        // * 先算的數字後加上.0，就會做型態對齊，即可轉成浮點數
        System.out.println("BMI： " + 58 / ((165.0 / 100) * (165.0 / 100)));
        System.out.println("BMI： " + 58 / ((165 / 100.0) * (165 / 100.0)));

    }
}
