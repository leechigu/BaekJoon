
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 외판원순회 {

    static int min =  Integer.MAX_VALUE;
    static int n;
    static int maxBitSize;
    static int INF = 16000001;
    static int[][] map;
    static int[][] dp;

    static int dfs(int now, int visit){

        if(visit == maxBitSize-1){
            if(map[now][0]==0)
                return INF;
            return map[now][0];
        }

        if(dp[now][visit]!=-1){
            return dp[now][visit];
        }
        dp[now][visit] = INF;

        for(int i=0;i<n;i++){
            if((visit & (1<<i)) == 0 && map[now][i]!=0){
                dp[now][visit] = Math.min(dfs(i,visit|(1<<i))+map[now][i],dp[now][visit]);
            }
        }

        return dp[now][visit];

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxBitSize = 1<<n;

        dp = new int[n][maxBitSize];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0,1));
    }
}
