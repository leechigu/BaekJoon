import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lists = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        int[] childs = new int[n+1];

        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            childs[b]++;
            if(!arrList.contains(a)){
                arrList.add(a);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int[] list = new int[n+1];

        for(int i=0;i<arrList.size();i++){
            int cur = arrList.get(i);
            if(childs[cur]==0){
                queue.offer(cur);
                while(!queue.isEmpty()){
                    int t = queue.poll();
                    //System.out.println(t);
                    answer.add(t);
                    list[t]++;
                    for(int next : lists[t]){
                        childs[next]--;
                        if(childs[next]==0){
                            queue.add(next);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();


        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i)).append(" ");
        }

        for(int i=1;i<=n;i++){
            if(list[i]==0){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
