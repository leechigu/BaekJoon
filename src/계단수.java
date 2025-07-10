import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계단수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int MOD = 1000000000;

        int[][][] dp = new int[n][10][1<<10];

        for(int i=1;i<10;i++)
            dp[0][i][1<<i] = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<1024;k++){

                    int bit = k|1<<j;

                    if(j==0){
                        dp[i][j][bit] += (dp[i-1][1][k])%MOD;
                    }
                    else if(j==9){
                        dp[i][j][bit] += dp[i-1][8][k]%MOD;
                    }else{
                        dp[i][j][bit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k])%MOD;
                    }
                    dp[i][j][bit]%=MOD;
                }
            }
        }

        int sum = 0;

        for(int i=0;i<10;i++){
            sum+=dp[n-1][i][1023]%MOD;
            sum%=MOD;
        }
        System.out.println(sum);
    }
}
