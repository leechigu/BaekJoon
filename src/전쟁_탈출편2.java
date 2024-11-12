import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전쟁_탈출편2 {

    static int target;
    static ArrayList<int[]>[] lists;
    static int[] min;
    static int[] min2;
    static boolean[] isVisited;
    static ArrayList<Integer> lastList;
    static void bfs(){
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            if(isVisited[curIndx])
                continue;

            isVisited[curIndx] = true;

            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1]+curVal;

                if(min[nextIndx]>nextVal) {
                    min[nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx, nextVal});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        target = n;
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            lists[i] = new ArrayList<>();
        lastList = new ArrayList<>();
        isVisited = new boolean[n+1];
        min = new int[n+1];
        min2 = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);


        for(int i=1;i<=m;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,c});
        }

        bfs();
        isVisited = new boolean[n+1];
    }
}