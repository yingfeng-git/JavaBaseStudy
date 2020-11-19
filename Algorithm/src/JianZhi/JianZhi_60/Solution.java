package JianZhi.JianZhi_60;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int getCount(int n, int target){
        if (n == 1) return 1;
        int count = 0;
        for(int i = 1; i < 7; i++){
            int a = target - i;
            if (a > 0 && a < 7){
                count += getCount(n-1, a);
            }
        }
        return count;
    }
    public static double[] twoSum(int n) {
        if(n == 1) return new double[]{0.16666666666666666, 0.16666666666666666, 0.16666666666666666, 0.16666666666666666, 0.16666666666666666, 0.16666666666666666};
        double[] ans = new double[(n * 6) - 1];
        for(int i = 0; i < (n * 6) - 1; i++){
            ans[i] = getCount(n, n+i) / Math.pow(6, n);
        }
        HashMap<Integer, Integer> a = new HashMap<>();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(1)));
    }
}
