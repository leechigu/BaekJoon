import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유럽여행 {

    static int[] parents;
    static int[] costs;
    static int n;

    static void union(int a,int b){

        int rootA = findRoot(a);
        int rootB = findRoot(b);

        parents[rootA] = rootB;
    }

    static int findRoot(int a){
        if(a==parents[a]){
            return a;
        }
        return parents[a] = findRoot(parents[a]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parents = new int[n];
        int p = Integer.parseInt(st.nextToken());
        costs = new int[n];

        for(int i=0;i<n;i++){
            parents[i] = i;
            costs[i] = Integer.parseInt(br.readLine());
        }

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[2] - o2[2];
            }
        });

        for(int i=0;i<p;i++){

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());

            pq.add(new int[]{s,e,l*2+costs[e]+costs[s]});
        }

        int answer = 0;

        int cur = -1;

        while(!pq.isEmpty()){

            int[] poll = pq.poll();
            int s = poll[0];
            int e = poll[1];
            int l = poll[2];

            if(findRoot(s)!=findRoot(e)){

                System.out.println((s+1) + " -> " + (e+1) + " cost = "+ l);

                union(s,e);
                answer+=l;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,costs[i]);
        }

        System.out.println(answer + min);

        for(int i=0;i<n;i++){
            System.out.println((i+1)+ " -> " + (findRoot(i)+1));
        }

    }
}
