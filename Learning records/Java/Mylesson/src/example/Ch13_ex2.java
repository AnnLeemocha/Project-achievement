package example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import example.example.Student;

/**
 * ■ 將Ch1_ex2.java 完成檔案輸出
 * _ ■ 輸入學生資料 (-1 離開)
 * __ ■ 姓名/身高/體重
 * __ ■ 進行bmi計算
 * __ ■ 使用FileWriter
 * __ ■ 輸出到檔案(student.txt)
 * 
 * 建立 Student.java --> 方便整合參數統一輸出
 * 直接寫入 OR 重新開啟寫入(V)
 */
public class Ch13_ex2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 建立專門裝 Student 類別的集合(容器) ---> 可變陣列大小
        ArrayList<Student> students = new ArrayList<Student>();

        System.out.println("請輸入學生資料，進行BMI計算。");

        while (true) {
            System.out.print("請輸入學生姓名(-1:exit)：");
            String name = scanner.next();
            // 迴圈結束
            if (name.equals("-1")) {
                System.out.println("結束輸入資料，共輸入" + students.size() + "筆資料");
                break;
            }
            Student student = new Student(name);
            System.out.printf("請輸入%s的身高(cm)：", name);
            student.setHeight(scanner.nextDouble());
            System.out.printf("請輸入%s的體重(kg)：", name);
            student.setWeight(scanner.nextDouble());
            student.setBMI();
            System.out.println("BMI：" + student.getBmi());
            // System.out.print(student);

            students.add(student);

            // 輸出到檔案 ---> 若在此迴圈中輸出檔案，將會不斷重新開啟檔案與關閉檔案
            // ______________ 此時必須用 fileWriter = new FileWriter(path, true); 來進行續寫
            // ______________ 若想要重新啟動一次程式並刪除舊檔存一個新檔案，則須另外處理(即先刪除檔案)
        }

        scanner.close();

        // 輸出到檔案 ---> 方便釐清邏輯，分開單獨處理檔案輸出，將會一次寫完後關閉檔案
        String path = "src/example/student.txt";
        FileWriter fileWriter = null;
        try {
            // 兩種方法看需求選擇使用
            fileWriter = new FileWriter(path, true);
            // fileWriter = new FileWriter(path);
            for (Student student : students) {
                fileWriter.write(student.toString());
            }
            System.out.println("檔案寫入完成！");
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
