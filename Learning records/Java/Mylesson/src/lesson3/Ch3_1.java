package lesson3;

public class Ch3_1 {
    public static void main(String[] args) {
        // float a=11;
        int a = 11;
        int b = 4;

        System.out.println(a / b);
        System.out.println((float) a / b);
        System.out.println(a % b);
        System.out.println(a % 2 == 0);
        System.out.println(a % 2 == 1);

        // && -> and (且)
        System.out.println(a % 2 == 0 && a % 2 == 1);

    }
}
