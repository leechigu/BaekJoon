import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 동전2_dfs_bfs_fail {

    static int n;
    static int k;
    static int min = Integer.MAX_VALUE;
    static int[] coins;

    //dfs or bfs
    static void dfs(int val,int depth){

        if(depth>min||val>k)
            return;

        if(val==k){
            min = Math.min(min,depth);
            return;
        }

        for(int i=0;i<n;i++){
            dfs(val+coins[i],depth+1);
        }
    }


    static void bfs(){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o2[1]-o1[1];
            }
        });

        for(int i=0;i<n;i++){
            queue.add(new int[]{coins[i],1});
        }

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int val = poll[0];
            int depth = poll[1];

            if(depth>min)
                continue;

            if(val==k){
                min = Math.min(min,depth);
                //return;
            }

            for(int i=0;i<n;i++){
                if(val+coins[i]<=k)
                    queue.add(new int[]{val+coins[i],depth+1});
            }
        }
    }

    static int bfs2(){

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.add(new int[]{coins[i],1});
        }
        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int val = poll[0];
            int depth = poll[1];

            if(val==k){
                return depth;
            }

            for(int i=0;i<n;i++){
                if(val+coins[i]<=k)
                    queue.add(new int[]{val+coins[i],depth+1});
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];

        for(int i=0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        bfs();
        System.out.println(min);

        //System.out.print(bfs2());
    }
}
