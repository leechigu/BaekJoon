import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다리만들기2_dfs {

    static int[][] map;
    static int n,m;
    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisited;
    static int cnt=0;
    static int[][] lists;
    static int min = Integer.MAX_VALUE;
    static boolean[] visitied;

    public static void dfs(int cur, int curVal){

        boolean isFull = true;
        for(int i=1;i<=cnt;i++){
            if(!visitied[i]){
                isFull = false;
                break;
            }
        }

        if(isFull){
            min = Math.min(curVal,min);
            return;
        }

        boolean[] temp = visitied.clone();

        for(int i=1;i<=cnt;i++){
            int dis = lists[cur][i];

            if(visitied[i] || dis==Integer.MAX_VALUE){
                continue;
            }

            if(curVal+dis<min) {
                curVal+=dis;
                visitied[i] = true;
                dfs(i, curVal);
            }
        }
        visitied = temp.clone();
    }

    public static void count(int y, int x){

        isVisited[y][x] = true;
        map[y][x] = cnt;

        for(int i=0;i<4;i++){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY<0||nextY>=n)
                continue;
            if(nextX<0||nextX>=m)
                continue;

            if(!isVisited[nextY][nextX] && map[nextY][nextX]!=0){
                count(nextY,nextX);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!=0 && !isVisited[i][j]) {
                    cnt++;
                    count(i, j);
                }
            }
        }

        lists = new int[cnt+1][cnt+1];
        for(int i=0;i<=cnt;i++){
            Arrays.fill(lists[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                makeBridge(i,j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

        for(int i=1;i<=cnt;i++){
            for(int j=1;j<=cnt;j++){
                System.out.print(lists[i][j]+ " ");
            }
            System.out.println();
        }

        visitied = new boolean[cnt+1];

        visitied[1] = true;
        dfs(1,0);
        if(min==Integer.MAX_VALUE)
            min = -1;
        System.out.print(min);
    }


    static void makeBridge(int y, int x){
        int st = map[y][x];
        //북
        int dis = 0;
        int ed = -1;
        for(int i=y-1;i>=0;i--){
            if(map[i][x]==st)
                break;
            if(map[i][x]!=0){
                ed = map[i][x];
                break;
            }
            dis++;
        }
        if(ed!=-1 && dis>1){
            lists[st][ed] = Math.min(lists[st][ed],dis);
        }

        dis = 0;
        ed = -1;
        //남
        for(int i=y+1;i<n;i++){
            if(map[i][x]==st)
                break;
            if(map[i][x]!=0){
                ed = map[i][x];
                break;
            }
            dis++;
        }
        if(ed!=-1 && dis>1){
            lists[st][ed] = Math.min(lists[st][ed],dis);
        }
        //동
        dis = 0;
        ed = -1;
        for(int j=x+1;j<m;j++){
            if(map[y][j]==st)
                break;
            if(map[y][j]!=0){
                ed = map[y][j];
                break;
            }
            dis++;
        }
        if(ed!=-1 && dis>1){
            lists[st][ed] = Math.min(lists[st][ed],dis);
        }
        //서
        dis = 0;
        ed = -1;
        for(int j=x-1;j>=0;j--){
            if(map[y][j]==st)
                break;
            if(map[y][j]!=0){
                ed = map[y][j];
                break;
            }
            dis++;
        }
        if(ed!=-1 && dis>1){
            lists[st][ed] = Math.min(lists[st][ed],dis);
        }
    }
}
