import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {

    static ArrayList<int[]>[] lists;
    static int[] min;
    static int[][] toTargetMin;
    static boolean[] isVisited;
    static int n;
    static int x;

    static void bfs(int start){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{start,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            if(isVisited[curIndx])
                continue;
            isVisited[curIndx] = true;

            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1] + curVal;
                if(nextVal<min[nextIndx]){
                    min[nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx,nextVal});
                }
            }
        }
    }


    static void bfs2(int i){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        queue.add(new int[]{i,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            if(isVisited[curIndx])
                continue;
            isVisited[curIndx] = true;

            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1] + curVal;
                if(nextVal<toTargetMin[i][nextIndx]){
                    toTargetMin[i][nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx,nextVal});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        min =new int[n+1];
        toTargetMin = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            Arrays.fill(toTargetMin[i],Integer.MAX_VALUE);

        Arrays.fill(min,Integer.MAX_VALUE);
        min[x] = 0;
        isVisited = new boolean[n+1];
        lists = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            lists[i] = new ArrayList<>();
        for(int i=1;i<=m;i++){

            input = br.readLine();
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,val});
        }
        bfs(x);

        for(int i=1;i<min.length;i++){
            isVisited = new boolean[n+1];
            bfs2(i);
        }

        int max = -1;

        for(int i=1;i<=n;i++){
            int a = min[i];
            int b = toTargetMin[i][x];
            if(a+b>max)
                max = a+b;
        }
        System.out.println(max);

    }
}
