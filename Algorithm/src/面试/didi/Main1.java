package 面试.didi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            String m = in.next();
            if (m.length() <= 1 || num == 0 || num == 1){
                System.out.println(m);
            }else if(num >= m.length()){
                for (int i = m.length()-1; i >=0; i--) {
                    System.out.print(m.charAt(i));
                }
            }else {
                int p = 1;

                while (m.length() - (num * p) > 0) {
                    for (int i = (p * num) - 1; i >= (p - 1) * num; i--) {
                        System.out.print(m.charAt(i));
                    }
                    p++;
                }
                for (int i = (num * p - 1) - 1; i < m.length(); i++) {
                    System.out.print(m.charAt(i));
                }
            }
        }
    }
}
