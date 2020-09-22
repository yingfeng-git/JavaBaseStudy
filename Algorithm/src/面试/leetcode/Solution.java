package 面试.leetcode;

import java.util.Arrays;

class Solution {
    public static int addNumb(int i){
        int ii = i;
        int res = 0;
        while(ii != 0){
            res += ii % 10;
            ii = ii /10;
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
        int[][] record = new int[m][n];
        int res = 0;

        for(int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                record[i][j] = addNumb(i) + addNumb(j);
            }
        }

        if (k < 9 && (m < 9 || n < 9)){
            m = Math.min(m, 9);
            n = Math.min(n, 9);

        }
        for (int i = 0; i < m-1; i++) {
            for (int i1 = 0; i1 < n-1; i1++) {
                if (record[i][i1]<=k) res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(16, 16, 6));
    }
}