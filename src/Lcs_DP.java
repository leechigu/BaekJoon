import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lcs_DP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        String longStr = a.length()>b.length()?a:b;
        String shortStr = a.equals(longStr)?b:a;

        int[][] dp = new int[shortStr.length()+1][longStr.length()+1];
        for(int i=1;i<=shortStr.length();i++)
            for(int j=1;j<=longStr.length();j++)
                if(shortStr.charAt(i-1)==longStr.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
