package 面试.wangyi2;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int N = 5;
        int[][] matrix = new int[N][N];
        int offset = 0;
        int data = 1;
        while (data <= N * N) {
            int x = offset;
            int y = offset;
            for (; y < N - offset; y++) {
                matrix[x][y] = data++;
            }

            x++;
            for (; x < N - offset; x++) {
                matrix[x][y - 1] = data++;
            }

            y--;
            for (; y > offset; y--) {
                matrix[x - 1][y - 1] = data++;
            }

            x--;
            for (; x > offset + 1; x--) {
                matrix[x - 1][y] = data++;
            }
            offset++;
        }

        for (int[] re : matrix) {
            System.out.println(Arrays.toString(re));
        }
    }
}
