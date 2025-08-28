import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 복제로봇 {

    static int[][] map;
    static int n,m;
    static int[][] pos = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisited;
    static List<int[]> list = new ArrayList<>();
    static int[] parent;
    static int[] childCnt;

    static void bfs(int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x,0});
        isVisited[y][x] = true;
        int start = map[y][x];

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int val = poll[2];
            int cur = map[curY][curX];

            if(cur>0 && cur!=start) {
                list.add(new int[] {start,cur,val});
            }

            for(int i=0;i<4;i++){
                int nextY = curY + pos[i][0];
                int nextX = curX + pos[i][1];
                if(nextY<0||nextY>=n)continue;
                if(nextX<0||nextX>=n)continue;
                if(isVisited[nextY][nextX])continue;
                if(map[nextY][nextX]==-1)continue;
                isVisited[nextY][nextX] = true;
                queue.add(new int[] {nextY,nextX,val+1});
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        int keyIndx =0;
        int y = -1;
        int x = -1;
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                if(str.charAt(j)=='1'){
                    map[i][j] = -1;
                }else if(str.charAt(j)=='K'){
                    keyIndx++;
                    map[i][j] = keyIndx;
                }else if(str.charAt(j)=='S'){
                    y = i;
                    x = j;
                }
            }
        }

        isVisited = new boolean[n][n];
        bfs(y,x);
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]>0) {
                    isVisited = new boolean[n][n];
                    bfs(i, j);
                }
            }
        }

        int answer = 0;

        parent = new int[keyIndx+1];
        childCnt = new int[keyIndx+1];
        for(int i=0;i<=keyIndx;i++){
            parent[i]=i;
            childCnt[i]=1;
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });


        for(int[] temp : list){
            int a = temp[0];
            int b = temp[1];
            int val = temp[2];
            System.out.println(a+" -> " + b + " : " +val);
            if(findRoot(a)!=findRoot(b)){
                union(a,b);
                answer+=val;
            }
        }

        int start = parent[1];
        boolean isFull = true;
        for(int i=0;i<=keyIndx;i++){
            if(parent[i]!=start){
                isFull = false;
            }
        }
        if(isFull && answer>0)
            System.out.print(answer);
        else {
            System.out.print(-1);
        }

    }

    static int findRoot(int a){
        if(parent[a]==a ){
            return a;
        }
        return parent[a] = findRoot(parent[a]);
    }

    static void union(int a, int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(childCnt[rootA]>childCnt[rootB]){
            childCnt[rootA]+=childCnt[rootB];
            parent[rootB] = rootA;
        }else{
            childCnt[rootB]+=childCnt[rootA];
            parent[rootA] = rootB;
        }
    }

}
