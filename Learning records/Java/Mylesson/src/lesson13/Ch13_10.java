package lesson13;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ch13_10 {
    public static void main(String[] args) {

        String fileName = "D:/Desktop/機器與深度學習課程/JAVA/JavaProject/gradesystem/Student.csv";
        // String fileName = "src/lesson13/student.csv";
        File file = new File(fileName);
        FileReader fileReader = null;

        if (file.exists()) {
            try {
                // FileNotFoundException
                fileReader = new FileReader(fileName);
                char[] cbuf = new char[(int) file.length()];
                // IOException
                fileReader.read(cbuf);
                // System.out.println(cbuf);

                String str = new String(cbuf);
                // System.out.println(str);

                convertCsv(str);

            } catch (FileNotFoundException e) {
                // 但 IOException(父) 在 FileNotFoundException ，擇一即可，都要則需較大的放後面
                e.printStackTrace();
                System.out.println("檔案不存在");
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void convertCsv(String str) {
        // 強行轉檔問題，因最後有\n，多吃進一換行
        // 使用 str.trim() 清除資料頭尾的換行符號
        String[] datas = str.trim().split("\n");
        int count = 0;
        for (String data : datas) {
            if (count++ == 0) { // 先比對再+1，跳過第0列
                continue;
            }
            // // System.out.println(data.length());

            // if (data.length() == 16) {
            // continue;
            // // break;
            // }

            // System.out.println(data);
            // split 切割動作 (,)
            String[] student = data.split(",");
            // System.out.println(data.split(","));

            if (student.length == 1) {
                continue;
                // break;
            }

            String name = student[0];

            double total = 0;
            for (int i = 0 + 1; i < student.length; i++) {
                total += Double.valueOf(student[i]);
            }

            double avg = total / (student.length - 1);
            System.out.printf("%-10s total：%6.2f avg：%6.2f\n", name, total, avg);
        }
    }

    // public static void convertCsv(String str) {
    // // 強行轉檔問題，多吃進一換行
    // // str = str.replace(" ", "");
    // String[] datas = str.split("\n");
    // int skipLine = 1, count = 0;
    // String[] title = new String[skipLine];
    // for (String data : datas) {
    // if (count < skipLine) {
    // title[count] = data;
    // // System.out.println(title);
    // String[] titleName = title[count].split(",");
    // for (String t : titleName) {
    // System.out.print(t + " ");
    // }
    // System.out.println();
    // }
    // count++;
    // if (count > skipLine) {
    // // System.out.println(data);
    // // split 切割動作 (,)
    // String[] student = data.split(",");
    // // System.out.println(data.split(,"));
    // String name = student[0];

    // double total = 0;
    // for (int i = 0 + 1; i < student.length; i++) {
    // total += Double.valueOf(student[i]);
    // }

    // double avg = total / (student.length - 1);
    // System.out.printf("%-10s total：%6.2f avg：%6.2f\n", name, total, avg);
    // }
    // }
    // }
}
