import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 행성터널 {

    static int n;
    static int[] parent;

    static void union(int a,int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        int minRoot = Math.min(rootA,rootB);
        int maxRoot = Math.max(rootA,rootB);

        parent[maxRoot] = minRoot;
    }

    static int findRoot(int a){
        if(a==parent[a])
            return a;
        return parent[a] = findRoot(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        int[][] map = new int[n][4];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int indx = i;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[i][0] = indx;
            map[i][1] = x;
            map[i][2] = y;
            map[i][3] = z;
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        //x를 기준으로 sort한다.
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for(int i=1;i<n;i++)
            queue.add(new int[]{map[i-1][0],map[i][0],Math.abs(map[i][1]-map[i-1][1])});

        //y를 기준으로 sort한다.
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for(int i=1;i<n;i++)
            queue.add(new int[]{map[i-1][0],map[i][0],Math.abs(map[i][2]-map[i-1][2])});

        //z를 기준으로 sort한다.
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3]-o2[3];
            }
        });

        for(int i=1;i<n;i++)
            queue.add(new int[]{map[i-1][0],map[i][0],Math.abs(map[i][3]-map[i-1][3])});

        long answer = 0;
        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            int a = cur[0];
            int b = cur[1];
            int val = cur[2];

            if(findRoot(a)!=findRoot(b)){
                union(a,b);
                answer+=val;
            }
        }
        System.out.print(answer);
    }
}
