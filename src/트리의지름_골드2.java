import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의지름_골드2 {

    static ArrayList<int[]>[] lists;
    static int[] min;
    static boolean[] isVisited;
    static int v;
    static int[] bfs(int temp){

        isVisited = new boolean[v+1];
        min = new int[v+1];
        Arrays.fill(min,Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{temp,0});
        isVisited[temp] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            for(int[] next:lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1]+curVal;
                if(!isVisited[nextIndx]||min[nextIndx]>nextVal){
                    isVisited[nextIndx] = true;
                    min[nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx,nextVal});
                }
            }
        }
        int max = -1;
        int maxIndx=-1;
        for(int i=1;i<min.length;i++){
            if(i==temp)
                continue;
            int cur = min[i];
            if(cur==Integer.MAX_VALUE)
                continue;
            max = Math.max(max,cur);
            if(cur==max)
                maxIndx = i;
        }
        return new int[]{maxIndx,max};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        v = Integer.parseInt(br.readLine());
        lists = new ArrayList[v+1];
        for(int i=0;i<=v;i++)
            lists[i] = new ArrayList<>();

        for(int i=0;i<v;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1)
                    break;
                int dis = Integer.parseInt(st.nextToken());
                lists[start].add(new int[]{end,dis});
            }
        }

        int[] first = bfs(1);
        int[] result = bfs(first[0]);
        System.out.print(result[1]);
    }
}
