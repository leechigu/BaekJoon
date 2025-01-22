
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {

    static List<int[]> cctvList = new ArrayList<>();
    static int[][][][] temp;
    static int[][][] cctvGo = new int[6][4][4];
    static int m;
    static int n;
    static int min = Integer.MAX_VALUE;

    static int[][] cctvCal(int[][] map,int i,int x,int y,int cctvLevel){
        //북
        int[][] clone = map.clone();
        for (int k = 0; k < n; k++) {
            clone[k] = map[k].clone();
        }
        if (cctvGo[cctvLevel][i][0] == 1) {
            int curY = y + 1;
            while (true) {
                if (curY >= n || map[curY][x] == 6) {
                    break;
                }
                clone[curY][x] = -1;
                curY++;
            }
        }
        //동
        if (cctvGo[cctvLevel][i][1] == 1) {
            int curX = x + 1;
            while (true) {
                if (curX >= m || map[y][curX] == 6) {
                    break;
                }
                clone[y][curX] = -1;
                curX++;
            }
        }
        //남
        if (cctvGo[cctvLevel][i][2] == 1) {
            int curY = y - 1;
            while (true) {
                if (curY <= -1 || map[curY][x] == 6) {
                    break;
                }
                clone[curY][x] = -1;
                curY--;
            }
        }
        //서
        if (cctvGo[cctvLevel][i][3] == 1) {
            int curX = x - 1;
            while (true) {
                if (curX <= -1 || map[y][curX] == 6) {
                    break;
                }
                clone[y][curX] = -1;
                curX--;
            }
        }
        return clone;
    }

    static void dfs(int[][] map,int indx){

        if(indx==cctvList.size()){
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==0)
                        cnt++;
                }
            }
            min = Math.min(min, cnt);
            return;
        }

        int[] cctvInfo = cctvList.get(indx);
        int posX = cctvInfo[0];
        int posY = cctvInfo[1];
        int cctvLevel = cctvInfo[2];
        for(int i=0;i<4;i++){
            int[][] nextMap = cctvCal(map,i,posX,posY,cctvLevel);
            dfs(nextMap,indx+1);
        }
    }

    public static void main(String[] args) throws IOException {
        cctvGo[1] = new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
        cctvGo[2] = new int[][]{{1,0,1,0},{0,1,0,1},{1,0,1,0},{0,1,0,1}};
        cctvGo[3] = new int[][]{{1,1,0,0},{0,1,1,0},{0,0,1,1},{1,0,0,1}};
        cctvGo[4] = new int[][]{{1,1,1,0},{0,1,1,1},{1,0,1,1},{1,1,0,1}};
        cctvGo[5] = new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new int[]{j, i, map[i][j]});
                }
            }
        }

        dfs(map,0);
        System.out.println(min);
    }
}
