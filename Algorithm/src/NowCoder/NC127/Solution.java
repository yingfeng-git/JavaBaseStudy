package NowCoder.NC127;


public class Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if(str1 == null || str2 == null) return "-1";
        // write code here
        int len = 0, end = -1;
        int[][] record = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    record[i][j] = record[i - 1][j - 1] + 1;
                    if (record[i][j] > len) {
                        len = record[i][j];
                        end = i;
                    }
                } else {
                    record[i][j] = 0;
                }
            }
        }
        if(len==0) return "-1";
        return str1.substring(end - len, end);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.LCS("1AB2345CD", "ttt"));
    }
}
