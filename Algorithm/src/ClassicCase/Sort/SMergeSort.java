package ClassicCase.Sort;

import ClassicCase.Sort.MyComparator.AgeComparator;
import ClassicCase.Sort.MyComparator.HeightComparator;
import ClassicCase.Sort.MyComparator.IdComparator;

import java.util.Arrays;
import java.util.Comparator;

public class SMergeSort {
    public static <T> void Sort(T[] a, int l, int r, Comparator<? super T> comparator) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        Sort(a, l, mid, comparator);
        Sort(a, mid + 1, r, comparator);
        merge(a, l, mid, r, comparator);
    }

    public static <T> void merge(T[] a, int l, int m, int r, Comparator<? super T> comparator) {
        T[] help = Arrays.copyOf(a, r - l + 1);
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r)
            help[i++] = comparator.compare(a[p1], a[p2]) <= 0 ? a[p1++] : a[p2++];
        while (p1 <= m) help[i++] = a[p1++];
        while (p2 <= r) help[i++] = a[p2++];
        for (i = 0; i < help.length; i++) {
            a[l+i] = help[i];
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(1, 5, 9),
                new Student(4, 2, 6),
                new Student(2, 4,4),
                new Student(5, 1,10),
                new Student(3, 3,5)
        };
        SMergeSort.Sort(students, 0, students.length-1, new HeightComparator());
        System.out.println(Arrays.toString(students));
    }
}
