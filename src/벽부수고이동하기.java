import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

    static class Node{
        int y;
        int x;
        int curVal;
        int wallCnt;

        public Node(int y, int x,int curVal, int wallCnt) {
            this.y =y;
            this.x = x;
            this.curVal = curVal;
            this.wallCnt = wallCnt;
        }
    }

    static int[][] pos = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] map;
    static int n;
    static int m;
    static boolean[][][] isVisited;



    static int bfs(){

        isVisited  = new boolean[n][m][2];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1,0));
        isVisited[0][0][0] =true;
        while(!queue.isEmpty()){

            Node cur = queue.poll();
            int curY = cur.y;
            int curX = cur.x;
            int curVal = cur.curVal;
            int curWall = cur.wallCnt;


            if(curY == n-1 && curX == m-1){
                return curVal;
            }

            for(int i=0;i<4;i++){
                int nextY = curY+pos[i][0];
                int nextX = curX+pos[i][1];
                if (nextX < 0 || nextX >= m)
                    continue;
                if (nextY < 0 || nextY >= n)
                    continue;

                if(map[nextY][nextX]==0){
                    if(!isVisited[nextY][nextX][curWall]){
                        isVisited[nextY][nextX][curWall] = true;
                        queue.add(new Node(nextY,nextX,curVal+1,curWall));
                    }
                }else if(map[nextY][nextX]==1&&curWall==0){
                    if(!isVisited[nextY][nextX][curWall]){
                        isVisited[nextY][nextX][curWall+1] = true;
                        queue.add(new Node(nextY,nextX,curVal+1,curWall+1));
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        ArrayList<int[]> wallPosList = new ArrayList<>();

        for(int i=0;i<n;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<m;j++) {
                int cur = c[j]-'0';
                if(cur==1)
                    wallPosList.add(new int[]{i,j});
                map[i][j] = cur;
            }
        }
        System.out.println(bfs());
    }
}

