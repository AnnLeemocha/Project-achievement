package lesson4;

/**
 * 標記+break：(破壞性強，盡少用到，除非遇到超多重迴圈)
 * Block1:{
 * ……
 * if(true){
 * break Block1;
 * }
 * ……
 * }
 */
public class Ch4_13 {
    public static void main(String[] args) {

        //// 多重迴圈 + break (標準寫法)
        int i = 0, j = 0, k = 0;
        boolean flag = false;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                for (k = 0; k < 10; k++) {
                    if (i == 5 && j == 5 && k == 5) {
                        flag = true;
                        break;
                    }
                    // if (i == 5 && j == 5 && k == 5) {
                    // break; // 只能跳出一個迴圈
                    // }
                }
                if (flag) {
                    break;
                }
                // if (i == 5 && j == 5 && k == 5) {
                // break; // 只能跳出一個迴圈
                // }
            }
            if (flag) {
                break;
            }
            // if (i == 5 && j == 5 && k == 5) {
            // break; // 只能跳出一個迴圈
            // }
        }
        System.out.printf("i=%d,j=%d,k=%d\n", i, j, k);

        // ====================================================================

        //// 多重迴圈 + 標記+break (破壞行強，請小心使用)
        Block1: {
            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {
                    for (k = 0; k < 10; k++) {
                        if (i == 5 && j == 5 && k == 5) {
                            break Block1;
                        }
                    }
                }
            }
        }
        System.out.printf("i=%d,j=%d,k=%d\n", i, j, k);

        // ====================================================================

        //// 標記+break 區域測試
        Block1: {
            Block2: {
                System.out.println("目前在 Block2 ");
                for (i = 0; i < 10; i++) {
                    System.out.println(i);
                    if (i == 5) {
                        break Block2;
                    }
                }
            }
            System.out.println("目前在 Block1 ");
            break Block1; // 防警告而寫
        }
        System.out.println("目前在 Block1 & Block2 外");

    }
}
