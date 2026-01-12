import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망서비스 {

    public static int nl;
    public static int[][] dp;
    public static List<Integer>[] lists;
    public static boolean[] isVisited;

    public static int[] dfs(int cur){
        for(int next : lists[cur]){
            if(!isVisited[next]){
                isVisited[next] = true;
                int[] nextDfs = dfs(next);
                dp[cur][0] += nextDfs[1];
                dp[cur][1] += nextDfs[0];
            }
        }
        //System.out.println("cur : "+cur + " -> " + dp[cur][0]  + ", " + dp[cur][1]);
        return new int[] {Math.min(dp[cur][0],dp[cur][1]),dp[cur][1]};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        dp = new int[n+1][2];
        lists = new ArrayList[n+1];
        isVisited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            lists[i] = new ArrayList<>();
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        isVisited[1] = true;
        dfs(1);
        System.out.print(Math.min(dp[1][0],dp[1][1]));

    }
}
