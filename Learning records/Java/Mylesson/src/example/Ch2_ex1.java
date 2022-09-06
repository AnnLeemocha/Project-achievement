package example;

/**
 * ■ 五年三班有三個學生，請設計程式可以連續輸入三個學生
 *   姓名跟成績，最後進行總分跟平均分計算。
 * ■ 平均分為欄寬3小數點兩位數
 */
import java.util.Scanner;

public class Ch2_ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name_1, name_2, name_3;

        System.out.println("請輸入資料");

        // 第一筆姓名&分數輸入：
        System.out.println("請輸入姓名"); // Jerry
        // String name_1 = input.next();
        while ((name_1 = input.nextLine()).equals(""))
            ;
        System.out.println("請輸入分數"); // 100
        float score_1 = input.nextFloat();

        // 第二筆姓名&分數輸入：
        System.out.println("請輸入姓名"); // Mary
        // String name_2 = input.next();
        while ((name_2 = input.nextLine()).equals(""))
            ;
        System.out.println("請輸入分數"); // 88
        float score_2 = input.nextFloat();

        // 第三筆姓名&分數輸入：
        System.out.println("請輸入姓名"); // Kevin
        // String name_3 = input.next();
        while ((name_3 = input.nextLine()).equals(""))
            ;
        System.out.println("請輸入分數"); // 77
        float score_3 = input.nextFloat();

        // 三筆分數總和：
        float sum_three = (score_1 + score_2 + score_3);

        // System.out.println("====================== 以下輸出 ======================");

        System.out.printf("%s\t%.0f\n%s\t%.0f\n%s\t%.0f\n",
                name_1, score_1, name_2, score_2, name_3, score_3);

        // 三筆分數平均：
        // Way (1) ->
        System.out.printf("三人總分為：%.0f 分\n三人平均為：%3.2f 分\n",
                sum_three, sum_three / 3); // 88.33
        // Way (2) ->
        // System.out.printf("三人總分為：%d\n三人平均為：%.2f\n",
        // (int) sum_three, sum_three / 3); // 88.33
        // Way (3) -> 與練習題中的答案一致
        // System.out.printf("三人總分為：%.0f\n三人平均為：%.2f\n",
        // sum_three, (float) ((int) (sum_three) / 3)); // 88.00

        // // 嘗試 //
        // // for (變數起始值；判斷式；變數遞增減值)
        // String[] nameAll = new String[3];
        // float[] scoreAll = new float[3];
        // float sum = 0f;

        // // for (int i = 0; i < args.length; i++) {
        // for (int i = 0; i < 3; i++) {
        // System.out.println("請輸入姓名");
        // nameAll[i] = input.next();
        // System.out.println("請輸入分數");
        // scoreAll[i] = input.nextFloat();

        // sum += scoreAll[i];
        // }
        // for (int i = 0; i < 3; i++) {
        // System.out.printf("%s\t%.0f\n", nameAll[i], scoreAll[i]);
        // }

        // System.out.printf("三人總分為：%.0f 分\n三人平均為：%3.2f 分\n",
        // sum, sum / 3); // 88.33

        input.close();

    }
}
