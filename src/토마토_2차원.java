import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_2차원 {

    static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    static int check(int[][] map){
        int max = -1;
        for(int i=0;i< map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]==-1)
                    continue;
                if(map[i][j]==0)
                    return -1;
                else
                    max = Math.max(map[i][j],max);
            }
        }
        return max;
    }

    static int bfs(int[][] map, int n,int m){
        boolean[][] isVisited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(map[i][j]==1)
                    queue.add(new int[]{i, j, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int seq = cur[2];

            for (int i = 0; i < 4; i++) {
                int curX = x + pos[i][0];
                int curY = y + pos[i][1];

                if (curX<0 || curX>=m )
                    continue;
                if (curY<0 || curY>=n)
                    continue;
                if(map[curY][curX]==-1 || isVisited[curY][curX])
                    continue;

                isVisited[curY][curX] = true;

                map[curY][curX] = seq+1;
                queue.add(new int[]{curY,curX,seq+1});
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
        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            input = br.readLine();
            splitStr = input.split(" ");
            for(int j=0;j<m;j++)
                map[i][j] = Integer.parseInt(splitStr[j]);
        }


        int check = check(map);
        if(check==1){
            System.out.println(0);
            return;
        }

        int max = bfs(map,n,m);
        if(max!=-1)
            max--;
        System.out.println(max);
    }
}
