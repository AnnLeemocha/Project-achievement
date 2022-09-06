package lesson5;

// import java.util.Arrays;
// import java.util.Random;
// import java.util.Scanner;

public class Ch5_8 {
    public static void main(String[] args) {
        // -------------------------------------------------------
        // 動態陣列長度：長度不確定的半自動式
        // 但後面每個空行數都要宣告成實體
        float[][] scores2 = new float[3][]; // 可通過，半自動式，先不給行數
        // float[][] scores3 = new float[][suject]; // 不可通過

        // [0,3]
        scores2[0] = new float[3];
        scores2[1] = new float[4];
        scores2[2] = new float[5];

        for (float[] fs : scores2) {
            for (float fs2 : fs) {
                System.out.print(fs2 + "\t");
            }
            System.out.println();
        }

    }
}
