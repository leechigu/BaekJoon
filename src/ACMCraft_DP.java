import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft_DP {

    public static int n;
    public static int k;
    public static ArrayList<Integer>[] lists;
    public static int[] bldgs;
    public static int target;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n+1];

            for(int i=1;i<=n;i++){
                lists[i] = new ArrayList<>();
            }


            st = new StringTokenizer(br.readLine());

            bldgs = new int[n+1];
            for(int i=1 ;i<=n;i++){
                bldgs[i]  = Integer.parseInt(st.nextToken());
            }

            int[] childs = new int[n+1];

            for(int i=0; i<k;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                lists[a].add(b);
                childs[b]++;
            }

            target = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int[] answer = new int[n+1];

            for(int i=1;i<=n;i++){
                answer[i] = bldgs[i];
                if(childs[i]==0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int cur = queue.poll();
                //System.out.println(cur);
                for(int next : lists[cur]){
                    answer[next] = Math.max(answer[next],answer[cur]+bldgs[next]);
                    childs[next]--;
                    if(childs[next]==0){
                        queue.add(next);
                    }
                }
            }

            sb.append(answer[target]).append("\n");
        }

        System.out.println(sb.toString());

    }
}
