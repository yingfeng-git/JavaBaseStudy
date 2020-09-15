package 面试.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int group = in.nextInt(); // 组数
            for (int i = 0; i < group; i++) {
                int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

                if (m == 1){
                    System.out.println("Yes");
                }else {
                    Set<Integer> s = new HashSet<>();
                    for (int i1 = 0; i1 < m; i1++) {
                        int iron1 = in.nextInt(), iron2 = in.nextInt(), money = in.nextInt();
                        if (money < k) {
                            s.add(iron1);
                            s.add(iron2);
                        }
                    }
                    if (s.size() == n) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
