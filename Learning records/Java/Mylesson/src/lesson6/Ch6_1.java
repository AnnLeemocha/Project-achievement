package lesson6;

public class Ch6_1 {
    // [修飾子][static]<傳回值型別><method 名稱>(引數串列){
    // [程式區段;]
    // 區段
    // [return運算式;]
    // }
    // public static void main (String[] args)
    // public -> 全公開 |
    // static -> 靜態唯一
    // void -> 無回傳值 (免return)
    // String[] args -> 外部字串輸入賦予給變數 args

    // 進入點不能改 (標準寫法)
    public static void main(String[] args) {
        System.out.println(args);
        sum(10, 20);
        sum2(10, 20);
        sum3(10, 20);

    }

    // 宣告自己的方法 (函式) [與進入點並無順序之分]
    // static 才能拿到進入點用
    // 要輸出看到結果才有意義，要測試
    // [修飾子][static]<傳回值型別><method 名稱>(引數串列){
    // 只要是全公開(public)都可以呼叫到，記得 import lesson6.Ch6_1
    public static void sum(int x, int y) {
        int total = x + y;
        System.out.println("總計為：" + total);
    }

    // 不公開 (只在lesson6(package)可以使用)
    static void sum2(int x, int y) {
        int total = x + y;
        System.out.println("總計為：" + total);
    }

    // 全私有 (只在Ch6_1可以使用)
    private static void sum3(int x, int y) {
        int total = x + y;
        System.out.println("總計為：" + total);
    }

}
