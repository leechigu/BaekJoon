import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {

    static ArrayList<int[]>[] nodes;
    static int v1;
    static int v2;
    static int[] min;
    static boolean[] isVisited;
    static int n;

    static void bfs(int start, int target){

        isVisited = new boolean[n+1];
        min = new int[n+1];
        for(int i=0;i<n+1;i++)
            min[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> queue =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curWeight = cur[1];
            if(isVisited[curIndx])
                continue;
            isVisited[curIndx] = true;

            if(curIndx==target){
                min[curIndx] = curWeight;
                break;
            }

            for(int[] next : nodes[curIndx]){
                if(min[next[0]]>curWeight+next[1]) {
                    queue.add(new int[]{next[0], curWeight + next[1]});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        min = new int[n+1];

        for(int i=0;i<n+1;i++)
            min[i] = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            nodes[i] = new ArrayList<int[]>();
        }


        for(int i=1;i<=e;i++){
            input = br.readLine();
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[a].add(new int[]{b,c});
            nodes[b].add(new int[]{a,c});
        }

        input = br.readLine();
        st = new StringTokenizer(input);
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        bfs(1,v1);
        int head = min[v1];

        bfs(1,v2);
        int head2 = min[v2];

        bfs(v1,v2);
        int mid = min[v2];

        bfs(v2,v1);
        int mid2 = min[v1];

        bfs(v1,n);
        int tail2 = min[n];

        bfs(v2,n);
        int tail = min[n];


        if(head==Integer.MAX_VALUE||mid==Integer.MAX_VALUE||tail==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            int min = Math.min(head+mid+tail,head2+mid2+tail2);
            System.out.println(min);
        }

    }
}
