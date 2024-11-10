import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);

        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            splitStr = br.readLine().split(" ");
            for(int j=1;j<=n;j++)
                map[i][j] = Integer.parseInt(splitStr[j-1]);
        }
        dp[0][0] = map[0][0];
        for(int i=1;i<=n;i++){
            dp[i][0] = map[i][0]+dp[i-1][0];
            dp[0][i] = map[0][i]+dp[0][i-1];
        }

        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];


        for(int i=0;i<m;i++){
            input = br.readLine();
            splitStr = input.split(" ");

            int y1 = Integer.parseInt(splitStr[0]);
            int x1 = Integer.parseInt(splitStr[1]);
            int y2 = Integer.parseInt(splitStr[2]);
            int x2 = Integer.parseInt(splitStr[3]);
            int answer = dp[y2][x2]-dp[y1-1][x2]-dp[y2][x1-1]+dp[y1-1][x1-1];

            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
