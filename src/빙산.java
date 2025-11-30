import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산 {

    static int n,m;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] pos = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public static int[][] next(){
        int[][] nextMap = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]>0){
                    int seaCnt = countSea(i,j);
                    nextMap[i][j] = Math.max(0,map[i][j]-seaCnt);
                }
            }
        }
        return nextMap;
    }

    public static int countSea(int y,int x){
        int cnt = 0;

        for(int i=0;i<4;i++){
            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];
            if(nextY<0 || nextY>=n) continue;
            if(nextX<0 || nextX>=m) continue;
            if(map[nextY][nextX]==0) cnt++;
        }
        return cnt;
    }


    static int cnt;

    public static boolean check(){
        isVisited = new boolean[n][m];
        cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!isVisited[i][j] && map[i][j]>0){
                    cnt++;
                    isVisited[i][j] = true;
                    dfs(i,j);
                }
            }
        }

        return cnt >= 2;
    }

    public static void dfs(int y,int x){
        for(int i=0;i<4;i++){
            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];
            if(nextY<0 || nextY>=n) continue;
            if(nextX<0 || nextX>=m) continue;
            if(isVisited[nextY][nextX]) continue;
            if(map[nextY][nextX]>0) {
                isVisited[nextY][nextX] = true;
                dfs(nextY, nextX);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true){
            if(check()){
               break;
            }else if(cnt==0){
                System.out.print(0);
                return;
            }
            map = next();
            answer++;
        }

        System.out.print(answer);


    }
}
