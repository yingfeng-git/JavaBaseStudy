package 面试.yuewen;

public class Solution3 {
    public static boolean isPalindrome(String str) {
        boolean res = true;
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                res = false;
            }
        }
//        System.out.println(str + " " + res);
        return res;
    }

    /**
     * @param str string字符串
     * @return int整型
     */
    public static int palindromeCount(String str) {
        // write code here
        int count = 0;
        for (int i = 1; i <= str.length(); i++) {
            int start = 0, end = i;
            while(end < str.length() + 1){
                if (isPalindrome(str.substring(start, end))) {
                    count++;
                }
                start++;
                end++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String a = "aabaa";
        System.out.println(a.length() + " " + palindromeCount(a));
    }
}
