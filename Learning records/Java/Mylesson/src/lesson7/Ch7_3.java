package lesson7;

public class Ch7_3 {
    public static void main(String[] args) {
        // 在字串中尋找str字串出現的位置，若找不到則傳回-1
        // ---> int indexOf(int ch)
        String email = "Mario@gmail.com";
        String tel = "0967676776";
        System.out.println(email.indexOf("M")); // 多載函式 ， (字元) 0 --> 第一個位置
        System.out.println(email.indexOf("Mario")); // (字串) 0 --> 第一個位置
        System.out.println(email.indexOf("o")); // 4 --> 第五個位置
        System.out.println(email.lastIndexOf("o")); // 13 --> 最後一筆，第十四個位置
        System.out.println("------------------------------");

        // 將傳入的str字串連接在後面 ---> concat(String str)
        String info = email + tel;
        System.out.println(info);
        info = email.concat(tel);
        System.out.println(info);
        System.out.println("------------------------------");

        // 若anObject為字串物件且內容與相等，則傳回true，否則就傳回false
        // ---> boolean equals(Object anObject)
        // 同上，但大小寫視為相同字元 大小寫(不管)比較
        // ---> boolean equalsIgnoreCase(Object anObject)
        // 如果字串為空字串則傳回true，否則傳回false
        // ---> boolean isEmpty()
        System.out.println("y".equals("Y"));
        System.out.println("y".equalsIgnoreCase("Y")); // 忽視大小寫
        // String xx = null;
        // System.out.println(xx.isEmpty());
        System.out.println("".isEmpty());
        System.out.println("------------------------------");

        // 將字串中出現oldChar字元，取代為newChar字元
        // ---> String replace(char oldChar,char newChar)
        email.replace("M", "m"); // 大寫 M 變小寫 m
        email.replace("Mario", "Jerry"); // 大寫 M 變小寫 m
        System.out.println(email.replace("Mario", "Jerry"));
        System.out.println(email);
        email = email.replace("Mario", "Jerry");
        System.out.println(email);
        System.out.println("------------------------------");

        // 傳回由beginIndex位置開始到字串結尾的子字串，即取字串某段 (多載)
        // ---> String substring(int beginIndex)
        // 傳回由beginInedx位置開始到endInedx位置的子字串
        // ---> String substring(int beginIndex, int endIndex)
        System.out.println(email.substring(5)); // 起始 5以後
        String name = email.substring(0, 5); // 0~5-1 區間
        System.out.println(name);
        System.out.println("------------------------------");

        // 兩端的空白字元移除 + 取代字元
        // String trim() + String replace(char oldChar,char newChar)
        String str1 = "     Mario@gmail.com     ";
        String str2 = "\n    Mario@gmail.com    \n";
        String str3 = "@    Mario@gmail.com    @";
        System.out.println("(1)");
        System.out.println(str1);
        System.out.println(str1.trim());
        System.out.println("(2)");
        System.out.println(str2);
        String result = str2.replace("\n", "").trim();
        System.out.println(result);
        result = str2.replace('\n', ' ').trim(); // (O) ' ' ; (X) ''
        System.out.println(result);
        System.out.println("(3)");
        System.out.println(str3);
        result = str3.replace("@", "").trim();
        System.out.println(result);
        System.out.println("------------------------------");

        // --------------------------------------------------------------
        // String toString() ---> 傳回字串本身
        // String toLowerCase() ---> 將字串中的英文字母全部轉為小寫後傳回
        // String toUpperCase() ---> 將字串中的英文字母全部轉為大寫後傳回
    }

}
