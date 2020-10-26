package 面试.yuewen;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[][] matrix = new String[num][];
        in.nextLine();
        for (int i = 0; i < num; i++) {
            matrix[i] = in.nextLine().split(",");
        }
        String[] res = new String[matrix.length * matrix[0].length];
        int index = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                res[index++] = matrix[i][j];
            }
        }

        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.println(res[res.length-1]);
    }
    /*
    4
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16

     */
}
