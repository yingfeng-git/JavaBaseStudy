package 高频题;

import java.util.*;

public class MaxLengthSubStr {
    /**
     * 使用滑动窗口的方法来做
     * @param s 输入的字符串
     * @return 最长不重复字符串长度
     */
    public int lengthOfLongestSubstring(String s) {
        // write code here
        char[] arr = s.toCharArray();
        int[] recode = new int[128];
        int i = 0, j = 0;
        int max = 0;
        while(j < arr.length){
            if(recode[arr[j]] == 0){
                recode[arr[j++]] = 1;
            }else{
                max = Math.max(max, j - i);
                while(arr[i] != arr[j]){
                    recode[arr[i++]] = 0;
                }
                recode[arr[i++]] = 0;
            }
        }
        return Math.max(max, j - i);
    }

    public static void main(String[] args) {
        String testcase = "dvdf";
        MaxLengthSubStr m = new MaxLengthSubStr();
        System.out.println(m.lengthOfLongestSubstring(testcase));
    }
}
