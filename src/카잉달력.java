import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 카잉달력 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for(int temp=0;temp<t;temp++){

            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            BigInteger tempA = new BigInteger(String.valueOf(m));
            BigInteger tempB = new BigInteger(String.valueOf(n));

            int gcd = Integer.parseInt(tempA.gcd(tempB).toString());
            long chlth  = m*n/gcd;
            int cur = 0;

            long answer = -1;

            while(true){
                long curA = m*cur+x;
                if(curA>chlth)
                    break;
                if((curA-y)%n==0){
                    answer= curA;
                    break;
                }
                cur++;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
