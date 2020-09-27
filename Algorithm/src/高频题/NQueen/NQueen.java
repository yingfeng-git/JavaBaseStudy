package 高频题.NQueen;

/**
 * @author yingfeng
 */
public class NQueen {
    /**
     * 暴力递归求解N皇后问题，题目要求不超过4秒，n <= 14。但此解法在跑n = 14时会超时。需要用位运算来做优化
     * @param n nxn的棋盘上要放n个皇后
     * @return 摆法
     */
    public static int count(int n){
        if (n == 0) {
            return 0;
        }
        // 第i行，第recode[i]列 放置了皇后
        int[] recode = new int[n];
        return process(recode, 0, n);
    }

    /**
     * 第i行的皇后放在第j列是否合理？
     * @param recode 已经摆放的皇后的位置
     * @param i 现在要摆的皇后的行
     * @param j 现在要摆的皇后的列
     * @return 摆放是否合理
     */
    public static boolean isVerify(int[] recode, int i, int j){
        for (int k = 0; k < i; k++) {
            if(recode[k] == j || Math.abs(k - i) - Math.abs(recode[k] - j) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归计算N皇后问题
     * @param recode 皇后摆放记录
     * @param i 第i行
     * @param n 列数
     * @return 摆放的可能性
     */
    public static int process(int[] recode, int i, int n){
        if(i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            // 现在来到了第i行了，皇后放在第j列
            if(isVerify(recode, i, j)){
                recode[i] = j;
                res += process(recode, i + 1, n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count(14));
    }
}
