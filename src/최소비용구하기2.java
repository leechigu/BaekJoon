import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2 {


    static ArrayList<int[]>[] lists;
    static int[] min;
    static boolean[] isVisited;
    static int[] posHistory;

    static int bfs(int start,int end){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });

        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int pos = cur[0];
            int val = cur[1];

            isVisited[pos] = true;

            if(pos == end)
                break;

            for(int[] next : lists[pos]){

                int nextPos = next[0];
                int nextVal = next[1]+val;

                if(!isVisited[nextPos]){
                    if(min[nextPos]>nextVal){
                        min[nextPos] = nextVal;
                        posHistory[nextPos] = pos;
                        queue.add(new int[]{nextPos,nextVal});
                    }
                }
            }
        }
        return min[end];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        lists = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        min = new int[n+1];
        posHistory = new int[n+1];
        Arrays.fill(min,Integer.MAX_VALUE);

        for(int i=0;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int val = bfs(start, end);

        StringBuilder sb = new StringBuilder();
        sb.append(val).append("\n");

        int cur = end;
        int cnt = 1;

        ArrayList<Integer> posList = new ArrayList<>();
        posList.add(end);
        while(true){
            cur = posHistory[cur];
            posList.add(cur);
            cnt++;
            if(cur == start){
                break;
            }
        }

        sb.append(cnt).append("\n");

        for(int i=posList.size()-1;i>=0;i--){
            int pos = posList.get(i);
            sb.append(pos).append(" ");
        }

        System.out.print(sb);

    }
}
