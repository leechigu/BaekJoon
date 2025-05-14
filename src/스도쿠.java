import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스도쿠 {

    static int[][] a;
    static boolean[][] c = new boolean[10][10];
    static boolean[][] c2 = new boolean[10][10];
    static boolean[][] c3 = new boolean[10][10];
    static int n = 9;
    static int cnt = 0;

    static StringBuilder sb = new StringBuilder();

    static int squareCheck(int x, int y){
        return (x/3)*3+(y/3);
    }

    static boolean go(int z){
        cnt++;
        if(cnt >=10000000){
            return true;
        }
        if(z==81){
           for(int i=0;i<n;i++){
               for(int j=0;j<n;j++){
                   sb.append(a[i][j]);
               }
               sb.append("\n");
           }
           return true;
        }

        int x = z/n;
        int y = z%n;
        if(a[x][y] !=0){
            return go(z+1);
        }
        else{
            for(int i=1;i<=n;i++){
                if(!c[x][i] && !c2[y][i] && !c3[squareCheck(x,y)][i]){
                    c[x][i] = c2[y][i] = c3[squareCheck(x,y)][i] = true;
                    a[x][y] = i;
                    if(go(z+1)){
                        return true;
                    }
                    a[x][y] = 0;
                    c[x][i] = c2[y][i] = c3[squareCheck(x,y)][i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = new int[10][10];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<n;j++){
                int val = input.charAt(j)-'0';
                a[i][j] = val;
                if(a[i][j] !=0){
                    c[i][a[i][j]] = true;
                    c2[j][a[i][j]] = true;
                    c3[squareCheck(i,j)][a[i][j]] = true;
                }
            }
        }

        go(0);
        System.out.print(sb.toString());
    }
}
