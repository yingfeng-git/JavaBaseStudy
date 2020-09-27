package 面试.wangyi2;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int c = 0; c < cases; c++){
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] matrix = new int[N][N];
            int data = 1;

            for(int i = 0; i < N; i++){
                // 往右走
                for(int j = i; j < N; j++){
                    matrix[i][j] = data++;
                }
            }
        }


    }
}