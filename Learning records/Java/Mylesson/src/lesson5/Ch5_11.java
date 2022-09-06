package lesson5;

public class Ch5_11 {
    public static void main(String[] args) {
        // int [][][] x= new int[10][][];
        int[][] y = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(y.length);
        int[][][] x = {
                {
                        { 1, 2, 3 }, { 4, 5 }, {}, {}
                },
                {
                        { 11, 22, 33 }, { 44, 55, 66 }
                },
                {
                        { 666, 888 }
                }
        };
        System.out.println(x.length);
        System.out.println(x[0].length);
        System.out.println(x[1].length);
        System.out.println(x[0][0].length);
        System.out.println(x[0][1].length);
        System.out.println(x[0][1][1]);

        System.out.println("-----------------------");

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                for (int k = 0; k < x[i][j].length; k++) {
                    System.out.print(x[i][j][k] + " , ");
                }
                System.out.println();
            }
            System.out.println(i + 1);
        }

        System.out.println("-----------------------");
        for (int[][] is : x) {
            for (int[] is2 : is) {
                for (int is3 : is2) {
                    System.out.print(is3 + " , ");
                }
                System.out.println();
            }
            System.out.println("---");
        }

    }
}
