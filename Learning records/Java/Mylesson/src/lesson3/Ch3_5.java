package lesson3;

public class Ch3_5 {

    public static void main(String[] args) {

        int a = 10, b = 20, c = 30;

        //
        if (a < b && b < c) {
            System.out.println(c);
        }

        //
        if (a < b && !(b > c)) {
            System.out.println(c);
        }

        //
        if (a < b || b > c) {
            System.out.println(c);
        }

        //
        boolean x = false;
        if (!x) {
            System.out.println(c);
        }

        // && -> 短路模式(左邊為 false 則右邊不比對(執行))
        c = 30;
        if (a > b && ++c > b) {
            System.out.println(c);
        }
        System.out.println(c);

        //
        c = 30;
        if (a > b & ++c > b) {
            System.out.println(c);
        }
        System.out.println(c);

        // 用
        c = 30;
        if (a > b || ++c > b) {
            System.out.println(c);
        }

    }

}
