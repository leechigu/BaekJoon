import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 서강그라운드 {


    static int[] arr;

    static ArrayList<int[]>[] lists;
    static int n;
    static int m;
    static boolean[] isVisited;

    static int max = -1;


    public static void bfs(int cur){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        isVisited[cur] = true;
        queue.add(new int[]{cur,0});

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int curIndx = poll[0];
            int curLen = poll[1];

            for(int[] next: lists[curIndx]){
                int nextIndx = next[0];
                int nextLen = next[1]+curLen;
                if(nextLen<=m){
                    isVisited[nextIndx] = true;
                    queue.add(new int[]{nextIndx,nextLen});

                }
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            if(isVisited[i]){
                answer+=arr[i];
            }
        }
        max = Math.max(answer,max);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        lists = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }


        for(int i=1;i<=r;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,l});
            lists[b].add(new int[]{a,l});

        }

        for(int i=1;i<=n;i++){
            isVisited = new boolean[n+1];
            bfs(i);
        }

        System.out.println(max);

    }
}
