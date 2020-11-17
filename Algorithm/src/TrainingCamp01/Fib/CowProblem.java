package TrainingCamp01.Fib;

public class CowProblem {
    public static int cowProblem(int years){
        if (years < 1) return 0;
        if (years < 4) return years;
        int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        int[][] res = powerMatrix(base, years - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }

    // 矩阵幂次方
    public static int[][] powerMatrix(int[][] matrix, int p) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            res[i][i] = 1;
        }
        int[][] temp = matrix;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) res = multiMatrix(res, temp);
            temp = multiMatrix(temp, temp);
        }
        return res;
    }

    // 矩阵乘法
    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cowProblem(20));
    }
}
