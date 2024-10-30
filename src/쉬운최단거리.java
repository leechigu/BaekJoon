import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 쉬운최단거리 {


    public static void bfs(int[][] map, int[][] len,boolean[][] isVisited,int x,int y){
        int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curLen = len[curY][curX];
            if(isVisited[curY][curX])
                continue;
            isVisited[curY][curX] = true;

            for(int i=0;i<pos.length;i++){
                int nextX = curX+pos[i][0];
                int nextY = curY+pos[i][1];

                if(nextX<0||nextX>=map[0].length)
                    continue;

                if(nextY<0||nextY>=map.length)
                    continue;

                if(isVisited[nextY][nextX]||map[nextY][nextX]==0)
                    continue;

                len[nextY][nextX] = curLen+1;
                queue.add(new int[]{nextX,nextY});
            }


        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);

        int[][] map = new int[n][m];

        int posX =-1;
        int posY =-1;

        for(int i=0;i<n;i++){
            input = br.readLine();
            splitStr = input.split(" ");
            for(int j=0;j<m;j++){
                int x = Integer.parseInt(splitStr[j]);
                if(x==2){
                    posY = i;
                    posX = j;
                }
                map[i][j] = x;
            }
        }
        boolean[][] isVisited = new boolean[n][m];
        int[][] len = new int[n][m];

        bfs(map,len,isVisited,posX,posY);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1&&len[i][j]==0){
                    len[i][j] = -1;
                }
            }

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(len[i][j]+" ");
            }
            System.out.println();
        }
    }
}
