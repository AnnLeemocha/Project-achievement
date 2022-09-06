package example;

import example.example.__Student;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * ■ 將Ch1_ex2.java 完成檔案輸出
 * _ ■ 輸入學生資料 (-1 離開)
 * __ ■ 姓名/身高/體重
 * __ ■ 進行bmi計算
 * __ ■ 使用FileWriter
 * __ ■ 輸出到檔案(student.txt)
 */
public class Ch13_ex2_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<__Student> studentList = new ArrayList<>();

        while (true) {
            System.out.print("隢撓?亙???-1:exit):");
            String name = scanner.next();
            if (name.equals("-1")) {
                break;
            }
            __Student st = new __Student(name);
            try {
                System.out.print("隢撓?亥澈擃?");
                st.height = scanner.nextDouble();
                System.out.print("隢撓?仿???");
                st.weight = scanner.nextDouble();
                double bmi = st.weight / ((st.height / 100) * (st.height / 100));
                DecimalFormat df = new DecimalFormat("##.00");
                bmi = Double.parseDouble(df.format(bmi));
                System.out.println("BMI " + bmi);
                st.setBMI(bmi);

                studentList.add(st);

            } catch (InputMismatchException ex) {
                ex.printStackTrace();
            }
        }

        FileWriter fw = null;
        System.out.println("?勗神??" + studentList.size() + "蝑???");
        try {
            fw = new FileWriter("/example/student.txt");
            for (__Student st : studentList) {
                StringBuffer sb = new StringBuffer(st.name + "\t");
                sb.append(st.height + "\t" + st.weight + "\t" + st.bmi + "\n");
                fw.write(sb.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("瑼?撖怠摰?!");

        scanner.close();
    }
}
