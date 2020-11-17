package TrainingCamp01.Fib;

/**
 * 若存在 F3 = F1 + F2
 * 则 有 |F3 F2| = |F2 F1| * |2 * 2| (线代的结论)
 * 即    |FN FN-1| = |1 1| * |2 * 2|^N-2
 * Fibonacci => [[1 1] [1 0]
 */
public class Fibonacci {
    public static int FibCheck(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        return FibCheck(n - 1) + FibCheck(n - 2);
    }

    public static int Fib(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = powerMatrix(base, n - 2);
        // RETURN: 1 * res[0][0] + 1 * res[1][0]
        return res[0][0] + res[1][0];
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
        System.out.println(FibCheck(15));
        System.out.println(Fib(15));
    }
}
