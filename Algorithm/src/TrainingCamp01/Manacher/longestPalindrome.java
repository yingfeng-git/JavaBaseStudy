package TrainingCamp01.Manacher;

import java.util.Arrays;

//LC5.求最长回文子串，用Manacher。代码写的很烂，思想表达完整。还可以优化
public class longestPalindrome {
    public static String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append('#');
        String str = sb.toString();
        System.out.println(Arrays.toString(str.toCharArray()));
        int[] record = new int[str.length()];
        int R = -1;
        int C = -1;
        for (int i = 0; i < str.length(); i++) {
            if(i > R){
                int left = i - record[i] - 1, right = i + record[i] + 1;
                while(left > -1 && right < str.length()){
                    if(str.charAt(left) == str.charAt(right)){
                        left--;
                        right++;
                        record[i]++;
                    }else{
                        break;
                    }
                }
                C = i;
                R = C + record[i];
            }else{
                int mirror = 2*C-i;
                if(record[mirror] + i < R){
                    // i + mirror 在R内
                    record[i] = record[mirror];
                }else if(record[mirror] + i == R){
                    // i + mirror 压线
                    // 从R+1开始扩
                    record[i] = record[mirror];
                    int right = R + 1, left = 2 * i - right;
                    while(left > -1 && right < str.length()){
                        if(str.charAt(left) == str.charAt(right)){
                            left--;
                            right++;
                            record[i]++;
                        }else{
                            break;
                        }
                        C = i;
                        R = C + record[i];
                    }
                }else {
                    // i + mirror 越线
                    record[i] = R - i;
                }
            }
        }
        int max = 0;
        int maxI = 0;
        for (int i = 0; i < record.length; i++) {
            if(record[i] > max){
                max = record[i];
                maxI = i;
            }
        }
        return str.substring(maxI-max, maxI+max+1).replace("#", "");
    }

    public static void main(String[] args) {
        String a = longestPalindrome("babac");
        System.out.println(a);
    }
}
