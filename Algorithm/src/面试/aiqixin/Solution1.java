package 面试.aiqixin;

import java.util.Arrays;

public class Solution1 {
    public int maxValue (int[][] matrix) {
        // write code here
        int[][] recode = new int[matrix.length][matrix[0].length];
        recode[0][0] = matrix[0][0];

        for (int i = 1; i < matrix.length; i++) {
            recode[i][0] = matrix[i][0] + recode[i-1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            recode[0][i] = matrix[0][i] + recode[0][i-1];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                recode[i][j] = matrix[i][j] + Math.max(recode[i - 1][j], recode[i][j - 1]);
            }
        }
        return recode[matrix.length-1][matrix[0].length-1];
    }

    public static void main(String[] args) {
        int[][] testcase = {
                {2, 3, 1},
                {2, 5, 3},
                {4, 2, 1}
        };

        Solution1 s = new Solution1();
        System.out.println(s.maxValue(testcase));
    }
}
