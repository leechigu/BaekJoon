import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lists = new ArrayList[n+1];
        int[] childs = new int[n+1];

        for(int i=1;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt-1;j++){
                int next = Integer.parseInt(st.nextToken());
                lists[cur].add(next);
                childs[next]++;
                cur = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++){
            if(childs[i]==0){
                queue.add(i);
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        while(!queue.isEmpty()){

            int cur = queue.poll();
            answerList.add(cur);

            for(int next: lists[cur]){
                childs[next]--;
                if (childs[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(childs[i]!=0){
                System.out.println(0);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int answer : answerList){
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());

    }
}
