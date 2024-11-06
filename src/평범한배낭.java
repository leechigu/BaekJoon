import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 평범한배낭 {
    static int[][] arr;
    static int n;
    static int k;
    static int[][] dp;

    static int go(int i,int w){

        if(dp[i][w]>0)
            return dp[i][w];

        if(i==n)
            return 0;
        //포함
        int n1 = 0;
        if(w + arr[i][1]<=k) {
            n1 = arr[i][0] + go(i + 1, w + arr[i][1]);
        }
        //미포함
        int n2 = go(i+1,w);
        return dp[i][w] = Math.max(n1,n2);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        n = Integer.parseInt(splitStr[0]);
        k = Integer.parseInt(splitStr[1]);

        arr = new int[n][2];
        dp = new int[n+1][k+1];
        for(int i=0;i<n;i++){
            splitStr = br.readLine().split(" ");
            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }





        System.out.println(go(0,0));

    }
}
