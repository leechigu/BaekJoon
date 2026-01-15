import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {


    static int n;
    static int m;
    static int r;
    static int[][] map;

    static void rotate(){
        int[][] next = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                next[i][j] = map[i][j];
            }
        }
        int y1 =0;
        int y2 = n;
        int x1 = 0;
        int x2 = m;

        while(true){
            if(y1==y2|| x1==x2) break;

            for(int i=y1+1;i<y2;i++)
                next[i][x1] = map[i-1][x1];
            for(int j=x1+1;j<x2;j++)
                next[y2-1][j] = map[y2-1][j-1];
            for(int i=y2-2;i>=y1;i--)
                next[i][x2-1] = map[i+1][x2-1];
            for(int j=x2-2;j>=x1;j--)
                next[y1][j] = map[y1][j+1];
            y1++;x1++;
            y2--;x2--;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = next[i][j];
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<r;i++)
            rotate();


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
