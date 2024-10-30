import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 숨바꼭질 {

    public static int min;
    public static int k;

    public static int[] arr = new int[100001];

    public static void bfs(int n,int seq){


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n,seq});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curN = cur[0];
            int curSeq = cur[1];

            if(curSeq>min){
                continue;
            }
            if(curN == k){
                min = Math.min(min,curSeq);
                continue;
            }
            curSeq++;
            if(curN<k){
                if(curN*2<100001&&arr[curN*2]>curSeq){
                    queue.add(new int[]{curN*2,curSeq});
                    arr[curN*2] = curSeq;
                }
                if(curN+1<100001&&arr[curN+1]>curSeq){
                    queue.add(new int[]{curN+1,curSeq});
                    arr[curN+1] = curSeq;
                }
            }

            if(curN>=1){
                if(arr[curN-1]>curSeq){
                    queue.add(new int[]{curN-1,curSeq});
                    arr[curN-1] = curSeq;
                }
            }

        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        k = Integer.parseInt(splitStr[1]);

        min = Math.max(n,k)-Math.min(n,k);

        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.MAX_VALUE;

        bfs(n,0);

        System.out.println(min);

    }
}
