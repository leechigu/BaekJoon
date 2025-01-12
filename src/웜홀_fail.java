import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 웜홀_fail {

    static ArrayList<int[]>[] lists;
    static int[] min;
    static boolean[] isVisited;
    static int n;

    static int bfs(int st){

        isVisited = new boolean[n+1];
        min = new int[n+1];
        Arrays.fill(min,Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        queue.add(new int[]{st,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int curVal = poll[1];
            isVisited[cur] = true;
            for(int[] nxt: lists[cur]){

                int next = nxt[0];
                int nextVal = nxt[1]+curVal;

                if(next==st){
                    if(nextVal>=0){
                        return 1;
                    }else{
                        return -1;
                    }
                }

                if(min[next]>nextVal){
                    min[next] = nextVal;
                    queue.add(new int[]{next,nextVal});
                }
            }
        }
        return min[st];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n+1];
            for(int i=0;i<=n;i++)
                lists[i] = new ArrayList<>();

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new int[]{e,t});
                lists[e].add(new int[]{s,t});
            }
            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new int[]{e,-t});
            }

            boolean isAns = false;
            for(int i=1;i<=n;i++){
                if(bfs(i)<0) {
                    isAns = true;
                    break;
                }
            }
            if(isAns)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");

        }
        System.out.print(sb);
    }
}
