import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시분할계획 {
    static int[] parent;

    static int findRoot(int a){
        if (a==parent[a])
            return a;
        return parent[a] = findRoot(parent[a]);
    }

    static void union(int a,int b){
        parent[findRoot(a)] = findRoot(b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            queue.add(new int[]{a,b,val});
        }

        int maxVal = -1;
        int answer = 0;

        //Array에 담고 sort 해도 되나?
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            int val = cur[2];

            if(findRoot(a)!=findRoot(b)){
                union(a,b);
                answer+=val;
                maxVal = Math.max(maxVal,val);
            }
        }

        System.out.println(answer-maxVal);
    }
}
