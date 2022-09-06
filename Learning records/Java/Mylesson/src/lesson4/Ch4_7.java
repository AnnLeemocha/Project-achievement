package lesson4;

public class Ch4_7 {
    public static void main(String[] args) {
        // 使用雙迴圈 (寫出9x9乘法表)
        System.out.println("九九乘法表：");
        // 方法 (一) & 顯示方式 (區隔)
        int ii = 1, jj = 1;
        int num = 0;
        for (; ii <= 9;) {
            for (; jj <= 9;) {
                num++;
                System.out.printf("%-2dx %-2d=%2d\n",
                        ii, jj, ii * jj);
                // System.out.printf("(%2d) %d x %d = %d\n",
                // num, ii, jj, ii * jj);
                // System.out.printf("(%-2d) %-2d x %-2d = %-2d\n",
                // num, ii, jj, ii * jj);
                jj++;
            }
            ii++;
            jj = 1;
            // 區隔
            System.out.println("------------------");
        }

        // 方法 (二) & 顯示方式 (橫向)
        // int num = 0;
        num = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // num = num + 1;
                // num += 1;
                num++;
                System.out.printf("(%-2d) %-2d x %-2d = %-2d | ",
                        num, i, j, i * j);

            }
            // 換行
            System.out.println();
        }
        System.out.printf("共執行 %d 次\n", num);

        // 方法 (三) & 顯示方式 (直向)
        // int num = 0;
        num = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // num = num + 1;
                // num += 1;
                num++;
                // System.out.printf("(%-2d) %-2d x %-2d = %-2d | ",
                // num, j, i, i * j); // i & j 對調
                System.out.printf("%-2d x %-2d = %-2d | ",
                        j, i, i * j); // i & j 對調

            }
            // 換行
            System.out.println();
        }
        // System.out.printf("共執行 %d 次\n", num);

    }

}
