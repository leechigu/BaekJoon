import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기2 {

    static int[][] map;
    static int n,m;
    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] isVisited;
    static int cnt=0;
    static List<int[]> lists;

    public static int[] parent;
    public static int[] childCnt;

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

        lists = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                makeBridge(i,j);
            }
        }

        Collections.sort(lists, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]- o2[2];
            }
        });
        parent = new int[cnt+1];
        childCnt = new int[cnt+1];
        for(int i=1;i<=cnt;i++){
            parent[i] = i;
            childCnt[i] = 1;
        }

        int answer = 0;

        for(int[] d : lists){
            int a = d[0];
            int b = d[1];
            int val = d[2];

            if(findRoot(a)!=findRoot(b)){
                union(a,b);
                answer+=val;
            }
        }

        boolean isAll = true;
        int z = findRoot(1);
        for(int i=1;i<=cnt;i++){
            if(findRoot(i)!=z)
                isAll = false;
        }

        if(!isAll)
            answer = -1;
        System.out.print(answer);
    }

    static int findRoot(int a){

        if(parent[a]==a){
            return a;
        }
        return parent[a] = findRoot(parent[a]);
    }

    static void union(int a,int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(childCnt[rootA]>childCnt[rootB]){
            parent[rootB] = rootA;
            childCnt[rootA] += childCnt[rootB];
        }else{
            parent[rootA] = rootB;
            childCnt[rootB] += childCnt[rootA];
        }

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
            lists.add(new int[]{st,ed,dis});
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
            lists.add(new int[]{st,ed,dis});
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
            lists.add(new int[]{st,ed,dis});
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
            lists.add(new int[]{st,ed,dis});
        }
    }
}
