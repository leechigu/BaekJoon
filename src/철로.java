import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 철로 {

    static int[][] map;
    static int n;
    static int d;
    static int max = 0;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void check(int r){
        while(!queue.isEmpty() && queue.peek()<r-d){
            queue.poll();
        }
        max = Math.max(queue.size(),max);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][0] = Math.min(a,b);
            map[i][1] = Math.max(a,b);
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        d = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            if(map[i][1]-map[i][0]>d)
                continue;
            queue.add(map[i][0]);
            check(map[i][1]);
        }
        System.out.print(max);
    }
}
