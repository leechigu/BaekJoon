import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집 {

    public static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        int[] cnt = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            cnt[b]++;
        }

        for(int i=1;i<=n;i++)
            Collections.sort(lists[i]);

        boolean[] visited = new boolean[n+1];

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(cnt[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){

            int cur = queue.poll();
            answer.add(cur);

            for(int next : lists[cur]){
                cnt[next]--;
                if(cnt[next]==0){
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int ans: answer){
            sb.append(ans).append(" ");
        }
        System.out.print(sb.toString());

    }
}
