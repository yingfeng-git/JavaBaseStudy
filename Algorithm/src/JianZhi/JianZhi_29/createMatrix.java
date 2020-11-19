package JianZhi.JianZhi_29;

public class createMatrix {
    public int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0,  t = 0;
        int r = n - 1, b = n - 1;
        int numb = 1;
        while(true) {
            for(int i = l; i <= r; i++) matrix[t][i] = numb++; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) matrix[i][r] = numb++; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) matrix[b][i] = numb++; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) matrix[i][l] = numb++; // bottom to top.
            if(++l > r) break;
        }
        return matrix;
    }

    public static void main(String[] args) {
        createMatrix c = new createMatrix();
        int[][] matrix = c.createMatrix(20);

        Solution s = new Solution();
        int[] arr = s.spiralOrder(matrix);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1) {
                System.out.println("ERROR!");
                break;
            }
            System.out.println("Check Pass!");
        }
    }
}
