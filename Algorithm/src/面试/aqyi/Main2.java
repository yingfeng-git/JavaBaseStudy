package 面试.aqyi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> list = new HashMap<>();
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (list.containsKey(num)){
                list.put(num, list.get(num) + 1);
            }else{
                list.put(num, 1);
            }
        }

        int maxItem = 0;
        int maxCount = 0;
        for (Integer integer : list.keySet()) {
            if (list.get(integer) > maxCount){
                maxCount = list.get(integer);
                maxItem = integer;
            }
        }
        System.out.println(maxItem);

    }
}
