package JianZhi_4;

class Solution {
    // 先用二分法找到元素所在的行，再用二分法找所在的列
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int[] row: matrix){
            int l = 0, r = row.length;
            while(l <= r){
                int mid = (l + r) / 2;
                // System.out.println(row[mid] + " " + l + " " + r);
                if (mid > row.length - 1){
                    break;
                }else if (target == row[mid]){
                    return true;
                }else if (target < row[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int x = matrix[0].length - 1, y = 0;
        while (x >= 0 && y <= matrix.length - 1){
            System.out.println(matrix[y][x]);
            if (matrix[y][x] == target){
                return true;
            }else if (matrix[y][x] < target){
                y++;
            }else{
                x--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,   4,  7, 11, 15},
                     {2,   5,  8, 12, 19},
                     {3,   6,  9, 16, 22},
                     {10, 13, 14, 17, 24},
                     {18, 21, 23, 26, 30}};
        int[][] b = {{-1, 3}};

        System.out.println(s.findNumberIn2DArray2(b, 3));
    }
}
