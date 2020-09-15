package 高频题;

public class upperBound {

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here

        int mid = 0, l = 0, r = n-1;
        while(l <= r){
            mid = (l+r) >> 1;
            if(a[mid] >= v){
                if (mid == 0 || a[mid-1] < v) return mid + 1;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return n + 1;

    }
    

    public static void main(String[] args) {
        upperBound u = new upperBound();
        int[] a = {1, 1, 2, 3, 7, 7, 7, 9, 9, 10};
        System.out.println(u.upper_bound_(10, 4, a));
    }
}
