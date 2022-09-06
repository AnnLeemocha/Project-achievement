package lesson8;

public class Ch8_2 {
    public static void main(String[] args) {
        TV tv1 = new TV();
        TV tv2 = new TV(10, 3);
        TV tv3 = null;

        // 記憶體位置
        // Stack --> 3
        // Heap ---> 2 (其一為空)
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
        System.out.println(tv1 == tv2);
        System.out.println(tv2 == tv3);
        System.out.println(tv1 == tv3);
        System.out.println("--------------------------");

        tv3 = tv1;
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
        // Stack --> 3
        // Heap ---> 2 (兩記憶體位置相等)
        System.out.println(tv1 == tv3);
        System.out.println("--------------------------");

        tv1 = tv2;
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
        // Stack --> 3
        // Heap ---> 2 (兩記憶體位置相等)
        System.out.println(tv1 == tv2);
        System.out.println(tv2 == tv3);
        System.out.println(tv1 == tv3);
        System.out.println("--------------------------");

        tv3 = tv2;
        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
        // Stack --> 3
        // Heap ---> 1 (三記憶體位置相等)
        System.out.println(tv1 == tv2);
        System.out.println(tv2 == tv3);
        System.out.println(tv1 == tv3);
    }
}
