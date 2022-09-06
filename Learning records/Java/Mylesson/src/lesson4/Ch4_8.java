package lesson4;

public class Ch4_8 {
    public static void main(String[] args) {
        int cost = 123456;
        double discount = .851256677;
        double total = cost * discount;
        System.out.println(total);
        // 四捨五入 (%f)
        System.out.printf("%.0f%n", total);
        System.out.printf("%.2f%n", total);
        // 無條件捨去 (%d)
        System.out.printf("%d%n", (int) total);

        // 使用Math類別的方法
        System.out.println(total);
        // round() 為四捨五入
        System.out.println("===== 四捨五入 =====");
        System.out.println(Math.round(total)); // (放入double)
        int x1 = (int) Math.round(total); // long 型態 -> int 型態
        System.out.println(x1);
        // ceil() 為無條件進位
        System.out.println("===== 無條件進位 =====");
        System.out.println(Math.ceil(total)); // (放入double)
        int x2 = (int) Math.ceil(total); // double 型態 -> int 型態
        System.out.println(x2);
        // floor() 為無條件捨去
        System.out.println("===== 無條件捨去 =====");
        System.out.println(Math.floor(total)); // (放入double)
        int x3 = (int) Math.ceil(total); // double 型態 -> int 型態
        System.out.println(x3);

        System.out.println("=======================================================");
        cost = 39999;

        discount = 1.0f;

        if (cost >= 10000) {
            if (cost >= 100000) {
                discount = .75f; // 記得 float 要加上 f
            } else if (cost >= 50000) {
                discount = .85f;
            } else if (cost >= 30000) {
                discount = .9f;
            } else {
                discount = .95f;
            }
            if (discount % 10 == 0) {
                discount = discount / 10;
            }
            System.out.println("折扣後金額:" + cost * discount);
            System.out.println("四捨五入:" + Math.round(cost * discount));
            System.out.println("無條件進位:" + Math.ceil(cost * discount));
            System.out.println("無條件捨去:" + Math.floor(cost * discount));
            System.out.println("四捨五入至小數一位:" + Math.round(cost * discount * 10.0) / 10.0);
            int total_d = (int) Math.round(cost * discount); //////////////////
            System.out.printf("消費金額:%d 折扣:%d折 金額為:%d\n",
                    cost, (int) (discount * 100), total_d);
            // System.out.printf("消費金額:%d\t折扣:%d折\t金額為:%.0f\n",
            // cost, (int) (discount * 100), cost * discount);
        } else {
            System.out.printf("消費金額:%d(無折扣)\n", cost);
        }
        System.out.println("=======================================================");

        // 四捨五入到小數第五位
        System.out.println("===== 四捨五入到小數第五位 =====");
        System.out.println(total);
        // 注意乘法要加小數點(.0)調整為浮點數型態
        System.out.println(Math.round(total));
        System.out.println((double) Math.round(total));
        System.out.println(Math.round(total * 10.) / 10.);
        System.out.println(Math.round(total * 100000.) / 100000.);
        // 未來可以製成工具函式

    }
}
