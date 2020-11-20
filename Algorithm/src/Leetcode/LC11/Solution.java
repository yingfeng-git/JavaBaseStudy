package Leetcode.LC11;

// 盛水最多的容器
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int lowHeight = Math.min(height[l], height[r]);
            int res = lowHeight * (r - l);
            if(res > max) max = res;

            if (height[l] > height[r]) {
                while(height[r] <= lowHeight && l < r) r--;
            } else {
                while(height[l] <= lowHeight && l < r) l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] testcase = {2, 3, 4, 5, 18, 17, 6};
        Solution s = new Solution();
        System.out.println(s.maxArea(testcase));
    }
}
