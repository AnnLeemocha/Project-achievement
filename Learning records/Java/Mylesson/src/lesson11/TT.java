package lesson11;

public class TT {
    public static void main(String[] args) {

        int[] a = new int[3];

        try {
            System.out.println(a[a.length]); // 跳出，無抓到
            System.out.println(1 / 1);

        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("123"); // 皆會執行
        }
    }
}
