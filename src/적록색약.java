import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약 {
    static char[][] map1;
    static char[][] map2;
    static boolean[][] isVisitied;
    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static int answer = 0;
    static int n;
    static void dfs(char[][] map,int x,int y,char target){

        for(int i=0;i<4;i++){
            int nextX = pos[i][0]+x;
            int nextY = pos[i][1]+y;

            if(nextX<0||nextX>=n)
                continue;
            if(nextY<0||nextY>=n)
                continue;

            if(!isVisitied[nextY][nextX] && map[nextY][nextX]==target) {
                isVisitied[nextY][nextX] = true;
                dfs(map, nextX, nextY, target);
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map1 = new char[n][n];
        map2 = new char[n][n];
        isVisitied = new boolean[n][n];

        for(int i=0;i<n;i++){
            char[] temp =  br.readLine().toCharArray();
            for(int j=0;j<n;j++){
                char cur = temp[j];
                map1[i][j] = cur;
                if(cur=='G')
                    map2[i][j]='R';
                else
                    map2[i][j]=cur;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isVisitied[i][j]) {
                    answer++;
                    char cur  = map1[i][j];
                    dfs(map1, j, i, cur);
                }
            }
        }

        sb.append(answer).append(" ");
        answer = 0;
        isVisitied = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isVisitied[i][j]) {
                    answer++;
                    char cur = map2[i][j];
                    dfs(map2, j, i,cur);
                }
            }
        }

        sb.append(answer);
        System.out.print(sb);

    }
}

