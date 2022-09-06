package practise;

/**
 *  請以String literal或一般建構 (new) 的方式設計二變數 s1、s2,接著使用「==」和「equals」比較,輸出以下三種情況:
 * _ 1. s1 == s2:true;s1 equals s2:true。
 * _ 2. s1 == s2:false;s1 equals s2:true。
 * _ 3. s1 == s2:false;s1 equals s2:false。
 */

public class Exercise_9_2號李旻恩 {
    public static void main(String[] args) {
        String s1, s2;

        System.out.println("-------- (1) --------");
        // 1. s1 == s2:true; s1 equals s2:true。
        s1 = "ABC";
        s2 = "ABC";
        System.out.println("s1 == s2     ： " + (s1 == s2));
        System.out.println("s1 equals s2 ： " + s1.equals(s2));

        System.out.println("-------- (2) --------");
        // 2. s1 == s2:false;s1 equals s2:true。
        s1 = "ABC";
        s2 = new String("ABC");
        System.out.println("s1 == s2     ： " + (s1 == s2));
        System.out.println("s1 equals s2 ： " + s1.equals(s2));

        System.out.println("-------- (3) --------");
        // 3. s1 == s2:false;s1 equals s2:false。
        s1 = "ABC";
        s2 = s1 + "ABC";
        System.out.println("s1 == s2     ： " + (s1 == s2));
        System.out.println("s1 equals s2 ： " + s1.equals(s2));

    }
}
