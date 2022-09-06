package lesson5;

public class Ch5_3 {
    public static void main(String[] args) {
        String[] names = { "A", "B", "C", "D" };
        int[] scores = { 100, 99, 87, 77 };
        for (int i = 0; i < scores.length; i++) {
            // System.out.printf("names[%d] = %s\n", i, names[i]);
            System.out.printf("%s ： scores[%d] = %d\n",
                    names[i], i, scores[i]);
        }

        // 陣列宣告一
        int[] x = new int[5];
        System.out.println(x);

        // 陣列宣告二
        int[] y = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(y);

        // 陣列宣告三
        int[] z = { 1, 2, 3, 4, 5 };
        System.out.println(z);

    }
}
