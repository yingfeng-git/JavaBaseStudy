package TrainingCamp01.DynamicProgramming;

/**
 * 跳马问题，棋盘大小 10*9(x * y)，马走日。
 * 从 (1, 1) 出发，到K点有多少种走法
 */
public class JumpHouse {
    public static int process(int start, int end, int K) {
        int[][][] record = new int[10][9][K + 1];
        record[0][0][0] = 1;
        for (int level = 1; level <= K; level++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    record[i][j][level] = getValue(i + 2, j + 1, level - 1, record) +
                                        getValue(i + 2, j - 1, level - 1, record) +
                                        getValue(i - 1, j + 2, level - 1, record) +
                                        getValue(i + 1, j + 2, level - 1, record) +
                                        getValue(i - 2, j - 1, level - 1, record) +
                                        getValue(i - 2, j + 1, level - 1, record) +
                                        getValue(i + 1, j - 2, level - 1, record) +
                                        getValue(i - 1, j - 2, level - 1, record);
                }
            }
        }
        return getValue(start, end, K, record);
    }

    public static int getValue(int x, int y, int K, int[][][] dp) {
        if (x < 0 || x > 9 || y < 0 || y > 8) return 0;
        return dp[x][y][K];
    }

    public static void main(String[] args) {
        System.out.println(process(6, 8, 10));
    }
}
