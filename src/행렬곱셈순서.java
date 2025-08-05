
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬곱셈순서 {

    static int[][] dp;
    static int[][] arr;

    public static int dfs(int st, int end){

        System.out.println("pos = "+ st + ", "+ end);

        if(dp[st][end]!=Integer.MAX_VALUE){
            return dp[st][end];
        }

        if(end==st){
            return 0;
        }

        for(int i=st;i<end;i++){
            dp[st][end] = Math.min(dp[st][end], dfs(st,i)+dfs(i+1,end)+ (arr[st-1][0] * arr[i][1] * arr[end-1][1]));
        }
        return dp[st][end];

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        arr = new int[n+1][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int i=1;i<n;i++){
            dp[i][i] = 0;
            dp[i][i+1] = arr[i-1][0] *  arr[i-1][1] * arr[i][1];
        }

        if(n==1){
            System.out.println(0);
            return;
        }

        System.out.print(dfs(1,n));

    }
}
