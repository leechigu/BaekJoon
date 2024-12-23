import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static boolean[][] isVisited;
    static int[][] map;
    static int[][] pos= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int n;
    static int m;
    static int answer = 0;
    public static void bfs(int y,int x,int dir){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,dir});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            int curDir = cur[2];

            //System.out.println(curY + " "+ curX);


            if(map[curY][curX]==0){
                map[curY][curX] = 2;
                answer++;
            }

            if(!check(curY,curX)){
                if(curDir==0){
                    if(curY+1>=n)
                        continue;
                    if(map[curY+1][curX]==1)
                        break;
                    else
                        queue.add(new int[]{curY+1,curX,0});
                }else if(curDir==1){
                    if(curX-1<0)
                        continue;
                    if(map[curY][curX-1]==1)
                        break;
                    else
                        queue.add(new int[]{curY,curX-1,1});
                }else if(curDir==2){
                    if(curY-1<0)
                        continue;
                    if(map[curY-1][curX]==1)
                        break;
                    else
                        queue.add(new int[]{curY-1,curX,2});
                }else if(curDir==3){
                    if(curX+1>=m)
                        continue;
                    if(map[curY][curX+1]==1)
                        break;
                    else
                        queue.add(new int[]{curY,curX+1,3});
                }
            }else{
                while(true){
                    curDir = (curDir-1+4)%4;
                    //System.out.println(curDir);
                    if(curDir==0){
                        if(curY-1<0)
                            continue;
                        if (map[curY - 1][curX] ==0) {
                            queue.add(new int[]{curY - 1, curX, curDir});
                            break;
                        }
                    }else if(curDir==1){
                        if(curX+1>=m)
                            continue;
                        if(map[curY][curX+1]==0) {
                            queue.add(new int[]{curY, curX+1, curDir});
                            break;
                        }
                    }else if(curDir==2){
                        if(curY+1>=n)
                            continue;
                        if(map[curY+1][curX]==0) {
                            queue.add(new int[]{curY + 1, curX, curDir});
                            break;
                        }
                    }else if(curDir==3){
                        if(curX-1<0)
                            continue;
                        if(map[curY][curX-1]==0){
                            queue.add(new int[]{curY,curX-1,curDir});
                            break;
                        }
                    }
                }
            }
        }
    }

    static boolean check(int y,int x){
        for(int i=0;i<4;i++){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY<0||nextY>=n)
                continue;
            if(nextX<0||nextX>=m)
                continue;

            if(map[nextY][nextX]==0)
                return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n][m];
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
            }
        }

        bfs(y,x,dir);

        System.out.println(answer);

    }
}
