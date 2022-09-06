package lesson13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
// import lesson13.Student;;

/**
 * 使用 ArrayList (動態)
 */
public class Ch13_8 {

    // 宣告成全域 (常數，集合，檔名)
    public static final String[] SUBJECTS = { "國文", "英文", "數學" };
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static final String FILE_NAME = "src/lesson13/student.txt";
    // public static final String FILE_NAME = "src/lesson13/student.csv";
    // 同為文字檔，可行(輸出)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList<Student> students = new ArrayList<Student>();

        int i = 0;
        while (true) {

            System.out.printf("請輸入第%d位姓名(-1:exit)：", i + 1);
            String name = scanner.next();
            if (name.equals("-1")) {
                break;
            }

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

            student.setScores(scores);
            students.add(student);

            i++;
        }

        students.forEach(s -> {
            System.out.println(s + " -> " + Student.getAvg(s));
        });

        for (Student student : students) {
            System.out.println(student.getName() + " 平均分：" +
                    Math.round(student.getAvg2()));
        }

        System.out.println("------------------------");

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
            System.out.printf("%-50s  ->  平均分：%.2f\n",
                    s, Student.getAvg(s));
        });
        System.out.println("程式執行完畢!");
        scanner.close();

        // 寫入檔案
        // (student.txt) [(student.csv 用逗號隔開)]
        // Jerry,100,77,88
        // Mary,66,77,55
        writeToFile();
    }

    public static void writeToFile() {
        FileWriter fileWriter = null;
        try {
            // fileWriter = new FileWriter(FILE_NAME, true);
            fileWriter = new FileWriter(FILE_NAME);
            System.out.println(fileWriter);

            for (Student s : students) {
                // String temp = String.format("%-10s -> 平均分：%.2f\n",
                // s.getName(), Student.getAvg(s));
                // fileWriter.write(temp);

                fileWriter.write(s.toString());
            }

            // // 注意可視範圍 (就算在寫一次try...catch，但還是有錯誤)
            // // 例外處理在函式中，可是範圍不夠大，外部的 try...catch 抓不到錯誤，無法處理，
            // // 越寫錯越多，且越亂
            // students.forEach(s -> {
            // String temp = String.format("%-10s -> 平均分：%.2f\n",
            // s.getName(), Student.getAvg(s));
            // try {
            // fileWriter.write(temp);
            // } catch (IOException e) {
            // e.printStackTrace();
            // }
            // });

            System.out.println("寫入成功！");

        } catch (IOException e) {
            System.out.println(e);

        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    System.out.println("檔案關閉");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

}
