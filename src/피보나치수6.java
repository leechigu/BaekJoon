import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 피보나치수6 {

    static long DIV_VAL = 1000000007;

    static HashMap<Long,Long> map;

    static long fibo(long n){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if (n % 2 == 0) {
            long a = n / 2;
            long f = fibo(a) % DIV_VAL;
            long f1 = fibo(a + 1) % DIV_VAL;

            long temp = (2 * f1 % DIV_VAL - f + DIV_VAL) % DIV_VAL; // 음수 방지
            long sum = (temp * f) % DIV_VAL;
            map.put(n, sum);
            return sum;
        } else {
            long a = (n + 1) / 2;
            long f = fibo(a) % DIV_VAL;
            long f1 = fibo(a - 1) % DIV_VAL;

            long sum = (f * f % DIV_VAL + f1 * f1 % DIV_VAL) % DIV_VAL;
            map.put(n, sum);
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        map = new HashMap<>();
        map.put(0L,0L);
        map.put(1L,1L);
        map.put(2L,1L);
        map.put(3L,2L);
        map.put(4L,3L);
        map.put(5L,5L);

        long answer = fibo(n);
        System.out.println(answer);
    }
}
