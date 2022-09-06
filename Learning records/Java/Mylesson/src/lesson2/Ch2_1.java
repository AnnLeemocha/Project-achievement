package lesson2;

public class Ch2_1 {
    public static void main(String[] args) {
        int x = 10;

        System.out.println("a = " + x);

        int y, z = 30;
        y = 20;
        System.out.println("b = " + y);
        System.out.println("c = " + z);
        System.out.println(x + "  + " + y + "  + " + z + "  = ");
        // 要括號起來表示為計算，要不然他會改變型態
        System.out.println("total：" + (x + y + z));
        System.out.println("a=" + x + " b=" + y + " c=" + z);
        System.out.println("total：" + (x + y + z));

        // 有意義的變數名稱 (變數取名法)
        // int coffeePrice = 70;
        // int coffee_price = 70;

        // byte, short, int, long
        byte a = 127; // 大於 127 就不能使用 byte
        short b = 32767; // 大於 32767 就不能使用 short
        int c = 2147483647; // 大於 2147483647 就不能使用 int
        long d = 9223372036854775807L; // 大於 9223372036854775807 就不能使用 long (預設為 int 型態， long 型態在小數點後後面要加上 "l" or "L")
        // int amount = 12_367_89l; // 方便閱讀可以加上"_"做區隔
        // sout 快捷鍵 System.out.println();
        // psvm 快捷鍵 public static void main(String[] args) {}

        // double, float
        double e = 10;
        float f = 10.0f; // (預設為 double 型態， float 型態在小數點後後面要加上 "f")

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}
