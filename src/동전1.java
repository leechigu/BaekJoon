import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        ArrayList<Integer> coinList = new ArrayList<>();
        Arrays.sort(coins);
        for(int coin : coins){
            if(coin<=k)
                coinList.add(coin);
            else
                break;
        }
        n = coinList.size();
        coins = new int[n+1];
        for(int i=1;i<=n;i++){
            coins[i] = coinList.get(i-1);
        }
        int min = coins[1];

        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        int first = coins[1];

        for(int i=0;i<=k;i++)
            if(i%first==0)
                dp[1][i] = 1;

        for(int i=2;i<=n;i++){
            int coin = coins[i];
            for(int j=0;j<coin;j++)
                dp[i][j] = dp[i-1][j];
            for(int j=coin;j<=k;j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-coin];
        }

        System.out.println(dp[n][k]);
    }
}
