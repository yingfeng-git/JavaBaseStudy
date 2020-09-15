package 面试.aqyi;

import java.util.*;
public class Main4 {

    public static List<List<Integer>> threeSum(List<Integer> list){
        list.sort(Integer::compareTo);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < list.size()-2; i++) {
            for (int j = i+1; j < list.size()-1; j++) {
                for (int k = j+1; k < list.size(); k++) {
                    if (list.get(i) + list.get(j) + list.get(k) == 0){
                        List<Integer> temp = new LinkedList<>();
                        temp.add(list.get(i));
                        temp.add(list.get(j));
                        temp.add(list.get(k));
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static boolean compArray(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNextInt()) {
            int num = in.nextInt();
            list.add(num);
        }
        List<List<Integer>> ans = threeSum(list);

        int[] a = new int[ans.get(0).size()];
        int[] b = new int[ans.get(0).size()];

        for (List<Integer> integerList : ans) {
            for (int i = 0; i < integerList.size(); i++) {
                a[i] = integerList.get(i);
            }

            if (!compArray(a, b)){
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i] + " ");
                    b[i] = a[i];
                }
            }
            System.out.println();
        }
    }
}

