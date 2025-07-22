import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 앱 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n+1];
        int[] cost = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int maxCos = 0;
        for(int i=1;i<=n;i++){
            maxCos+=cost[i];
        }

        int[][] dp = new int[maxCos+1][n+1];

        for(int i=0;i<=maxCos;i++){
            for(int j=1;j<=n;j++){
                int mem = memory[j];
                int cos = cost[j];
                if(i<cos){
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-cos][j-1]+mem,dp[i][j-1]);
            }
        }
        for(int i=0;i<=maxCos;i++){
            for(int j=1;j<=n;j++){
                if(dp[i][j]>=m){
                    System.out.print(i);
                    return;
                }
            }
        }
    }
}
