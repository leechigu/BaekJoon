import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 동전2 {

    static int n;
    static int k;
    //static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> coins;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> coins = new ArrayList<>();

        for(int i=0;i<n;i++){
            int coin = Integer.parseInt(br.readLine());
            if(coin<10001)
                coins.add(coin);
        }

        Collections.sort(coins);
        int min = coins.get(0);
        int[] dp = new int[10001];

        if(min>10000){
            System.out.println(-1);
            return;
        }
        n = coins.size();
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++) {
            dp[coins.get(i)] = 1;
        }
        dp[0] = 1;
        for(int i=1;i<=k;i++){
            int minVal = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin>i){
                    continue;
                }
                if(dp[i-coin]==-1){
                    continue;
                }
                //System.out.println("--------------");
                //System.out.println(i);
                //System.out.println(coin);
                minVal = Math.min(minVal,dp[i-coin]);
                //System.out.println(minVal);
                //System.out.println("--------------");
            }
            if(minVal == Integer.MAX_VALUE){

            }else{
                dp[i] = minVal+1;
            }
        }
        if(dp[k]==-1)
            System.out.println(-1);
        else
            System.out.print(dp[k]-1);
    }
}
