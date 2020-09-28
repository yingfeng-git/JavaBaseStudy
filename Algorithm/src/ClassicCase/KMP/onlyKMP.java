package ClassicCase.KMP;


public class onlyKMP {
    /**
     * 先了解kmp算法的流程
     */
    public static void main(String[] args) {
        String s = "abcdabceaaaa";
        String match = "abceab";

        // 手推出来的next数组，kmp的难点就在与next数组的生成以及优化
        int[] next = {-1, 0, 0, 0, 0, 1};

        // 两个数组都从0开始
        int x=0, y=0;
        while(x < s.length() && y < match.length()){
            if(s.charAt(x) == match.charAt(y)){
                // 当两个数组的字符能匹配上，指针都往下一位走
                x++;
                y++;
            }else if(next[y] == -1){
                // 当y跳到0的位置的时候，也就是说明：
                // 以s字符串x位置开头的子串已经不可能匹配上，x往后挪一位
                x++;
            }else{
                // 当两个字符不匹配的时候，直接查next的数据，直接跳到y的下一个位置
                y = next[y];
            }
        }
        System.out.println(y == match.length());
    }
}
