package 高频题;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, maxLen = 0, pre = -1;

        int[] strArr = new int[255];  // 用来记录字符出现的位置，全部默认填充-1
        Arrays.fill(strArr, -1);

        /*
         * 核心的思想是找到每一个元素往左推的最大长度。
         * 用pre来记录当前不重复子串的最左边元素下标，strArr记录元素上次出现的位置
         * 找到了两个位置之后就可以得出长度
         */
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, strArr[s.charAt(i)]); // 左边的位置与元素上次出现的位置比较
            len = i - pre;                            // 当前位置 - 上次位置 = 长度
            maxLen = Math.max(maxLen, len);           // 找最大的长度
            strArr[s.charAt(i)] = i;                  // 把当前元素的位置更新到数组中

        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
