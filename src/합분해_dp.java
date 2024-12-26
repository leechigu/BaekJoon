import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해_dp {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr= new int[n+1];
        int div = 1000000000;

        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<=k;i++)
            dp[0][i] = 1;
        for(int i=0;i<=n;i++)
            dp[i][1] = 1;

        int indx = 2;
        while(true){
            if(indx>k)
                break;
            for(int i=1;i<=n;i++){
                dp[i][indx] = (dp[i-1][indx] + dp[i][indx-1])%div;
            }
            indx++;
        }
        System.out.println(dp[n][k]%div);
    }
}
