package example;

import java.io.*;

/**
 * ■ 請完成Ch13_ex1.java
 * _ ■ 程式主要功能，將test.html檔案，加上每行的行號
 * _ ■ 使用BufferedReader/BufferedWriter
 * _ ■ 輸出為test_line.html
 */
public class Ch13_ex1_1 {
    public static void main(String[] args) {
        BufferedReader fr = null;
        BufferedWriter fw = null;

        try {
            fr = new BufferedReader(new FileReader("test.html"));
            fw = new BufferedWriter(new FileWriter("test1.html"));
            String string = fr.readLine();
            int count = 0;
            while (string != null) {
                String str = count++ + " " + string + "\n";
                System.out.print(str);
                fw.write(str);
                string = fr.readLine();
            }

            System.out.println("鞈?撖怠摰?!");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.flush();
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("done!");
    }

}
