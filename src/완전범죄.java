import java.util.*;

class 완전범죄 {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[n];
        Arrays.fill(dp,1000);
        dp[0] = 0;

        for(int[] inf : info){
            for(int i=n-1;i>=0;i--){
                dp[i] +=  inf[1];
                if (i - inf[0] >= 0) {
                    dp[i] = Math.min(dp[i],dp[i-inf[0]]);
                }
            }
        }

        int answer = -1;

        for(int i=0;i<n;i++){
            if(dp[i] < m){
                return dp[i];
            }
        }

        return answer;
    }
}