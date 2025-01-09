import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {

    static int[] parent;

    static int find(int a){
        if(a==parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        parent[find(a)] = find(b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v+1];

        for(int i=0;i<=v;i++)
            parent[i] = i;

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new int[]{a,b,c});
        }

        int seq = 0;
        int answer =0;

        while(!queue.isEmpty()){
            if(seq==v-1)
                break;

            int[] poll = queue.poll();
            int cur = poll[0];
            int next = poll[1];
            int val = poll[2];

            if(find(cur)!=find(next)){
                seq++;
                answer+=val;
                union(cur,next);
            }
        }

        System.out.print(answer);

    }
}
