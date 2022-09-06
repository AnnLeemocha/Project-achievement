package lesson13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ch13_9 {
    public static void main(String[] args) {

        String str = "ANN,99.0,99.0,99.0\nJERRY,100.0,90.0,80.0";
        // split 切割動作 (\n)
        String[] datas = str.split("\n");
        // 不只會切出一份，所以要用陣列
        System.out.println(datas);
        // 使用 debug 模式確認資料，String[2]真為2個

        for (String data : datas) {
            // split 切割動作 (,)
            String[] student = data.split(",");
            // System.out.println(data.split(,"));
            String name = student[0];
            double[] scores = new double[3];
            double total = 0;
            for (int i = 0 + 1; i < student.length; i++) {
                scores[i] = Double.valueOf(student[i]);
                total += scores[i];
            }

            double avg = total / (student.length - 1);
            System.out.printf("%-10s total：%6.2f   avg：%6.2f\n", name, total, avg);

        }

        System.out.println("---------------------------------");

        String fileName = "src/lesson13/student.txt";

        if (new File(fileName).exists()) {
            readToFile(fileName);
        }

    }

    // 檔案讀取
    public static void readToFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            char[] cbuf = new char[(int) new File(fileName).length()];
            try {
                fileReader.read(cbuf);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(cbuf);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("檔案不存在");
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
