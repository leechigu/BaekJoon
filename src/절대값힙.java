import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1)-Math.abs(o2);
            }
        });

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){

            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                if(priorityQueue.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                Integer poll = priorityQueue.poll();
                sb.append(poll).append("\n");
            }else{
                priorityQueue.add(cur);
            }
        }
        System.out.print(sb);
    }
}
