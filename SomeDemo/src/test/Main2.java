package test;
import java.util.Scanner;

public class Main2 {
    static int maxSubString(String string){
        int n = string.length();
        int max = 0;
        int k = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (string.charAt(j) == string.charAt(i+j)){
                    k++;
                }else{
                    k=0;
                }
                if(k > max){
                    max = k;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String string = sb.toString();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                sb.append(in.next());
            }

            // 到这里已经把字符串给撸进来了
            // 下一步，找最长重复子串
            System.out.println(maxSubString(string));
        }
    }
}
