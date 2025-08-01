import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 댄스댄스레볼루션 {

    public static int calPow(int target, int cur){

        int big = Math.max(target,cur);
        int sml = Math.min(target,cur);

        if(cur==0){
            return 2;
        }

        if(big-sml==1||big-sml==3){
            return 3;
        }

        if(big-sml==2){
            return 4;
        }
        return 1;
    }


    public static void main(String[] args) throws IOException {
        int INF = Integer.MAX_VALUE-100;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = input.length()/2;

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[][][] dp = new int[n+1][5][5];

        for(int i=0;i<=n;i++){
            for(int j=0;j<5;j++){
                Arrays.fill(dp[i][j],INF);
            }
        }

        dp[1][arr[0]][0] = 2;
        dp[1][0][arr[0]] = 2;

        for(int i=2;i<=n;i++){
            int pos = arr[i-1];

            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    int lastVal = dp[i-1][j][k];
                    if(lastVal==INF){
                        continue;
                    }
                    dp[i][pos][k] = Math.min(dp[i][pos][k], lastVal+calPow(pos,j));
                    dp[i][j][pos] = Math.min(dp[i][j][pos], lastVal+calPow(pos,k));
                }
            }

        }

        int answer = INF;
        int last = arr[n-1];


        for(int i=0;i<5;i++){
            answer = Math.min(answer,dp[n][last][i]);
        }

        for(int i=0;i<5;i++){
            answer = Math.min(answer,dp[n][i][last]);
        }

        System.out.println(answer);

    }
}
