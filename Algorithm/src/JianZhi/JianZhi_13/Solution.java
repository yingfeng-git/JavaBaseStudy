package JianZhi.JianZhi_13;

public class Solution {
    public static boolean verify(int x, int y, int limit){
        int res = 0;
        while(x != 0){
            res += x % 10;
            x = x / 10;
        }
        while(y != 0){
            res += y % 10;
            y = y / 10;
        }
        return res <= limit;
    }

    public int movingCount(int m, int n, int k) {
        if(m == 0 || n == 0){
            return 0;
        }
        boolean[][] record = new boolean[m][n];
        return process(record, 0, 0, k);
    }

    public int process(boolean[][] record, int m, int n, int k){
        int res;
        if(m < 0 || n < 0 || m >= record.length || n >= record[0].length || record[m][n] || !verify(m, n, k)){
            return 0;
        }
        record[m][n] = true;
        res = 1 + process(record, m - 1, n, k)
                + process(record, m + 1, n, k)
                + process(record, m, n + 1, k)
                + process(record, m, n - 1, k);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(3, 1, 0));
    }
}
