package lesson2;

public class Ch2_8 {
    public static void main(String[] args) {

        // 資料型別的轉換
        // 資料型別大小順序：byte➔short➔int➔float➔double
        // double number = input.nextFloat(); // 測試型態大小
        // (1) 自動轉換 (寬化轉型)
        System.out.println("(165 / 100)");
        System.out.println("直接使用整數運算(並不會轉成小數，直接捨去)：" + (165 / 100));
        System.out.println("(165. / 100)");
        System.out.println("自動轉成小數運算：" + (165. / 100));
        // (2) 強制轉換 (窄化轉型)
        // 注意窄化轉型的數值大小符合不符合轉化後的型態
        float x = 10.5f;
        double y = x;
        float z = (float) y;

        System.out.println(x + "  " + y + "  " + z);

        int a = (int) x;
        int b = (short) 32768;

        System.out.println(a + "  " + b);

    }
}
