package tools;

/**
 * 自訂函式庫：
 * 所有好用程式統一控管
 * 只需要函式類別
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

// final public class Tool { // 適合放在 Tool
public class Tool {

    // 需改進：
    // 使用者輸入 --->
    // null , 報錯問題
    // scanner.next() != null
    // 眾數的查找 (Int)。 --->
    // 可加上輸出眾數索引位置 & 多眾數處理
    // 最大/小值的查找 --->
    // 可加上輸出最大/小值索引位置 & 多最大/小值數處理

    // 使用者輸入 ======================================================
    /**
     * 回應正確 "整數(Int)"。
     * 檢查輸入型態直至輸入正確。
     * 須由外部產生 Scanner。
     * 
     * @param scanner
     * @return int number
     */
    public static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("請輸入正確型態的數字(Int)：");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * 回應正確 "整數(Int)"。
     * 內部產生 Scanner ，並於內部關閉。
     * 
     * @return int number
     */
    public static int getNextIntOne() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("請輸入正確型態的數字：");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.close();
        return result;
    }

    /**
     * 回應正確 "浮點數(Double)"。
     * 檢查輸入型態直至輸入正確。
     * 須由外部產生 Scanner。
     * 
     * @param scanner
     * @return double number
     */
    public static double getNextDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("請輸入正確型態的數字(Double)：");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * 回應正確 "浮點數(Double)"。
     * 內部產生 Scanner ，並於內部關閉。
     * 
     * @return double number
     */
    public static double getNextDouble() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.println("請輸入正確型態的數字：");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.close();
        return result;
    }

    // 陣列處理 ======================================================

    /**
     * 完整複製陣列 (物件、陣列) (int)。
     * 兩陣列並非於同一記憶體位置下，
     * 更改其一另一者數值不會連動更改。
     * 
     * @param source
     * @return
     */
    public static int[] copy(int[] source) {
        int[] copy = new int[source.length];
        // for (int i = 0; i < source.length; i++) {
        // copy[i] = source[i];
        // }
        System.arraycopy(source, 0, copy, 0, source.length);
        return copy;
    }

    /**
     * 反轉陣列順序(Int)。
     * [1,2,3,4,5] --> [5,4,3,2,1]
     * 
     * @param source
     * @return reverse int array
     */
    public static int[] reverse(int[] source) {
        int[] copy = new int[source.length];
        int count = 0;
        for (int i = copy.length - 1; i >= 0; i--) {
            // copy[i - source.length + 1] = source[i];
            copy[count++] = source[i];
        }
        return copy;
    }

    // Mode Max Min ... ===================================================
    /**
     * 眾數的查找 (Int)。
     * (可加上輸出眾數索引位置 & 多眾數處理)
     * 
     * @param numbers
     * @return int mode[0] = mode count ; mode[1] = mode number
     */
    public static int[] grtRepeatNum(int[] numbers) {
        int count = 0, temp = 0;
        int modeNumber = 0, modeCount = 0;
        int[] mode = new int[2];
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
        }
        mode[0] = modeCount;
        mode[1] = modeNumber;
        System.out.printf("眾數 --> 次數為： %d ， 數值為： %d\n",
                mode[0], mode[1]);
        return mode;
    }

    /**
     * 最大值的查找
     * (可加上輸出最大/小值索引位置 & 多最大/小值數處理)
     * 
     * @param array
     * @return maximum number
     */
    public static double findMax(double... array) {
        double maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    /**
     * 最小值的查找
     * (可加上輸出最大/小值索引位置 & 多最大/小值數處理)
     * 
     * @param array
     * @return minimum number
     */
    public static double findMin(double... array) {
        double minValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    /**
     * 質數的查找
     * 
     * @param number
     * @return true -> 質數 / false -> 不是質數
     */
    public static boolean primeNumber(int number) {
        int count = 0;
        int half = (int) Math.round(number / 2. + 1);
        for (int i = 1; i < half; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count > 2 || count == 1) {
            System.out.println(number + " 不是質數");
            return false;
        } else if (count == 2) {
            System.out.println(number + " 是質數");
            return true;
        }
        return false;
    }

    // 檔案操作 ===================================================

    public static void getAllFiles(String path, ArrayList<File> fileList) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllFiles(f.getPath(), fileList);
                continue; // 不輸出目錄
            }
            // 傳址呼叫
            fileList.add(f);
        }
    }
}
