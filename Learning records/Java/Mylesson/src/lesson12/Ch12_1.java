package lesson12;

import java.util.ArrayList;
import java.util.Arrays;

public class Ch12_1 {
    public static void main(String[] args) {
        String[] names = new String[3]; // 修改矩陣大小
        names[0] = "Jerry";
        names[1] = "Kevin";
        names[2] = "Mary";

        System.out.println(Arrays.toString(names));
        System.out.println(names[2]);

        for (String string : names) {
            System.out.println(string);
        }

        System.out.println("=============================");

        // // 想要動態用法 (增加長度跟刪除)
        // ArrayList nameList = new ArrayList();
        // nameList.add("Jerry");
        // nameList.add("Kevin");
        // nameList.add("Mary");

        // System.out.println(nameList);
        // System.out.println(nameList.get(2));

        // // nameList 為 Object 類型 ，需向下轉型至 String (耗時耗記憶體)
        // String name = (String) nameList.get(2);

        System.out.println("=============================");

        // // 想要動態用法 (增加長度跟刪除)
        // 若不宣告泛型，太過耗時耗記憶體耗力，警告一值存在
        // 注意！必須為物件型態，不可用一般型態
        // ArrayList<資料型態>=new ArrayList<資料型態>();
        ArrayList<String> nameList2 = new ArrayList<String>();
        // 動態增加
        nameList2.add("Jerry");
        nameList2.add("Kevin");
        nameList2.add("Mary");
        nameList2.add("David");
        nameList2.add("Tony");

        String name = (String) nameList2.get(2);

        System.out.println(nameList2);
        System.out.println(name + " " + nameList2.get(2));
        System.out.println(nameList2.get(nameList2.size() - 1));
        System.out.println(nameList2.size());

        // ■ 加入元素 add(object o)
        // ■ 陣列大小 size()
        // ■ 取得資料 get(int index)
        // ■ 是否包含 contains(object o)
        // ■ 是否為空 isEmpty()
        // ■ 修改資料 set(int index,object o)
        // ■ 查詢索引位置 indexOf(Object o)
        // ■ 刪除資料 remove(Object o) or remove(int index)

        System.out.println(nameList2.isEmpty());
        nameList2.set(0, "JERRY");
        // System.out.println(nameList2.set(0, "JERRY"));
        System.out.println(nameList2.indexOf("Jerry"));
        nameList2.remove(1);
        nameList2.remove("Tony");

        System.out.println(nameList2 + "\n" + nameList2.size());

        System.out.println("-------------------");
        // 需要位置的
        for (int i = 0; i < nameList2.size(); i++) {
            System.out.println(nameList2.get(i));
        }

        System.out.println("-------------------");
        // 不需要位置的
        for (String string : nameList2) {
            string = "Mr." + string;
            System.out.println(string);
        }

        System.out.println("-------------------");
        // 注意在函式內部
        // ->：是forEach的基本格式
        // 單行輸出
        nameList2.forEach(n -> System.out.println(n));

        System.out.println("-------------------");
        // 注意在函式內部
        // 不需要位置的
        // 多行輸出
        nameList2.forEach(n -> {
            n = "Mr." + n;
            System.out.println(n);
        });
    }
}
