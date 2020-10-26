package ClassicCase.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Stack;

public class QuickSort<T> {
    // ==============================================
    public void qc(T[] arr, Comparator<T> comparator) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop(), low = stack.pop();
            if (low > high) continue;
            int l = low, r = high;
            T temp = arr[low];
            while (l < r) {
                while (comparator.compare(arr[r], temp) >= 0 && l < r) r--;
                while (comparator.compare(arr[l], temp) <= 0 && l < r) l++;
                if (l < r) {
                    swap(arr, l, r);
                }
            }
            swap(arr, low, r);
            stack.push(low);
            stack.push(r - 1);
            stack.push(r + 1);
            stack.push(high);
        }
    }



    // ==================  对T排序 ====================
    public void recursive(T[] arr, Comparator<T> comparator) {
        recursive(arr, 0, arr.length - 1, comparator);
    }

    private void recursive(T[] arr, int low, int high, Comparator<T> comparator) {
        if (low > high) return;
        int l = low, r = high;
        T temp = arr[low];
        while (l < r) {
            while (comparator.compare(arr[r], temp) >= 0 && l < r) r--;
            while (comparator.compare(arr[l], temp) <= 0 && l < r) l++;
            if (l < r) swap(arr, l, r);
        }
        swap(arr, low, l);
        recursive(arr, low, r - 1, comparator);
        recursive(arr, r + 1, high, comparator);
    }

    private void noRecursive(T[] arr, Comparator<T> comparator) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop(), low = stack.pop();
            if (low > high) continue;
            int l = low, r = high;
            T temp = arr[low];
            while (l < r) {
                while (comparator.compare(arr[r], temp) >= 0 && l < r) r--;
                while (comparator.compare(arr[l], temp) <= 0 && l < r) l++;
                if (l < r) swap(arr, l, r);
            }
            swap(arr, low, l);
            stack.push(low);
            stack.push(r - 1);
            stack.push(r + 1);
            stack.push(high);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // ==================  对int排序 ====================
    public void recursive(int[] arr) {
        recursive(arr, 0, arr.length - 1);
    }

    private void recursive(int[] arr, int low, int high) {
        if (low > high) return;
        int l = low, r = high;
        int temp = arr[low];
        while (l < r) {
            while (arr[r] >= temp && l < r) r--;
            while (arr[l] <= temp && l < r) l++;
            if (l < r) swap(arr, l, r);
        }
        swap(arr, low, l);
        recursive(arr, low, r - 1);
        recursive(arr, r + 1, high);
    }

    public void noRecursive(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop(), low = stack.pop();
            if (low > high) continue;
            int l = low, r = high;
            int temp = arr[low];
            while (l < r) {
                while (arr[r] >= temp && l < r) r--;
                while (arr[l] <= temp && l < r) l++;
                if (l < r) swap(arr, l, r);
            }
            swap(arr, low, l);
            stack.push(low);
            stack.push(r - 1);
            stack.push(r + 1);
            stack.push(high);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void testcase1() {
        Random random = new Random();
        int[] test = new int[Integer.MAX_VALUE >> 7];
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt();
        }
        System.out.println("start quick sort. target length:" + test.length);

        long start = System.currentTimeMillis();
        QuickSort<Integer> sort = new QuickSort<>();
        sort.noRecursive(test);
        System.out.println(System.currentTimeMillis() - start);
    }


    public static void testcase2() {
        class book {
            int id;

            public book(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "book{" + "id=" + id + '}';
            }
        }

        book[] books = {new book(3), new book(1), new book(2), new book(4), new book(5)};
        QuickSort<book> sort = new QuickSort<>();
        sort.qc(books, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return o1.id - o2.id;
            }
        });
        System.out.println(Arrays.toString(books));
    }

    public static void main(String[] args) {
        testcase2();
    }
}
