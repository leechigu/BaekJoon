import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {

    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static int n;
    static int m;
    static boolean[][] isVisited;
    static int[][] map;
    static void bfs(){


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1,1});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            int y = cur[0];
            int x = cur[1];
            int seq = cur[2];

            isVisited[y][x] = true;

            if(y==n&&x==m){
                System.out.println(seq);
                return;
            }


            for(int i=0;i<4;i++){

                int nextY = pos[i][0] + y;
                int nextX = pos[i][1] + x;

                if(nextX<=0||nextX>m)
                    continue;
                if(nextY<=0||nextY>n)
                    continue;

                if(isVisited[nextY][nextX]){
                    continue;
                }
                if(map[nextY][nextX]==0){
                    continue;
                }

                queue.add(new int[]{nextY,nextX,seq+1});
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        isVisited = new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            String input = br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j] = input.charAt(j-1)-'0';
            }
        }

        bfs();

    }
}
