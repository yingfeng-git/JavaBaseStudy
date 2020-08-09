package JianZhi_3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * 第一次的写法，先定义一个list的长度为输入的nums的长度，默认值是0
     * 遍历所有的元素，把该元素作为下标修改list的值，当第二次遍历到相同元素时
     * list中的值不为零则重复。
     */
    public int findRepeatNumber(int[] nums) {
        int[] list = new int[nums.length];
        for (int num : nums) {
            if (list[num] == 0) {
                list[num]++;
            }else{
                return num;
            }
        }
        return -1;
    }

    /**
     * 这种解法是用排序的思想。遍历元素时会把该元素放到以该元素为下标的位置。
     * 在交换的过程中，如果遇到要交换的元素与以该元素为下标的位置的元素相等，那么就出现重复，返回当前值。
     */
    public static int findRepeatNumber2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }else{
                    swap(nums, nums[i], nums[nums[i]]);
                }
            }
        }
        return 0;
    }

    public static void swap(int[] nums, int i, int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(a));
    }
}
