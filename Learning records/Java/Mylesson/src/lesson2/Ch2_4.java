package lesson2;

// 字串測試
public class Ch2_4 {
    public static void main(String[] args) {
        char x = 'A';// 單一引號，只能放一個字或數字
        System.out.println(x == 66); // (數字)直接比較

        String name1 = "Ann"; // 只要出現一次，就會存在字串詞中
        String name2 = "Ann"; // 會先看字串詞中存不存在，若存在則使用同一個
        String name3 = new String("Ann"); // 新增一個字串詞
        System.out.println(name1);

        // 物件中的 == 代表記憶體是否相等
        System.out.println(name1 == "Ann");
        System.out.println(name1 == name2);
        System.out.println(name1 == name3);
        // equals 判斷字元是否相等 (ex.比對使用者帳號...)
        System.out.println(name1.equals(name3));
        System.out.println(name1.equals(name2)); // 判斷原字串中的字元是否相等於指定字串中的字元

        System.out.println(name1.length()); // 取得字串的字元長度
        System.out.println(name1.toLowerCase()); // 轉換字串中的英文字元為小寫
        System.out.println(name1.toUpperCase()); // 轉換字串中的英文字元為大寫

        // 多行註解
        /**
         * 
         * 
         * 
         */

    }
}
