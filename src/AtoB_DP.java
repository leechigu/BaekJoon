import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtoB_DP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        int a = Integer.parseInt(splitStr[0]);
        int b = Integer.parseInt(splitStr[1]);

        int[] dp = new int[b+1];

        dp[a] = 0;

        for(int i=a+1;i<=b;i++){
            dp[i]=-1;
        }
        for(int i=a+1;i<=b;i++){
            int x1 = -1;
            if(i%2==0&&i/2>=a){
                if(dp[i/2]!=-1) {
                    x1 = dp[i/2] + 1;
                }
            }
            int x2 = -1;
            String temp = String.valueOf(i);
            if(temp.charAt(temp.length()-1)=='1'){
                temp = temp.substring(0,temp.length()-1);
                int tempVal = Integer.parseInt(temp);
                if(tempVal>a&&dp[tempVal]!=-1){
                    x2 = dp[tempVal]+1;
                }
            }
            if(x1==-1&&x2==-1){
                dp[i] = -1;
            }
            else if(x1==-1) {
                dp[i] = x2;
            }
            else if(x2==-1) {
                dp[i] = x1;
            }
            else{
                dp[i] = Math.min(x1,x2);
            }
        }

        if(dp[b]==-1)
            System.out.println(dp[b]);
        else
            System.out.println(dp[b]+1);

    }
}
