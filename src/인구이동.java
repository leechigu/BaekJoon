import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동 {
    static int[][] map;
    static int n,r,l;
    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisited;

    public static boolean bfs(int y, int x){

        Queue<int[]> queue = new LinkedList<>();
        List<int[]> visitList = new ArrayList<>();
        queue.add(new int[] {y,x});
        isVisited[y][x] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];

            visitList.add(new int[] {curY,curX});
            sum+=map[curY][curX];
            for(int i=0;i<4;i++){
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];

                if(nextY<0 || nextY>=n)
                    continue;
                if(nextX<0 || nextX>=n)
                    continue;
                if(isVisited[nextY][nextX])
                    continue;

                int valDiff = Math.abs(map[nextY][nextX] - map[curY][curX]);
                if(valDiff>=l && valDiff<=r){
                    isVisited[nextY][nextX] = true;
                    queue.add(new int[]{nextY,nextX});
                }
            }
        }

        if(visitList.size()>1){
            int val = sum/visitList.size();
            for(int[] visit : visitList){
                map[visit[0]][visit[1]] = val;
            }
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int seq = 0;
        while(true){
            boolean isMoved = false;
            isVisited = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!isVisited[i][j]){
                        if(bfs(i,j)){
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved) {
                break;
            }else {
                seq++;
            }
        }
        System.out.print(seq);
    }
}
