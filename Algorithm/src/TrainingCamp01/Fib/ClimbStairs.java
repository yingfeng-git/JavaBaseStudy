package TrainingCamp01.Fib;

public class ClimbStairs {
    public static int climbStairs(int i) {
        if (i < 1) return 0;
        if (i == 1 || i == 2) return i;
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = powerMatrix(base, i - 2);
        // RETURN: 2 * res[0][0] + 1 * res[1][0]
        return 2 * res[0][0] + res[1][0];
    }

    // 矩阵幂
    public static int[][] powerMatrix(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) res = multiMatrix(res, tmp);
            tmp = multiMatrix(tmp, tmp);
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
        System.out.println(climbStairs(20));
    }
}
