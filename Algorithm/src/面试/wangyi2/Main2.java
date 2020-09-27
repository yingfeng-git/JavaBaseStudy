package 面试.wangyi2;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int N = 8;
        int[][] matrix = new int[N][N];

        int data = 1;
        for(int num = 0; num < N; num++) {
            int x = num, y = num;
            while(x < N && matrix[y][x] == 0){
                matrix[y][x] = data++;
                x++;
            }
            x--;
            y++;

            while(y < N && matrix[y][x] == 0){
                matrix[y][x] = data++;
                y++;
            }
            y--;
            x--;

            while(x >= 0 && matrix[y][x] == 0){
                matrix[y][x] = data++;
                x--;
            }
            x++;
            y++;

            while(y >= 0 && matrix[y][x] == 0){
                matrix[x][y] = data++;
                y--;
            }
            if(data > (N * N)){
                break;
            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
