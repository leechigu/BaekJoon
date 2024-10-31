import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소값찾기_priorityQueue {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int l = Integer.parseInt(splitStr[1]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        input = br.readLine();

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input);
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<l;i++){
            priorityQueue.add(new int[]{arr[i],i});
            bw.write(priorityQueue.peek()[0]+" ");
        }

        for(int i=l;i<n;i++){
            priorityQueue.add(new int[]{arr[i],i});
            while(true){
                if(priorityQueue.peek()[1]<i-l+1) {
                    int[] poll = priorityQueue.poll();
                }
                else
                    break;
            }
            bw.write(priorityQueue.peek()[0]+" ");
        }

        bw.flush();
        bw.close();
    }
}
