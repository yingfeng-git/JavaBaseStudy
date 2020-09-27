package 面试.wangyi;

import java.util.*;

public class testMain1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int people = in.nextInt();
        int[] score = new int[people + 1];
        int[] res = new int[people + 1];
        for(int i = 1; i < people + 1; i++){
            int count = 0;
            score[i] = in.nextInt();
            for(int j = 1; j < i; j++){
                if (score[i] < score[j]) {
                    res[j]++;
                }else if (score[i] > score[j]){
                    count++;
                }
            }
            res[i] = count;
        }
        int cases = in.nextInt();
        for(int i = 0; i < cases; i++){
            int who = in.nextInt();
            double result = (((double) res[who] - 1) * 100) / (double) people;
            System.out.printf("%.6f%n", result);
        }
    }
}
