package 面试.aqyi;

import java.util.*;

public class Main3 {

    public static List<List<Integer>> threeSum(List<Integer> list){
        list.sort(Integer::compareTo);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < list.size()-2; i++) {
            if (list.get(i) > 0) break;
            if (i > 0 && list.get(i) == list.get(i-1)) continue;
            int j = i + 1, k = list.size() - 1;
            while(j < k){
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum < 0){
                    while (j < k && list.get(j).equals(list.get(++j)));
                } else if (sum > 0){
                    while (j < k && list.get(k).equals(list.get(--k)));
                }else{
                    result.add(new LinkedList<>(Arrays.asList(list.get(i), list.get(j), list.get(k))));
                    while(j < k && list.get(j).equals(list.get(++j)));
                    while(j < k && list.get(k).equals(list.get(--k)));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNextInt()) {
            int num = in.nextInt();
            list.add(num);
        }
        List<List<Integer>> ans = threeSum(list);

        for (List<Integer> integerList : ans) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
