import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LCS2 {

    static int [][] dp;
    static char[] a;
    static char[] b;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempA = br.readLine();
        String tempB = br.readLine();
        a = tempA.toCharArray();
        b = tempB.toCharArray();

        n = tempA.length();
        m = tempB.length();

        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[n][m]);
        System.out.print(lcs());

    }

    public static String lcs(){

        StringBuilder sb = new StringBuilder();
        int i=n;
        int j=m;
        while(true){
            if (i == 0 || j == 0) {
                break;
            }
            if(a[i-1]==b[j-1]){
                i--;
                j--;
                sb.append(a[i]);
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
