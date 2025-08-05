import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 텀프로젝트 {

    public static int[] parent;
    public static boolean[] answer;


    public static void findRoot(int cur, int start, Set<Integer> set){

        set.add(cur);

        if(cur==start){
            for(int num : set){
                //System.out.println("cur = "+cur+" start = "+start + " num  = "+num);
                answer[num] = true;
            }
            return;
        }

        if(parent[cur]!=cur&&!set.contains(parent[cur])){
            findRoot(parent[cur],start,set);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            answer = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                parent[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=n;i++){
                if(answer[i]){
                    continue;
                }
                findRoot(parent[i],i,new HashSet<>());
            }

            int cnt = 0;
            for(int i=1;i<=n;i++){
                if(!answer[i]){
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

    }
}
