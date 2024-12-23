import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기 {

    static int[][] map;
    static boolean[][] isVisited;

    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static int a;
    static int n;
    static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y,x,1});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            int curY = cur[0];
            int curX = cur[1];
            map[curY][curX] = a;

            for(int i=0;i<4;i++){
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];

                if(nextY<=0||nextY>n){
                    continue;
                }
                if(nextX<=0||nextX>n){
                    continue;
                }

                if(map[nextY][nextX]==1&&!isVisited[nextY][nextX]){
                    isVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY,nextX});
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        isVisited = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            String input = br.readLine();
            for(int j=1;j<=n;j++){
                map[i][j] = input.charAt(j-1)-'0';
            }
        }

        a =0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j]==1&&!isVisited[i][j]){
                    //System.out.println(i +" "+ j+ " "+ a);
                    a++;
                    bfs(i,j);
                }
            }
        }

        int[] arr = new int[a+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                //System.out.print(map[i][j]+ " ");
                if(map[i][j]!=0)
                    arr[map[i][j]]++;
            }
            //System.out.println();
        }

        System.out.println(a);

        Arrays.sort(arr);

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=0) {
                System.out.println(arr[i]);
            }
        }
    }
}
