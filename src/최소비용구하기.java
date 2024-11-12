import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기 {


    static ArrayList<int[]>[] lists;
    static boolean[] isVisited;
    static int[] min;

    static int bfs(int start,int end){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });

        queue.add(new int[]{start,0});
        min[start] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            if(isVisited[curIndx])
                continue;
            isVisited[curIndx] = true;

            if(curIndx == end)
                continue;


            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1] + curVal;

                if (min[nextIndx] > nextVal) {
                    min[nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx,nextVal});
                }
            }
        }
        return min[end];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        input = br.readLine();
        int m = Integer.parseInt(input);

        min = new int[n+1];
        Arrays.fill(min,Integer.MAX_VALUE);
        isVisited = new boolean[n+1];
        lists = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<m;i++){
            input = br.readLine();
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,c});
            //lists[b].add(new int[]{a,c});
        }

        input = br.readLine();
        st = new StringTokenizer(input);

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start,end));

    }
}
