import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft_FAIL_다익스트라 {

    public static int n;
    public static int k;
    public static ArrayList<int[]>[] lists;
    public static int[] bldgs;
    public static int[] min;
    public static int target;

    public static int bfs(int start){


        System.out.println("start = "+start);

        boolean[] isFinished = new boolean[n];

        min = new int[n+1];

        Arrays.fill(min,Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });

        queue.add(new int[]{start,bldgs[start-1]});

        while(!queue.isEmpty()){

            int[] poll = queue.poll();

            int cur = poll[0];
            int curVal  = poll[1];

            System.out.println(cur +" , "+curVal);

            if(cur==target){
                return curVal;
            }

            if(lists[cur].isEmpty()){
                continue;
            }

            int maxVal = lists[cur].get(lists[cur].size()-1)[1];

            for(int[] nextData : lists[cur]){
                int next = nextData[0];
                if(min[next]<curVal+maxVal){
                    continue;
                }
                queue.add(new int[]{next,curVal+maxVal});
                //System.out.println(next +" , "+(maxVal+curVal));
            }

        }

        return min[target];

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n];

            for(int i=0;i<n;i++){
                lists[i] = new ArrayList<int[]>();
            }


            st = new StringTokenizer(br.readLine());

            bldgs = new int[n];
            for(int i=0 ;i<n;i++){
                bldgs[i]  = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(new int[]{b,bldgs[b-1]});

            int start = a;

            for(int i=1; i<k;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                lists[a].add(new int[]{b,bldgs[b-1]});
            }

            for(int i=0;i<n;i++){

                Collections.sort(lists[i], new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1]-o2[1];
                    }
                });
            }

            target = Integer.parseInt(br.readLine());

            //System.out.println("target =" + target);

            int answer = bfs(start);
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());

    }
}
