package 面试.yuewen;

public class Solution2 {
    public int countBit (int n) {
        // write code here
        int count = 0;
        while(n != 0){
            n ^= (n & ((~n) + 1));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.countBit(15));
    }
}
