package JianZhi.JianZhi_10II;

import java.util.Arrays;

// 使用直接递归的方法，GG，超时。改动态规划
class Solution {
    public int numWays(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int res = numWays(n-2, dp) + numWays(n-1, dp);
        return res > 1000000007? res - 1000000007 : res;
    }
    public int numWays(int n, int[] dp) {
        if(dp[n] != -1) return dp[n];
        dp[n] = numWays(n-2, dp) + numWays(n-1, dp);
        dp[n] = dp[n] > 1000000007? dp[n] - 1000000007 : dp[n];
        return dp[n];
    }
}
