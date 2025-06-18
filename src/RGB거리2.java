import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] map = new int[n][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int ans = 1000*10000;
        int[][] dp = new int[n][3];
        dp[0][0] = map[0][0];
        dp[0][1] = dp[0][2] = 1000*10000;

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+map[i][2];
        }

        ans = Math.min(dp[n-1][1],dp[n-1][2]);

        dp = new int[n][3];
        dp[0][1] = map[0][1];
        dp[0][0] = dp[0][2] = 1000*10000;

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+map[i][2];
        }

        ans = Math.min(ans,Math.min(dp[n-1][0],dp[n-1][2]));

        dp = new int[n][3];
        dp[0][2] = map[0][2];
        dp[0][1] = dp[0][0] = 1000*10000;

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+map[i][2];
        }
        ans = Math.min(ans,Math.min(dp[n-1][0],dp[n-1][1]));
        System.out.print(ans);
    }
}
