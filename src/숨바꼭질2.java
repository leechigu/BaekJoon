import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질2 {

/*    static int cnt=0;
    static int n;
    static int target;
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;*/
    public static int[][] arr;
/*    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{n,0});
        isVisited[n] = true;
        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int cur = poll[0];
            int seq = poll[1];

            if(cur==target){
                if(seq<=min) {
                    if(seq==min) {
                        cnt++;
                    }
                    else {
                        min = seq;
                        cnt = 1;
                    }
                }
            }

            int nextSeq = seq+1;
            int nextA = cur-1;
            int nextB = cur+1;
            int nextC = cur*2;

            if(nextSeq>min)
                continue;

            if(nextA>0)
                queue.add(new int[]{nextA,nextSeq});
            queue.add(new int[]{nextB,nextSeq});
            queue.add(new int[]{nextC,nextSeq});
        }

    }*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[100001][2];
        for(int i=0;i<=100000;i++) {
            arr[i][0] = 100001;
        }

        for(int i=0;i<=n;i++) {
            arr[i][0] = n - i;
            arr[i][1] = 1;
        }

        for(int i=n+1;i<arr.length;i++){
            if((i & 1)==1) {
                arr[i][0] = Math.min(arr[i-1][0] + 1, arr[(i+1)/2][0] + 2);
                if(arr[i][0] == arr[i-1][0] + 1){
                    arr[i][1] += arr[i-1][1];
                }
                if(arr[i][0] == arr[(i+1)/2][0] + 2) {
                    arr[i][1] += arr[(i + 1) / 2][1];
                }
            }
            else {
                arr[i][0] = Math.min(arr[i-1][0]+1, arr[i/2][0]+1);
                if(arr[i][0] == arr[i-1][0] + 1) {
                    arr[i][1] += arr[i - 1][1];
                }
                if(arr[i][0] == arr[i/2][0] + 1) {
                    arr[i][1] += arr[i / 2][1];
                }
            }
        }
        System.out.println(arr[k][0]);
        System.out.print(arr[k][1]);

    }
}
