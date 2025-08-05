import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for(int i=0;i<n;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            long[][] dp = new long[m+1][n+1];

            int size = 0;

            for(int i=1;i<=n;i++){
                if(coins[i-1]>m){
                    break;
                }
                size++;
                dp[coins[i-1]][i]++;
            }

            for(int i=1;i<=m;i++){
                for(int j=1;j<=size;j++){
                    int coin = coins[j-1];
                    if(i<coin) {
                        dp[i][j]=dp[i][j-1];
                        continue;
                    }
                    dp[i][j] += dp[i-coin][j]+dp[i][j-1];
                }
            }
            sb.append(dp[m][size]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
