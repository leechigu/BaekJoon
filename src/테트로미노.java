import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 테트로미노 {

    static int[][] pos={{1,0},{0,1},{-1,0},{0,-1}};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] isVisitied;
    static int max = -1;
    static void dfs(int y, int x, int seq, int sum){

        if(seq==4){
            max = Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++){

            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];

            if(nextY<=0||nextY>n)
                continue;
            if(nextX<=0||nextX>m)
                continue;

            if(seq==2){
                if(!isVisitied[nextY][nextX]) {
                    isVisitied[nextY][nextX] = true;
                    dfs(y, x, seq + 1, sum + map[nextY][nextX]);
                    isVisitied[nextY][nextX] = false;
                }
            }

            if(!isVisitied[nextY][nextX]) {
                isVisitied[nextY][nextX] = true;
                dfs(nextY, nextX, seq + 1, sum + map[nextY][nextX]);
                isVisitied[nextY][nextX] = false;
            }

        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
            }
        }


        isVisitied = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                isVisitied[i][j] = true;
                dfs(i,j,1,map[i][j]);
                isVisitied[i][j] = false;
            }
        }

        System.out.println(max);
    }
}
