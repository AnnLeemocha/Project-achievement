package lesson2;

public class Ch2_3 {
    // psvm 快捷鍵 public static void main(String[] args) {}
    public static void main(String[] args) {
        String name = "Ann";
        char a = 'a';// 單一引號，只能放一個字或數字
        char b = 1;
        char c = 97; // ascii code 表查詢 'a'
        char d = '\n'; // (\n：換行) (\：跳脫字元)

        // sout 快捷鍵 System.out.println();
        System.out.println(name);
        System.out.println(a);
        System.out.println(b); // b = '1' 才會顯示東西
        System.out.println(c);
        System.out.println(d); // println 的ln自代換行 + \n 換行
        System.out.println(a + c); // 'A'->65 + 'a'->97 = 194
        System.out.println((int) a); // 強制轉型
        System.out.println(65 == a); // (數字)直接比較
        System.out.println((int) b); // 強制轉型

        boolean x = true;
        boolean y = false;
        System.out.println(x + "," + y);

        int n1 = 10;
        int n2 = 10;

        System.out.println(n1 == n2);

        System.out.println("=========================================================");

        // 跳脫字元：\
        // 輸入格式：
        // ABC
        // DEF
        // GHI
        System.out.println("輸出1： System.out.println(\"ABC\\nDEF\\nGHI\");");
        System.out.println("ABC\nDEF\nGHI");
        System.out.println("輸出2： System.out.print(\"ABC\\nDEF\\nGHI\\n\");");
        System.out.print("ABC\nDEF\nGHI\n");
        System.out.println("end...");
        System.out.println("abc\tdef\tghi"); // (\t：tab鍵，空四格)
        System.out.print("abc\tdef\tghi\n");

        // 單雙引號 ''：字元 ""：字串
        System.out.println("Ann \"come\" to Jerry");
        System.out.println("Ann 'come' to Jerry");
        System.out.println("Ann \'come\' to Jerry");
        System.out.println("Ann \\come\\ to Jerry");
        System.out.println("D:\\Desktop\\機器與深度學習課程\\JAVA\\ch1");

        System.out.println(65);
        System.out.println((int) 'A');
        System.out.println("\u0041"); // \\u加四個數字 -> 十六進制 (A)
        System.out.println("\101"); // \加三個數字 -> 八進制 (A)

        System.out.println(10); // 10 進制
        System.out.println(0b1010); // 2 進制
        System.out.println(0x000a); // 16 進制
        System.out.println(0012); // 8 進制
    }
}
