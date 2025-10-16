import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 터치미션 {

    static int n;
    static String[][] map;
    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisitied;

    static int bfs(int y,int x){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,0});

        int max = 0;

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int seq = poll[2];

            if(map[curY][curX].equals("O")){
                max = Math.max(max,seq);
            }

            for(int i=0;i<4;i++){
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];

                if(nextY<0 || nextY >=n){
                    continue;
                }
                if(nextX<0 || nextX >=n){
                    continue;
                }
                if(isVisitied[nextY][nextX]){
                    continue;
                }
                if(map[nextY][nextX].equals("X")){
                    continue;
                }
                isVisitied[nextY][nextX] = true;
                queue.add(new int[]{nextY,nextX,seq+1});
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new String[n][n];
        isVisitied = new boolean[n][n];

        int stY=-1,stX=-1;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = st.nextToken();
                if(map[i][j].equals("P")){
                    stY = i;
                    stX = j;
                }
            }
        }

        int max = bfs(stY,stX);

        System.out.println(max);
    }
}
