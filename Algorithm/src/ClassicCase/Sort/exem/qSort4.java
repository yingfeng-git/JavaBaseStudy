package ClassicCase.Sort.exem;


import java.util.Arrays;

public class qSort4 {
    public static void qSort(int[] arr, int left, int right){
        if(left > right) return;
        int l = left, r = right;
        int temp = arr[left];

        while(l < r){
            while(arr[r] >= temp && l < r) r--;
            while(arr[l] <= temp && l < r) l++;
            if(l < r){
                swap(arr, l, r);
            }
        }
        swap(arr, left, r);
        qSort(arr, left, r - 1);
        qSort(arr,r + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {1,5,7,3,7,345,8,0,67,6,4,58,9,0};
        qSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
