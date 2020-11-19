package JianZhi.JianZhi_10I;

class Solution {
    public int fib(int n) {
        if (n == 0) return n;
        int term1 = 0, term2 = 1;
        int temp = 0;
        for (int i = 0; i < n - 1; i++){
            temp = term1;
            term1 = term2;
            term2 = (term1 + temp) > 1000000007? term1 + temp - 1000000007: term1 + temp;
        }
        return term2;
    }
}