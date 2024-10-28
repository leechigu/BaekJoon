import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농배추 {

    public static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};


    public static int bfs(int[][] map){

        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]==1&&!isVisited[i][j]){
                    int y = i;
                    int x = j;
                    queue.add(new int[]{x,y});
                    isVisited[y][x]= true;
                    answer++;

                    while(!queue.isEmpty()){

                        int[] cur = queue.poll();
                        int curX = cur[0];
                        int curY = cur[1];

                        for(int k=0;k<4;k++){
                            int posX = pos[k][0];
                            int posY = pos[k][1];

                            int nextX = curX+posX;
                            int nextY = curY+posY;

                            if(nextX==-1||nextX==map[0].length)
                                continue;
                            if(nextY==-1||nextY==map.length)
                                continue;

                            if(map[nextY][nextX]==1 && !isVisited[nextY][nextX]){
                                queue.add(new int[]{nextX,nextY});
                                isVisited[nextY][nextX]= true;
                            }
                        }
                    }
                }
            }
        }

        return answer;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int t = Integer.parseInt(input);


        for(int i=0;i<t;i++){

            input = br.readLine();
            String[] splitStr = input.split(" ");

            int m = Integer.parseInt(splitStr[0]);
            int n = Integer.parseInt(splitStr[1]);
            int k = Integer.parseInt(splitStr[2]);

            int[][] arr = new int[n][m];

            for(int j=0;j<k;j++){
                input = br.readLine();
                splitStr = input.split(" ");

                int x = Integer.parseInt(splitStr[0]);
                int y = Integer.parseInt(splitStr[1]);
                arr[y][x] = 1;
            }

            int answer = bfs(arr);
            System.out.println(answer);

        }

    }
}
