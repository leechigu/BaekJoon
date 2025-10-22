import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 별찍기_11 {

    static char[][] map;

    public static void star(int y1,int y2,int x1,int x2){
        if(y2-y1==3){
            map[y1][x1+2]='*';
            map[y1+1][x1+1]='*';map[y1+1][x1+3]='*';
            for(int i=x1;i<x2-1;i++){
                map[y1+2][i]='*';
            }
            return;
        }

        int x = (x2-x1)/4;
        int y = (y2-y1)/2;

        star(y1,y2-y,x1+x,x2-x);
        star(y1+y,y2,x1,x1+(x*2));
        star(y1+y,y2,x1+(x*2),x2);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n*2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n*2;j++){
                map[i][j] = ' ';
            }
        }

        star(0,n,0,n*2);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<n*2-1;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
