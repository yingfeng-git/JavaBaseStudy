package JianZhi.JianZhi_14I;

public class Solution {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int max = 0;
        int[] record = new int[n+1];
        record[0] = 0;
        record[1] = 1;
        record[2] = 2;
        record[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int multi = record[j] * record[i - j];
                max = Math.max(multi, max);
//                System.out.printf("计算[%d]：%d, %d max:%d\n", i, j, i-j, max);
            }
            record[i] = max;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.cuttingRope(10));
    }
}
