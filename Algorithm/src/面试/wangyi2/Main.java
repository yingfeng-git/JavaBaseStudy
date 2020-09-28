package 面试.wangyi2;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] matrix = new int[N][N];
            int offset = 0;
            int data = 1;
            while (data <= N * N) {
                int x = offset;
                int y = offset;
                for (; y < N - offset; y++)  matrix[x][y] = data++;
                x++;
                for (; x < N - offset; x++) matrix[x][y - 1] = data++;
                y--;
                for (; y > offset; y--) matrix[x - 1][y - 1] = data++;
                x--;
                for (; x > offset + 1; x--) matrix[x - 1][y] = data++;
                offset++;
            }

            // 到这里就构建好矩阵
            for (int j = 0; j < M; j++) {
                System.out.println(matrix[in.nextInt()][in.nextInt()]);
            }
        }
    }
}