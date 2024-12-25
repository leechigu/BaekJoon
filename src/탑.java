import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tower = new int[n+1];

        for(int i=1;i<=n;i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n+1];

        Stack<int[]> stack = new Stack<>();

        for(int i=1;i<=n;i++){
            stack.add(new int[]{tower[i],i});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[] cur = stack.pop();
        queue.add(cur);

        while(!stack.isEmpty()){

            cur = stack.pop();
            int curVal = cur[0];
            int curIndx = cur[1];

            while(true){

               if(queue.isEmpty())
                   break;

                int[] poll = queue.poll();
                int val = poll[0];
                int indx = poll[1];

                if(val>curVal){
                    queue.add(poll);
                    break;
                }else{
                    answer[indx]= curIndx;
                }
            }
            queue.add(cur);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}
