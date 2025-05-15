import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공통부분문자열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tempA = br.readLine();
        String tempB = br.readLine();

        int n = tempA.length();
        int m = tempB.length();

        int[][] dp = new int[n+1][m+1];

        char[] a = tempA.toCharArray();
        char[] b = tempB.toCharArray();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        int max = -1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                max = Math.max(dp[i][j],max);
            }
        }
        System.out.print(max);
    }
}
