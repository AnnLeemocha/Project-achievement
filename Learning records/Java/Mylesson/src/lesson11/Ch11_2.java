package lesson11;

import java.util.Scanner;

public class Ch11_2 {

    public static final String[] SUBJECTS = { "國文", "英文", "數學" };

    public static void main(String[] args) {
        // // 先測試
        // Student student = new Student("Jerry");
        // // double[] scores = {1,2,3};
        // student.setScore(new double[] { 100, 90, 77 });
        // System.out.println(student);

        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            System.out.printf("請輸入第%d位姓名：", i + 1);
            String name = scanner.next();
            students[i] = new Student(name);

            double[] scores = new double[SUBJECTS.length];

            // 若輸入成字串
            // 1.使用例外處理
            // 2.是否能恢復輸入
            // try...catch 最好不要包迴圈，因只要 try 遇到錯誤就會跳至 catch ，不會執行 try 中後續內容
            // for (int j = 0; j < SUBJECTS.length; j++) {
            // (1)
            // System.out.printf("請輸入%s科分數：", SUBJECTS[j]);
            // try {
            // scores[j] = scanner.nextDouble();
            // } catch (java.util.InputMismatchException ex) {
            // j--;
            // scanner.next(); // 輸入錯誤後，吃進Enter後的空白
            // System.out.println(ex);
            // System.out.println("輸入錯誤！(請輸入數值)");
            // } // finally{}
            // }

            // (2)
            int j = 0;
            do {
                System.out.printf("請輸入%s科分數：", SUBJECTS[j]);
                try {
                    scores[j] = scanner.nextDouble();
                    j++;
                } catch (java.util.InputMismatchException ex) {
                    scanner.next(); // 輸入錯誤後，吃進Enter後的空白
                    System.out.println(ex);
                    System.out.println("輸入錯誤！(請輸入數值)");
                } // finally{}
            } while (j < SUBJECTS.length);

            students[i].setScores(scores);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();

    }
}
