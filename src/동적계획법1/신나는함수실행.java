package 동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는함수실행 {

    static int dp[][][];
    static int w(int a,int b, int c){
        if(inRange(a,b,c)&&dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<=0 || b<=0 || c<=0)
            return 1;
        else if(a>20 || b>20 || c>20)
            return dp[20][20][20] = w(20,20,20);
        else if(a<b && b<c ){
            return dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        }
        else{
            return dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

    public static void main(String[] args) throws IOException {
        dp = new int[21][21][21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1)
                break;
            System.out.println("w("+a+", "+b+", "+c+") = "+w(a,b,c));
        }

    }

}
