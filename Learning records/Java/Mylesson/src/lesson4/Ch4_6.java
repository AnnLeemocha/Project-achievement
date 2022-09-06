package lesson4;

public class Ch4_6 {
    public static void main(String[] args) {

        // 雙迴圈的使用
        int num = 0;
        for (int i = 0; i < 10; i++) {
            // 外迴圈程式區段
            System.out.println("i = " + i);
            System.out.println("****************");
            for (int j = 0; j < 10; j++) {
                // 內迴圈程式區段
                System.out.println("j = " + j);
                num++;
                System.out.println("****************");
            }
        }
        System.out.printf("共執行 %d 次\n", num);
        // System.out.println("=======================================");

    }
}
