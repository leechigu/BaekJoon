import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_bfs_list {

    static boolean[] isVisited;
    static int[] min;
    static int start;
    static ArrayList<int[]>[] list;


    public static void bfs(){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(isVisited[cur[0]])
                continue;
            isVisited[cur[0]] = true;

            ArrayList<int[]> nextList = list[cur[0]];
            for(int[] next : nextList){
                int nextVal = cur[1] + next[1];
                if(nextVal<min[next[0]]){
                    min[next[0]] = nextVal;
                    queue.add(new int[]{next[0],nextVal});
                }

            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        min = new int[v+1];
        for(int i=0;i<v+1;i++)
            min[i] = Integer.MAX_VALUE;

        isVisited = new boolean[v+1];

        list = new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1;i<=e;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
        }

        min[start] = 0;

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<min.length;i++){
            if(min[i]!=Integer.MAX_VALUE)
                sb.append(min[i]).append("\n");
            else
                sb.append("INF").append("\n");
        }
        System.out.print(sb);
    }
}
