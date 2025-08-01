
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈순서_fail {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][] arr = new int[n+1][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][2];

        if(n==1){
            System.out.println(0);
            return;
        }

        dp[2][0] = arr[0][0] * arr[0][1] * arr[1][1];
        dp[2][1] = arr[0][0] * arr[0][1] * arr[1][1];

        for(int i=3;i<=n;i++){

            dp[i][0] = Math.min(dp[i-1][0] + arr[0][0] * arr[i-1][0] *arr[i-1][1]
                    ,dp[i-1][1] + arr[0][0] * arr[i-1][0] * arr[i-1][1]);
            int x = arr[i-2][0] * arr[i-1][0] *arr[i-1][1];
            int y = arr[0][0] * arr[i-2][0] * arr[i-1][1];
            dp[i][1] = Math.min(dp[i-2][0] + x + y
                    ,dp[i-2][1] + x + y);

        }

        System.out.println(Math.min(dp[n][0],dp[n][1]));

    }
}
