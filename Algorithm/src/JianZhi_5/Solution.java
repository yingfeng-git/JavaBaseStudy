package JianZhi_5;

class Solution {
    // 不使用String内置的replace方法
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c: s.toCharArray()){
            if (c == ' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "solution a";

        System.out.println(s.replaceSpace(str));
    }
}
