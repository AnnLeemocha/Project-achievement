package lesson5;

import java.util.Arrays;

/**
 * 二維陣列
 */

public class Ch5_6 {
    public static void main(String[] args) {
        //// 一維
        // 一個同學，五科分數
        int[] scores = { 100, 88, 77, 66, 67 };
        System.out.println(scores.length);
        System.out.println(scores[0]);
        System.out.println(scores[scores.length - 1]);
        System.out.println("------------------------------------------");
        // 輸出全部矩陣值 (for)
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + ",\t");
        }
        System.out.println();
        // 輸出全部矩陣值 (依序：for each)
        for (int i : scores) {
            System.out.print(i + ",\t");
        }
        System.out.println();
        // 輸出全部矩陣值 (最簡單，好檢視)
        System.out.println(Arrays.toString(scores));
        // Ans： [100, 88, 77, 66, 67]
        System.out.println("=================================================");

        //// 二維
        // ■ 資料型態[][] 陣列名稱=new 資料型態[row][col];
        // ■ int[][] 陣列名稱 =new int[][]{{1,2,3},{4,5,6}};
        // ■ int[][] 陣列名稱={{1,2,3},{4,5,6}};
        // 三個同學，五科分數
        int[][] scores2 = { // 每列獨立，不固定大小
                { 87, 88, 77, 66 },
                { 77, 66, 55, 99, 95 },
                { 100, 99, 100, 100, 90, 66 }
        };
        // 一維輸出方式
        System.out.println(scores2.length); //
        System.out.println(scores2[0]);
        System.out.println(scores2[scores2.length - 1]);
        System.out.println("------------------------------------------");
        // 二維輸出方式
        System.out.println("row： " + scores2.length);
        System.out.println("col： " + scores2[scores2.length - 1].length);
        System.out.println(scores2[0][0]);
        System.out.println(scores2[2][1]); // 99
        // 取出最後一列最後一筆值
        // int[] lastRow = scores2[scores2.length - 1];
        // System.out.println(lastRow[lastRow.length - 1]);
        System.out.println(scores2[scores2.length - 1][scores2[scores2.length - 1].length - 1]);
        System.out.println("------------------------------------------");
        // 輸出全部矩陣值 (for)
        for (int i = 0; i < scores2.length; i++) {
            for (int j = 0; j < scores2[i].length; j++) { // 靈活自動取
                // 移除最後一個 ,
                if (j == scores2[i].length - 1) {
                    System.out.print(scores2[i][j] + "\n");
                } else {
                    System.out.print(scores2[i][j] + ",\t");
                }
            }
        }
        System.out.println();
        // 輸出全部矩陣值 (依序：for each)
        for (int[] score : scores2) {
            for (int s : score) {
                System.out.print(s + ",\t");
            }
            System.out.println();
        }
        System.out.println();
        // 輸出全部矩陣值 (最簡單，好檢視)
        for (int i = 0; i < scores2.length; i++) {
            System.out.println(Arrays.toString(scores2[i]));
        }
        // Ans： [87, 88, 77, 66]
        // Ans： [77, 66, 55, 99, 95]
        // Ans： [100, 99, 100, 100, 90, 66]

    }
}
