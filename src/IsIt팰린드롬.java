import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class IsIt팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i] =1;
        for(int i=0;i<n-1;i++)
            if(arr[i]==arr[i+1])
                dp[i][i+1] = 1;

        for(int i=n-2;i>=0;i--)
            for(int j=i+2;j<n;j++)
                if(arr[i]==arr[j]&&dp[i+1][j-1]==1)
                    dp[i][j] = 1;


        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s-1][e-1]).append("\n");
        }
        System.out.print(sb);
    }
}
