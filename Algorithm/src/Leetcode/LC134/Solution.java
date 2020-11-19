package Leetcode.LC134;

import java.util.Arrays;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] sub = new int[gas.length];
        for (int i = 0; i < sub.length; i++) {
            sub[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < gas.length; i++) {

        }
        return -1;
    }

    public int BadCanCompleteCircuit(int[] gas, int[] cost) {
//        if (gas.length == 0) return -1;
        int localGas = 0;
        int len = 0;

        int[] newGas = new int[gas.length * 2];
        int[] newCost = new int[cost.length * 2];
        int count = 0;
        for (int i = 0; i < newGas.length; i++) {
            if (i == gas.length) count = 0;
            newGas[i] = gas[count];
            newCost[i] = cost[count];
            count++;
        }

        for (int i = 0; i < gas.length; i++) {
            for (len = i; len < gas.length + i; len++) {
                localGas += newGas[len];
                if(localGas - newCost[len] < 0){
                    localGas = 0;
                    break;
                }
                localGas -= newCost[len];
                if(len - i == gas.length-1 && localGas >= 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}