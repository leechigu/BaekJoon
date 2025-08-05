import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 호텔 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int maxCost = 100001;
        int[] cost = new int[n+1];
        int[] val = new int[n+1];
        int[] dp = new int[maxCost];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cost[i] = a;
            val[i] = b;
        }

        for(int i=1;i<maxCost;i++){
            for(int j=1;j<=n;j++){
                int c = cost[j];
                int v = val[j];
                if(i<c)
                    continue;
                dp[i] = Math.max(dp[i-c]+v,dp[i]);
            }

        }

        for(int i=0;i<maxCost;i++){
            if(dp[i]>=target){
                System.out.print(i);
                return;
            }
        }

    }
}
