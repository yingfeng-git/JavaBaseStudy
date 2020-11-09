package ClassicCase.Sort.exem;

import java.util.Arrays;
import java.util.Comparator;

public class qSort2 {
    static class Person{
        int age;
        Person(int age){
            this.age = age;
        }

        @Override
        public String toString() {
            return "{" + age + '}';
        }
    }
    static class PersonComp implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o2.age - o1.age;
        }
    }

    public static <T> void qSort(T[] arr, int left, int right, Comparator<T> comparator){
        if (left > right) return;
        int l = left, r = right;
        T temp = arr[left];

        while(l < r){
            while(comparator.compare(temp, arr[r]) >= 0 && l < r) {
                r--;
            }
            while(comparator.compare(temp, arr[l]) <= 0 && l < r) {
                l++;
            }
            swap(arr, l, r);
        }
        swap(arr, left, r);
        qSort(arr, left, r - 1, comparator);
        qSort(arr, r + 1, right, comparator);
    }

    public static <T> void swap (T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Person[] testcases = {
                new Person(9),
                new Person(5),
                new Person(1),
                new Person(4),
                new Person(6),
                new Person(65),
                new Person(62),
                new Person(61),
                new Person(8),
                new Person(9),
                new Person(1),
                new Person(3),
                new Person(2),
                new Person(1),
        };

        qSort(testcases, 0, testcases.length - 1, new PersonComp());

        System.out.println(Arrays.toString(testcases));
    }
}
