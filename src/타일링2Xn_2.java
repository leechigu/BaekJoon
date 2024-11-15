import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일링2Xn_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3;i<dp.length;i++)
            dp[i] = (2*dp[i-2] + dp[i-1])%10007;
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]%10007);
    }
}
