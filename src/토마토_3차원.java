import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_3차원 {

    static int[][] pos = new int[][]{{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};

    static int check(int[][][] map){
        int max = -1;
        for(int k=0;k<map.length;k++) {
            for (int i = 0; i < map[0].length; i++) {
                for (int j = 0; j < map[0][0].length; j++) {
                    if (map[k][i][j] == -1)
                        continue;
                    if (map[k][i][j] == 0)
                        return -1;
                    else
                        max = Math.max(map[k][i][j], max);
                }
            }
        }
        return max;
    }

    static int bfs(int[][][] map,int h,int n,int m){
        boolean[][][] isVisited = new boolean[h][n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int k=0;k<h;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++)
                    if(map[k][i][j]==1)
                        queue.add(new int[]{k,i, j,1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];
            int seq = cur[3];

            for (int i = 0; i < 6; i++) {
                int curX = x + pos[i][0];
                int curY = y + pos[i][1];
                int curZ = z + pos[i][2];
                if (curX<0 || curX>=m )
                    continue;
                if (curY<0 || curY>=n)
                    continue;
                if (curZ<0 || curZ>=h)
                    continue;
                if(map[curZ][curY][curX]==-1 || isVisited[curZ][curY][curX])
                    continue;

                isVisited[curZ][curY][curX] = true;

                map[curZ][curY][curX] = seq+1;
                queue.add(new int[]{curZ,curY,curX,seq+1});
            }
        }

        return check(map);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int m = Integer.parseInt(splitStr[0]);
        int n = Integer.parseInt(splitStr[1]);
        int h = Integer.parseInt(splitStr[2]);
        int[][][] map = new int[h][n][m];

        for(int k=0;k<h;k++) {
            for (int i = 0; i < n; i++) {
                input = br.readLine();
                splitStr = input.split(" ");
                for (int j = 0; j < m; j++)
                    map[k][i][j] = Integer.parseInt(splitStr[j]);
            }
        }

        int check = check(map);
        if(check==1){
            System.out.println(0);
            return;
        }

        int max = bfs(map,h,n,m);
        if(max!=-1)
            max--;
        System.out.println(max);
    }
}
