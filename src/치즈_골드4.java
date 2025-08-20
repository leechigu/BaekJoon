import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_골드4 {

    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    static int[][] map;
    static int n,m;
    static boolean[][] isVisited;
    static int cnt=0,seq=0,ansCnt=0;

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[n][m];
        isVisited[0][0] = true;

        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];

                if (nextY < 0 || nextY >= n) continue;
                if (nextX < 0 || nextX >= m) continue;
                if (isVisited[nextY][nextX]) continue;

                isVisited[nextY][nextX] = true;

                if (map[nextY][nextX] == 1) {
                    map[nextY][nextX] = -1;
                    continue;
                } else if (map[nextY][nextX] == -1)
                    continue;

                queue.add(new int[]{nextY, nextX});
            }
        }

        ansCnt = cnt;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==-1) {
                    map[i][j] = 0;
                    cnt--;
                }
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
                if(map[i][j] ==1){
                    cnt++;
                }
            }
        }
        while(true){
            if(cnt==0){
                break;
            }
            seq++;
            bfs();
        }
        System.out.println(seq);
        System.out.print(ansCnt);
    }
}
