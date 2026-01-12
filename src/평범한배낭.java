import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평범한배낭 {
    static int[][] arr;
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        n = Integer.parseInt(splitStr[0]);
        k = Integer.parseInt(splitStr[1]);

        arr = new int[n+1][ 2];
        dp = new int[n+1][k+1];

        for(int i=0;i<n;i++){
            splitStr = br.readLine().split(" ");
            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                int a = dp[i-1][j];
                int b = 0;
                if(j-arr[i-1][0]>=0){
                    b = dp[i-1][j-arr[i-1][0]]+arr[i-1][1];
                }
                dp[i][j] = Math.max(a,b);
            }
        }

/*        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.print(dp[n][k]);
    }
}
