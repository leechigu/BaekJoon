import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_dfs_list {

    static boolean[] isVisited;
    static int[] min;
    static int start;
    static ArrayList<int[]>[] list;


    public static void dfs(int cur, int cost){

        min[cur] = cost;

        if(isVisited[cur])
            return;
        isVisited[cur] = true;

        ArrayList<int[]> ints = list[cur];

        for (int[] next : ints) {
            int nextCost = cost + next[1];
            if (min[next[0]] > nextCost)
                dfs(next[0], nextCost);
        }
        isVisited[cur] = false;
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

        for(int i=0;i<v+1;i++){
            Collections.sort(list[i], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
        }


        dfs(start,0);

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
