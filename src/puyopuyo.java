import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class puyopuyo {

    static boolean[][] isVisited;
    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n = 12;
    static int m = 6;
    static char[][] map = new char[n][m];

    public static int dfs(int y,int x,int val){

        int rtn = 1;

        for(int i=0;i<pos.length;i++){
            int nextY = pos[i][0]+y;
            int nextX = pos[i][1]+x;
            if(nextY<0||nextY>=n){
                continue;
            }
            if(nextX<0||nextX>=m){
                continue;
            }
            if(!isVisited[nextY][nextX] && map[nextY][nextX]==val){
                isVisited[nextY][nextX] = true;
                rtn += dfs(nextY,nextX,val);
            }
        }
        return rtn;
    }

    public static void mark(int y,int x, int val){
        map[y][x] = '*';
        for(int i=0;i<pos.length;i++){
            int nextY = pos[i][0]+y;
            int nextX = pos[i][1]+x;
            if(nextY<0||nextY>=n){
                continue;
            }
            if(nextX<0||nextX>=m){
                continue;
            }
            if(map[nextY][nextX]==val){
                mark(nextY,nextX,val);
            }
        }
    }

    public static void processMark(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                while(true){
                    if(map[i][j]!='*')
                        break;
                    move(i,j);
                }
            }
        }
    }

    public static void move(int y,int x){
        for(int i=y;i>=1;i--){
            map[i][x] = map[i-1][x];
        }
        map[0][x] = '.';
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);
            }
        }

        int seq = 0;
        while(true){
            isVisited = new boolean[n][m];
            boolean boom = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]!='.' && !isVisited[i][j]){
                        isVisited[i][j] = true;
                        int cnt = dfs(i,j,map[i][j]);
                        if(cnt>=4){
                            boom = true;
                            mark(i,j,map[i][j]);
                            processMark();
                        }
                    }
                }
            }
            if(boom){
                seq++;
            }else {
                break;
            }
        }
        System.out.print(seq);
    }
}
