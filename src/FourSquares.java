import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourSquares {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp,-1);
        dp[1] = 1; dp[2] = 2;dp[3] = 3;
        for(int i=4;i<dp.length;i++){
            int sqrt = (int) Math.sqrt(i);
            if(i==sqrt*sqrt)
                dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for(int j=0;j<sqrt;j++){
                    int temp =dp[i-(sqrt-j)*(sqrt-j)];
                    if(temp<min)
                        min = temp;
                }
                dp[i] = 1+ min;
            }
        }
        System.out.println(dp[n]);
    }
}
