package 面试.yuewen;

import ClassicCase.Sort.QuickSort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Solution {
    public static class comp implements Comparator<book> {
        @Override
        public int compare(book o1, book o2) {
            int cal = o1.category - o2.category;
            if (cal == 0) {
                if (o1.updateTime.equals(o2.updateTime)) {
                    cal = o1.words - o2.words;
                    if (cal == 0) {
                        cal = o1.id - o2.id;
                    }
                    return cal;
                } else {
                    return o1.updateTime.after(o2.updateTime) ? 1 : -1;
                }
            } else {
                return cal;
            }
        }
    }

    public static class book {
        int id;
        int category;
        int words;
        Date updateTime;

        public book(int id, int category, int words, Date updateTime) {
            this.id = id;
            this.category = category;
            this.words = words;
            this.updateTime = updateTime;
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int num = 4;
        book[] books = new book[num];
        String[] msgs = {
                "61,20001,25919,2020-02-16 17:35:00",
                "63,20003,9914,2020-02-16 17:35:00",
                "62,20002,1982,2020-02-16 17:35:00",
                "64,20004,1693,2020-02-16 17:35:00"};
        for (int i = 0; i < num; i++) {
            String[] msg = msgs[i].split(",");
            books[i] = new book(
                    Integer.parseInt(msg[0]),
                    Integer.parseInt(msg[1]),
                    Integer.parseInt(msg[2]),
                    sdf.parse(msg[3]));
        }

        Arrays.sort(books, new comp());
        for (book book : books) {
            System.out.print(book.id + " ");
        }
        System.out.println();

        QuickSort<book> quickSort = new QuickSort<>();
        quickSort.recursive(books, new comp());
        for (book book : books) {
            System.out.print(book.id + " ");
        }
    }
/*
4
66,20002,25919,2020-02-16 17:35:00
63,20004,9914,2020-02-16 17:35:00
60,20001,1982,2020-02-16 17:35:00
68,20004,1693,2020-02-16 17:35:00
 */
}
