package lesson11;

public class Ch11_3 {

    public static void main(String[] args) {
        // System.out.println(div(10, 0));
        // System.out.println(div2(10, 0));

        // 涵式內決定處理

        // 涵式丟入 main 決定處理
        div(10, 0);
        try {
            div2(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("by zero error!");
        }
        System.out.println("done！");

        // main 丟到 JRE 決定處理
        int a = 10 / 0;
        System.out.println(a);
    }

    public static int div(int x, int y) {
        int result = 0;
        try {
            result = x / y;
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            System.out.println("數值錯誤！");
        }
        return result;
    }

    // 丟出例外
    public static int div2(int x, int y) throws ArithmeticException {
        int result = 0;
        result = x / y;
        return result;
    }

}