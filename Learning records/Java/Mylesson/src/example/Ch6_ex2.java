package example;

/**
 * ■ 最大值查找
 * ■ 撰寫一個findMax方法可以
 * ■ 傳入一維陣列
 * ■ 參數為int[] ,float[] ,char[]
 * ■ 將最大值進行回傳
 * ■ 函式進行多載
 */

public class Ch6_ex2 {
    public static void main(String[] args) {
        System.out.println(findMax(new int[] { 10, 20, 30, 40, 60 }));
        System.out.println(findMax(new double[] { 10, 20, 30, 40, 60 }));
        System.out.println(findMax(new float[] { 10, 20, 30, 40, 60 }));
        System.out.println(findMax(new char[] { 'A', 'B', 'C', 'D', 'E' }));
    }

    /**
     * 最大值的查找
     * (可加上輸出最大值索引位置)
     * 
     * @param array
     * @return 最大值
     */
    public static int findMax(int... array) {
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static float findMax(float... array) {
        float maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static double findMax(double... array) {
        double maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static char findMax(char... array) {
        char maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

}
