import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬곱셈순서__{

    static int[][] dp;
    static int[][] arr;
    static int n;

    public static int dfs(int st , int end){

        if(dp[st][end]!=Integer.MAX_VALUE){
            return dp[st][end];
        }

        if(end-1==st){
            return dp[st][end] = arr[st][0] * arr[st][1] * arr[end][1];
        }

        if(st==end){
            return 0;
        }

        for(int i=st; i<end; i++){
            dp[st][end] =
                    Math.min(dp[st][end]
                            , dfs(st,i) + dfs(i+1,end) + arr[st][0] * arr[i][1] * arr[end][1]);
        }

        return dp[st][end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        arr = new int[n+1][2];
        dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(dfs(1,n));

    }


}