package example;

import java.util.Arrays;

/**
 * ■ 眾數的查找
 * ■ 撰寫一個方法可以找出眾數的方法
 * ■ 可以傳入一維陣列
 * ■ 回傳最常出現的數字跟次數(陣列)
 * ■ int[] getRepeatNum(int[] numbers)
 */
public class Ch6_ex1 {
    public static void main(String[] args) {
        int[] numbers = { 10, -100, 10, 20, -100, 30, 20, -1, -1, 100, 10, 100, -1, -1, -1 };
        int[] result = grtRepeatNum(numbers);
        System.out.println("grtRepeatNum(numbers) Output --> " + Arrays.toString(result));
        System.out.println("==================");
        System.out.printf("眾數 --> 次數為： %d ， 數值為： %d\n",
                result[0], result[1]);

    }

    /**
     * 眾數的查找 (Int)
     * (可加上輸出眾數索引位置 & 多眾數處理)
     * 
     * @param numbers
     * @return
     */
    public static int[] grtRepeatNum(int... numbers) {
        int count = 0, temp = 0;
        int modeNumber = 0, modeCount = 0;
        int[] mode = new int[2];

        // System.out.printf("次數 ： 數值\n");
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            count = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (temp == numbers[j]) {
                    count++;
                }
            }
            // 最大眾數(次數與值)
            if (count > modeCount) {
                modeNumber = temp;
                modeCount = count;
            }
            // System.out.println(" " + count + " ： " + temp);
        }
        // System.out.println("==================");
        // System.out.println(" " + count + " ： " + temp);
        mode[0] = modeCount;
        mode[1] = modeNumber;
        System.out.printf("眾數 --> 次數為： %d ， 數值為： %d\n",
                mode[0], mode[1]);
        return mode;
    }

    // public static double findMax(double... array) {
    // double maxValue = array[0];
    // for (int i = 0; i < array.length; i++) {
    // if (array[i] > maxValue) {
    // maxValue = array[i];
    // }
    // }
    // return maxValue;
    // }
}
