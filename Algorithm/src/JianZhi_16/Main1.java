package JianZhi_16;

public class Main1 {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1/x;
            b = -b;
        }
        // 快速幂方法
        while(b > 0){
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
