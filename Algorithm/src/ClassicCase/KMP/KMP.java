package ClassicCase.KMP;

public class KMP {
    public static int[] getNextArray(String m){
        int[] next = new int[m.length()];
        // 根据match字符串推next数组
        // 第0和1个位置固定为-1和0
        next[0] = -1;
        next[1] = 0;
        // 从2开始
        int i = 2;
        int cn = 0;   // cn是啥？
        while (i < m.length()) {
            // 如果新加入的元素与前一个next下标+1的元素相等，那么直接等于前一个元素的下标+1
            if(m.charAt(i-1) == m.charAt(cn)) {
                next[i++] = ++cn;

            // 跳到比较的元素前一个的下标，然后在下一个循环再进行比较
            // [7]a] ... [7]x]  如果a == x，那么next[i] = cn+1
            }else if(cn > 0){
                cn = next[cn];

            // cn=0，跳到第一个，只能是往下面走重新从i++的位置开始计算
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }

    public static int indexOf(String s, String m){
        // 手推出来的next数组，kmp的难点就在与next数组的生成以及优化
        int[] next = getNextArray(m);
        // 两个数组都从0开始
        int x=0, y=0;
        while(x < s.length() && y < m.length()){
            if(s.charAt(x) == m.charAt(y)){
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
        return m.length() == y ? x - y: -1;
    }

    public static void main(String[] args) {
        String str = "acasdfaabcaabadasddfsff";
        String match =     "aabcaabd";
        System.out.println(indexOf(str, match));
    }
}
