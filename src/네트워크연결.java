import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 네트워크연결 {

    static int[] parent;
    static PriorityQueue<int[]> queue;

    static int find(int a){
        if(parent[a] == a)
            return a;
        return find(parent[a]);
    }

    static void union(int a, int b){
        parent[find(a)] = find(b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==b)
                continue;
            queue.add(new int[]{a,b,c});
        }

        int answer =0;
        int line = 0;
        while(!queue.isEmpty()){
            if(line==n-1)
                break;
            int[] cur = queue.poll();
            int curSt = cur[0];
            int curEd = cur[1];
            int curVal = cur[2];

            if(find(curSt)!=find(curEd)){
                line++;
                union(curSt,curEd);
                answer+=curVal;
            }
        }
        System.out.println(answer);
    }
}
