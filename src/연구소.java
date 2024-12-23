import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {

    static int n;
    static int m;
    static boolean[][] isVisited;
    static boolean[][] isVist;
    static int[][] map;
    static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] select = new int[3][2];
    static int max = 0;

    static void dfs(int depth, int startX, int startY) {
        if (depth == 3) {
            //cnt++;
            //System.out.println("--------------------");
            for (int i = 0; i < 3; i++) {
                //System.out.println(select[i][0] + " " + select[i][1]);
            }
            //System.out.println("--------------------");

            bfs();
            return;
        }

        for (int i = startX; i < n; i++) {
            for (int j = (i == startX ? startY : 0); j < m; j++) {
                if (map[i][j] == 0 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    select[depth][0] = i;
                    select[depth][1] = j;
                    dfs(depth + 1, i, j + 1); // 다음 탐색 시작 좌표
                    isVisited[i][j] = false;
                }
            }
        }
    }


    static void bfs(){

        Queue<int[]> queue = new LinkedList<>();
        isVist = new boolean[n][m];
        int[][] curMap = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                curMap[i][j] = map[i][j];
                if(curMap[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        for(int i=0;i<3;i++){
            int y = select[i][0];
            int x = select[i][1];
            curMap[y][x] = 1;
        }

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];

            for(int i=0;i<4;i++){
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];

                if(nextY<0||nextY>=n)
                    continue;
                if(nextX<0||nextX>=m)
                    continue;
                if(isVist[nextY][nextX]||curMap[nextY][nextX]==1)
                    continue;
                isVist[nextY][nextX] = true;
                curMap[nextY][nextX] = 2;
                queue.add(new int[]{nextY,nextX});
            }
        }


        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(curMap[i][j]==0)
                    cnt++;
            }
        }

        max = Math.max(max,cnt);

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        System.out.println(max);

    }
}
