package 面试.xc;

import java.util.*;

public class Main {
    static int[] divingBoard(int a, int b, int k) {
        if (k == 0) return new int[0];
        Set<Integer> integerSet = new TreeSet<>();
        for (int i = 0; i < k + 1; i++) {
            System.out.println(a * i + " " + b * (k - i));
            integerSet.add(a * i + b * (k - i));
        }
        int[] result = new int[integerSet.size()];
        Iterator<Integer> iterator = integerSet.iterator();
        for (int i = 0; i < integerSet.size(); i++) {
            result[i] = iterator.next();
        }

        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = divingBoard(_a, _b, _k);
        String value = "[]";
        if (res != null && res.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                if (i == 0) {
                    stringBuilder.append("[");
                }
                stringBuilder.append(res[i]);
                if (i == res.length - 1) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(",");
                }
            }
            value = stringBuilder.toString();
        }
        System.out.println(value);
    }
}