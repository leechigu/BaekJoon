import java.io.*;
import java.util.*;

public class 최소값찾기_deque {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int l = Integer.parseInt(splitStr[1]);

        input = br.readLine();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input);
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new LinkedList<>();

        for(int i=0;i<n;i++){

            if(i<l){
            }
            else{
                while(true){
                    if(!deque.isEmpty()&&deque.peekFirst()[1]<=i-l)
                        deque.pollFirst();
                    else
                        break;
                }
            }

            while(true){
                if(!deque.isEmpty()&&deque.peekLast()[0]>=arr[i])
                    deque.pollLast();
                else
                    break;
            }
            deque.offerLast(new int[]{arr[i],i});
            bw.write(deque.peekFirst()[0]+" ");
        }


        bw.flush();
        bw.close();
    }
}
