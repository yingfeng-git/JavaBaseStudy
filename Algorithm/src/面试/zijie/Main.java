package 面试.zijie;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int serviceCount = in.nextInt();
        int taskCount = in.nextInt();
        int[] m = new int[serviceCount +1];
        int[][] testCase = new int[taskCount][2];
        for (int i = 0; i < testCase.length; i++) {
            testCase[i][0] = in.nextInt();
            testCase[i][1] = in.nextInt();
        }
        for (int i = 0; i < testCase.length; i++) {
            boolean alreadyPushTask = false;
            while(true) {
                for (int j = 1; j < m.length; j++) {
                    if (testCase[i][0] >= m[j]) {
                        m[j] = testCase[i][0] + testCase[i][1];
                        alreadyPushTask = true;
                        System.out.println(j);
                        break;
                    }
                }
                if (alreadyPushTask) break;
                testCase[i][0]++;
            }
        }
    }
}


/*
3 7  执行器

{2,8},
{3,4},
{4,3},
{6,1},
{7,1},
{8,3},
{10, 2}

1
2
3
2
3
2
1
*/
