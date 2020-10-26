package 面试.aiqixin;
import java.math.BigDecimal;
import java.util.*;

public class Main{
    public static BigDecimal doFactorial(int N){
        BigDecimal result = new BigDecimal(1);
        for (int i = 1; i <= N; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N < 1 || N > 200){
            System.out.println("Error");
        }else {
            System.out.println(doFactorial(N));
        }
    }
}