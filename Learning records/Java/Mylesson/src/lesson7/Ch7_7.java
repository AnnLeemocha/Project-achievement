package lesson7;

/**
 * 範例程式
 * ■ 撰寫一個函示arrayToString(int[] array)
 * ■ 傳入一整數陣列並回傳陣列格式(以字串方式回傳)
 * ■ 使用StringBuilder進行字串串接
 * 
 */

public class Ch7_7 {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6 };
        // double[] y = new double[]{ 1, 2, 3, 4, 5, 6 };
        String result = arrayToString(numbers);
        System.out.println(result);

        // 匿名陣列
        System.out.println(arrayToString(new double[] { 1, 2, 3, 4, 5, 6 }));

        // 偶數
        boolean even = true;
        int number = 10;
        // (1)
        if (even) {
            System.out.println("1");
        }
        // (2)
        if (number % 2 == 0) {
            even = true;
        } else {
            even = false;
        }
        // (3)
        even = number % 2 == 0; // 只能回傳 F/T
        System.out.println(even);
        // (4)
        even = number % 2 == 0 ? true : false;
        System.out.println(even);
        int result1 = number % 2 == 0 ? 1 : -1; // 給予的可能性更多
        System.out.println(result1);
        String result2 = number % 2 == 0 ? "是偶數" : "是奇數"; // 給予的可能性更多
        System.out.println(result2);
    }

    /**
     * int[] array={1,2,3,4,5}
     * 輸出 "{1,2,3,4,5}"
     * 用 StringBuilder 串接
     * 
     * @param array (int)
     * @return String
     */
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i] + " }");
                continue;
            }
            sb.append(array[i] + ", ");

            // if (i != array.length - 1) {
            // sb.append(array[i] + ", ");
            // } else {
            // sb.append(array[i] + " }");
            // }
        }
        return sb.toString();
        // for (int i : array) {
        // sb.append(array[i] + ", ");
        // }
        // sb=sb.lastIndexOf(sb.toString(), fromIndex)
        // return null; // 測試用
    }

    /**
     * double[] array={1,2,3,4,5}
     * 輸出 "{1.0,2.0,3.0,4.0,5.0}"
     * 用 StringBuilder 串接
     * 
     * @param array (int)
     * @return String
     */
    public static String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i] + " }");
                continue;
            }
            sb.append(array[i] + ", ");
        }
        return sb.toString();

    }
}
