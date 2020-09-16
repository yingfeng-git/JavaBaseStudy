package 面试.xiaomi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()){
            sb.append(in.next());
            if(in.hasNext()) sb.append(' ');
        }

        char[] cache = new char[65535];
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if(cache[s.charAt(i)] == 0){
                cache[s.charAt(i)] = 1;
                System.out.print(s.charAt(i));
            }
        }

    }
}
