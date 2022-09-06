package lesson12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
// import lesson13.Student;;

import lesson11.Student;

/**
 * 使用 ArrayList (動態)
 */
public class Ch12_2 {

    public static final String[] SUBJECTS = { "國文", "英文", "數學" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Student[] students = new Student[3];
        ArrayList<Student> students = new ArrayList<Student>();

        // for (int i = 0; i < students.length; i++) {
        int i = 0;
        while (true) {

            System.out.printf("請輸入第%d位姓名(-1:exit)：", i + 1);
            String name = scanner.next();
            if (name.equals("-1")) {
                break;
            }

            // // students[i] = new Student(name);
            // students.add(new Student(name));
            // 再優化
            Student student = new Student(name);

            double[] scores = new double[SUBJECTS.length];

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

            // // students[i].setScores(scores);
            // students.get(i).setScores(scores); // 再強制打開設定
            // 再優化
            student.setScores(scores);
            students.add(student);

            i++;
        }

        // for (Student student : students) {
        // System.out.println(student);
        // }

        // 靜態方法 (類別方法，類別唯一，只在父類產生，子類共用)
        // 用父類名稱取用
        // students.forEach(s -> System.out.println(s));
        students.forEach(s -> {
            System.out.println(s + " -> " + Student.getAvg(s));
            // System.out.println(Student.getAvg(s)); // 注意此為多行用法
        });

        // 一般方法 (每個子類都會產生一舫方法)
        for (Student student : students) {
            System.out.println(student.getName() + " 平均分：" +
                    Math.round(student.getAvg2()));
        }

        System.out.println("-------------------");

        // ArrayList的排序
        // 方法一 (正序)
        // (X) 沒那麼單純
        students.sort(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return (Student.getAvg(o1) == Student.getAvg(o2)) ? 0
                        : (Student.getAvg(o1) > Student.getAvg(o2)) ? 1 : -1;
            };
        });
        // 方法二 (進入 Student 類別中，覆寫) (反序)
        Collections.sort(students);

        // 格式化輸出：
        students.forEach(s -> {
            System.out.printf("%-45s  ->  平均分：%.2f\n",
                    s, Student.getAvg(s));
        });
        System.out.println("程式執行完畢!");
        scanner.close();

    }
}
