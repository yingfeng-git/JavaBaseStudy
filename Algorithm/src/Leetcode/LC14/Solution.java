package Leetcode.LC14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int min = Integer.MAX_VALUE;
        int len = 0;
        for (String str : strs) {
            min = Math.min(str.length(), min);
        }

        boolean isMatch = true;
        for (int i = 0; i < min; i++) {
            char base = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != base){
                    isMatch = false;
                    break;
                }
            }
            if(!isMatch){
                break;
            }
            len++;
        }
        return len == 0? "": strs[0].substring(0, len);
    }

}
