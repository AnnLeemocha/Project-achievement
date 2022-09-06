package lesson5;

public class Ch5_2 {
    public static void main(String[] args) {

        //// 矩陣宣告
        int[] num = new int[5]; // 初始值皆為 0
        // double[] num = new double[5]; // 初始值皆為 0.0
        // boolean[] num = new boolean[5]; // 初始值皆為 false
        // String[] num = new String[5]; // 初始值皆為 null

        System.out.println(num); // 矩陣記憶體位置
        System.out.println(num.length); // 矩陣大小(長度)
        System.out.println(num[0]); // 取值
        System.out.println(num[1]);
        System.out.println(num[2]);
        System.out.println(num[3]);
        System.out.println(num[4]);
        System.out.println(num[num.length - 1]); // 最後一個位置
        // System.out.println(num[5]); // 給 5 個位置，從 0 開始數

        System.out.println("----------------------------------");

        // 陣列修改
        num[0] = 100;
        num[num.length - 1] = 100;

        // 迴圈取值
        // (1)
        for (int i = 0; i < num.length; i++) {
            System.out.println((i + 1) + " = " + num[i]);
        }
        System.out.println("----------------------------------");
        // (2)
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
            System.out.println(num[i]);
        }
        System.out.println("----------------------------------");
        // (3)
        for (int i = 0; i < num.length; i++) {
            num[i] = (i + 1) * 2;
            System.out.print(num[i] + ", ");
        }

    }
}
