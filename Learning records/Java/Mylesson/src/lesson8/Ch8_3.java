package lesson8;

/**
 * 使用列存取物件
 */
public class Ch8_3 {
    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = new int[3];
        y[0] = 1;
        y[1] = 2;
        y[2] = 3;

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        for (int i : y) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("======================================================");

        TV_OPT[] samples = new TV_OPT[3];

        for (TV_OPT tv_OPT : samples) {
            System.out.println(tv_OPT); // 輸出初始 null
        }

        TV_OPT t1 = new TV_OPT(); // 只有他無開機程序
        TV_OPT t2 = new TV_OPT(10, 5);
        TV_OPT t3 = new TV_OPT(10, 5);
        TV_OPT t4 = null;
        TV_OPT t10 = new TV_OPT();
        t3.setBrand("Samsung");

        samples[0] = t1;
        samples[1] = t2;
        samples[2] = t3;

        for (TV_OPT tv_OPT : samples) {
            // System.out.println(tv_OPT);
            System.out.println(tv_OPT.getInfo());
        }

        System.out.println("-------------------------------");
        TV_OPT[] tvs = new TV_OPT[10];
        for (int i = 0; i < tvs.length; i++) {
            tvs[i] = new TV_OPT();
            tvs[i].setBrand("SAMSUNG");
            tvs[i].turnOn();
            tvs[i].setChannel(10);
            tvs[i].setVolume(2);
            tvs[i].turnOff();
        }

        for (TV_OPT tv_OPT : tvs) {
            System.out.println(tv_OPT.getInfo());
        }

        System.out.println("-------------------------------");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t10);

        // System.out.println(t1.count);
        // System.out.println(t2.count);
        // System.out.println(t3.count);
        // // System.out.println(t4.count); // 為 null
        // System.out.println(t10.count); // 10+4 =14
        // 使用物件名稱會出現警告
        System.out.println(TV_OPT.count); // 10+4 =14
        TV_OPT.count++;
        System.out.println(TV_OPT.count);
        // 避免被使用者更改私有
        // System.out.println(t10.getCounter());
        // 不應該用物件去取得電視產生的計數，會導致濫用記憶體 (一個物件存相同的東西)
        System.out.println(TV_OPT.getCounter());

        // 有 static
        add(10, 20);

        // 無 static
        Ch8_3 ch8 = new Ch8_3();
        ch8.add2(10, 20);
    }

    public static void add(int x, int y) {
        System.out.println(x + y);
    }

    public void add2(int x, int y) {
        System.out.println(x + y);
    }
}
