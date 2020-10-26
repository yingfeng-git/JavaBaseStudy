package 面试.zijie;

public class Solution {
    public static void main(String[] args) {
        String str = "rgb(192, 192, 192)".replace(" ", "");
        String[] realStr = str.substring(4, str.length()-1).split(",");
        int res = 0;
        for (int i = 0; i < realStr.length; i++) {
            int num = Integer.parseInt(realStr[i]);
            res += num << (8 * (2-i));
        }
        System.out.println(res);
    }
}
