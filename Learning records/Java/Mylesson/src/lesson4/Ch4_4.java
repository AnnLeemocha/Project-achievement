package lesson4;

public class Ch4_4 {
    public static void main(String[] args) {

        // 10 次(固定)迴圈
        // for (int i = 1; i < 11; i++) {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            System.out.println("i = " + (i + 1));
        }
        System.out.println("---------------------");
        for (int i = 0; i < 10;) {
            System.out.println("i = " + i);
            i++;
        }
        System.out.println("---------------------");
        // 全域與區域變數
        // System.out.println("i = " + i); // 會報錯，因全域中無宣告
        int k = 0; // i 為全域變數，若需要特別記數需宣告在全域
        for (; k < 10; k++) { // 區域中的 i 以全域變數為主
            System.out.println("i = " + k);
            int i = k;
            System.out.println("i = " + i); // 區域變數
        }
        System.out.println("---------------------");
        System.out.println("i = " + k);
        // System.out.println("i = " + i); // 錯誤
        System.out.println("---------------------");

        // 無窮迴圈 (自己暫停)
        for (int i = 0;; i++) {
            System.out.println("i = " + i);
            if (i <= 1000) {
                break;
            }
        }
        System.out.println("---------------------");

        // 計數 0~100 累加的值
        int total = 0; // 放的位置要依邏輯決定
        for (int i = 0; i <= 100; i++) {
            total += i; // total = total +i
        }
        System.out.println("0~100(包含) 累加為：" + total);
        System.out.println("---------------------");

        // 兩個初始值
        int ii, jj, total2 = 0;
        // boolean count = true;
        // for (ii = 0, jj = 0; count && ii <= 100; ii++, jj += 2) {
        for (ii = 0, jj = 0; ii <= 100; ii++, jj += 2) {
            total2 += ii;
        }
        System.out.println(total2);
        System.out.println(ii + "," + jj);
        System.out.println("---------------------");

        // 計數 0~100 的偶數總和值
        // 方法 1 (較好)
        total = 0;
        for (int i = 0; i <= 100; i++) {
            // if(i%2!=0){ // 取奇數
            if (i % 2 == 0) { // 取偶數
                total += i; // total = total +i
            }
        }
        System.out.println("0~100(包含) 的偶數值累加為：" + total);
        System.out.println("---------------------");
        // 方法 2
        total = 0; // 放的位置要依邏輯決定
        for (int i = 0; i <= 100; i += 2) {
            total += i; // total = total +i
        }
        System.out.println("0~100(包含) 的偶數值累加為：" + total);
        System.out.println("---------------------");

    }
}
