package ClassicCase.Sort.exem;

import java.util.Arrays;

public class qSort3 {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void qsort(int[] arr, int left, int right) {
        if (left > right) return;
        int l = left, r = right;
        int temp = arr[left];

        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            while (l < r && arr[l] <= temp) l++;
            if (l < r) {
                swap(arr, r, l);
            }
        }
        swap(arr, left, r);
        qsort(arr, left, r - 1);
        qsort(arr, r + 1, right);
    }

    public static void main(String[] args) {
        int[] test = {1,7,3,7,9,4,8,9,3,6,3,4,6,9,0};
        qsort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
