package lesson5;

// import java.util.Arrays;
// import java.util.Random;
// import java.util.Scanner;

public class Ch5_9 {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // // System.out.println(Arrays.toString());
        // input.close();

        // 亂數
        // (1) 浮點亂數 --> Math.random()
        // ➔【回傳0~1之間的浮點數(不包含1)】
        // 產生0~1之間的浮點數亂數
        System.out.print("回傳 0~1之間(不包含1)：");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %.2f \t", Math.random());
        }
        System.out.println();
        // 轉換成整數
        // (int)(Math.random()*10) ➔回傳 0~10之間(不包含10)
        // (int)(Math.random()*10)+1➔回傳1~10之間(包含10)
        // (int)(Math.random()*(100-10+1))+10➔回傳10~100之間
        // (int)(Math.random()*(m-n+1))+n ➔回傳n~m之間（包含終止:m,起始:n)
        // 產生0~99之間的亂數
        System.out.print("回傳 0~100之間(不包含100)：");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %.2f \t", Math.random());
            System.out.print((int) (Math.random() * 100) + "\t");
        }
        System.out.println();
        // 產生10~50之間的亂數
        System.out.print("回傳 10~50之間(包含50)：");
        for (int i = 0; i < 5; i++) {
            System.out.print((int) (Math.random() * (50 - 10 + 1)) + 10 + " \t");
        }
        System.out.println();
        int start = 100;
        int end = 200;
        // 產生start~end(包含end)之間的亂數
        System.out.print("回傳 " + start + "~" + end + "之間(包含50)：");
        for (int i = 0; i < 5; i++) {
            System.out.print((int) (Math.random() * (end - start + 1)) + start + " \t");
        }
        System.out.println();

        // (2) 整數亂數 --> random.nextInt(N); (使用Random randInt方法)
        // ➔【取得0~(N-1)之間的亂數】
        // import java.util.Random;
        // Random random = new Random();
        // random.nextInt(N) ➔回傳0~N之間(不包含N)
        // random.nextInt(N)+1 ➔回傳1~N之間(包含N)
    }
}
