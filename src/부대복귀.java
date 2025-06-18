import java.util.*;

class 부대복귀 {
    static ArrayList<Integer>[] lists;
    static int[] min;

    public void bfs(int n, int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});

        min = new int[n+1];
        for(int i=0;i<=n;i++){
            min[i] = Integer.MAX_VALUE;
        }
        min[start] = 0;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int cur = poll[0];
            int curVal = poll[1];
            int nextVal = curVal+1;

            for(int next : lists[cur]){
                if(nextVal<=min[next]) {
                    min[next]= nextVal;
                    queue.add(new int[]{next, nextVal});
                }
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        lists = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){

            int[] road = roads[i];
            int x = road[0];
            int y = road[1];

            lists[x].add(y);
            lists[y].add(x);
        }



        int[] answer = new int[sources.length];

        bfs(n,destination);

        for(int i=0;i<sources.length;i++){

            int source = sources[i];
            if(min[source]==Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = min[source];
            }
        }
        return answer;
    }
}