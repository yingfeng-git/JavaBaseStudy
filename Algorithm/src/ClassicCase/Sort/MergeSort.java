package ClassicCase.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

// 归并排序复习，这次加上使用泛型来实现
public class MergeSort {
    // TODO: 用泛型的方式来实现归并排序
//    public static <T> void Sort(T[] o, Comparator<? super T> comparator){
//
//    }

    /**
     * 使用递归的方式来做
     */
    public static void Sort(int[] a, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);

        Sort(a, l, mid);
        Sort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    public static void merge(int[] a, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) help[i++] = a[p1] <= a[p2] ? a[p1++] : a[p2++];
        while (p1 <= m) help[i++] = a[p1++];
        while (p2 <= r) help[i++] = a[p2++];

        for (i = 0; i < help.length; i++) {
            a[l+i] = help[i];
        }
    }

    private static boolean ResultCheck(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 4, 6, 8, 7, 6, 5, 2, 12, 31, 232, 1, 45};
        int[] cpa = Arrays.copyOf(a, a.length);

        MergeSort.Sort(a, 0, a.length - 1);
        Arrays.sort(cpa);
        if (!ResultCheck(a, cpa)) {
            System.out.println("Fucking!");
        }else {
            System.out.println("Pass~");
        }

    }
}
