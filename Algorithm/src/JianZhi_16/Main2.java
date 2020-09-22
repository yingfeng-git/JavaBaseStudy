package JianZhi_16;

public class Main2 {
    public static double myPow(int x, int n) {
        if(x == 0) return 0;
        long b = n;
        long res = 1;
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
        return res % 1000000007;
    }

    public static void main(String[] args) {
        int a = 2000000000;
        int b = 2000000000;
//        System.out.println(((a % 1000000007) + (b % 1000000007)) % 1000000007);

        long aa = a;
        long bb = b;
        System.out.println((aa*bb) % 1000000007);
    }
}
