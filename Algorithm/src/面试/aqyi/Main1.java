package 面试.aqyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static int lengthOfLongestSubstring(String s) {
        int len = 0, maxLen = 0, pre = -1;
        int[] strArr = new int[255];
        Arrays.fill(strArr, -1);

        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, strArr[s.charAt(i)]);
            len = i - pre;
            maxLen = Math.max(maxLen, len);
            strArr[s.charAt(i)] = i;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.next());
        }
        System.out.println(lengthOfLongestSubstring(sb.toString()));
    }

}
