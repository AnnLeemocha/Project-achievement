package lesson7;

/**
 * length() 字串長度
 * charAt(index) 取單一字元
 * toCharArray() 取字元陣列
 * new String(char[]) 傳入字元陣列
 */
public class Ch7_1 {
    public static void main(String[] args) {
        String s1 = "Jerry";
        String s2 = new String("Jerry");
        String s3 = "Jerry";

        System.out.println(s1.equals(s2)); // 內部值相同
        System.out.println(s1 == s2); // 不同記憶體位址
        System.out.println(s1 == s3); // 找原本那一個位置的記憶體位置
        System.out.println("------------------------------");

        // 無法直接用 for 迴圈取

        // charAt(index) 取單一字元
        for (int i = 0; i < s1.length(); i++) { // 函式(方法) s1.length()
            System.out.print(s1.charAt(i) + " , ");
            // System.out.println(s1.charAt(i));
        }
        System.out.println();
        System.out.println("------------------------------");

        // toCharArray() 取字元陣列 + for
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) { // 屬性 chars.length
            System.out.print(chars[i] + " , ");
        }
        System.out.println();
        System.out.println("------------------------------");

        // toCharArray() 取字元陣列 + for each
        for (char c : chars) {
            System.out.print(c + " , ");
        }
        System.out.println();
        System.out.println("------------------------------");

        // new String(char[]) 傳入字元陣列
        String s4 = new String(chars);
        System.out.println(s4);
        System.out.println("------------------------------");

        //
    }
}
