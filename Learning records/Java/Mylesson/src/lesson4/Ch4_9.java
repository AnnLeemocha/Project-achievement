package lesson4;

public class Ch4_9 {
    public static void main(String[] args) {
        int x = 30, y = 20;

        while (x > y) {
            System.out.println(x - y);
            // x -= 1;
            x -= y;
        }
        System.out.println("END...");
        System.out.println("--------------------------");

        // 1~10
        // for (知道迴圈次數的使用for)
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("--------------------------");

        // while (不確定迴圈次數或需要邏輯判斷的使用while)
        int ii = 0;
        while (ii < 10) {
            System.out.println(ii);
            ii++;
        }
    }
}
