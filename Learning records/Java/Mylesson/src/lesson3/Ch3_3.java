package lesson3;

public class Ch3_3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c = 0;

        b = a + 1;
        System.out.printf("a=%d\tb=%d\n", a, b);

        // 後置運算 (++a or --a) 先賦值後運算
        a = 10;
        b = 0;
        b = a++; // b=a a=a+1 (a=11 b=10) 先給值，後相加
        System.out.printf("a=%d\tb=%d\n", a, b);

        // 前置運算 (a++ or a--) 先運算後賦值
        a = 10;
        b = 0;
        b = ++a; // b=a+1 a=a+1 (a=11 b=11) 先相加，後給值
        System.out.printf("a=%d\tb=%d\n", a, b);

        //
        a = 10;
        b = 0;
        c = 5;
        int d = b++ + c++;

        System.out.println(d + " " + b + " " + c);

        //
        a = 10;
        b = 0;
        c = 5;
        d = (b++) + (++c);

        System.out.println(d + " " + b + " " + c);

        // 複合式指派 a+=運算式 == a=a+(運算式);

        a = 5;
        b = 1;
        a = a + (b = b - 5);
        System.out.println(a);
        a = 5;
        b = 1;
        a += b - 5;

        a = 10;
        b = 0;
        c = 5;

        //
        a -= 5; // a=a-5
        System.out.println(a);

        //
        b += a;
        System.out.println(b);

        //
        c += b -= a;
        System.out.println(c);

    }
}
