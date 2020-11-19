package ClassicCase.Sort.exem;

import java.util.Arrays;

public class qSort5 {
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) return;
        int l = left, r = right;
        int temp = arr[left];
        while (l < r) {
            while (l < r && arr[r] >= temp) r--;
            while (l < r && arr[l] <= temp) l++;
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, left, r);
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {6, 4, 6, 4, 3, 5, 7, 9, 4, 555, 7, 9, 5, 3, 3, 6, 777, 98};
        quickSort(test, 0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
