
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 외판원순회_bfs랑비트마스킹 {

    static List<int[]>[] lists;

    static int min =  Integer.MAX_VALUE;
    static int n;
    static int maxBitSize;


    static void bfs(int st){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        queue.add(new int[]{st,0,0});

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];
            int curStatus = cur[2];

            if(curStatus == maxBitSize-1){
                min = Math.min(min,curVal);
                return;
            }

            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1];

                if((curStatus & (1<<nextIndx))!=0){
                    continue;
                }

                queue.add(new int[]{nextIndx,nextVal+curVal,curStatus|1<<nextIndx});

            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        lists = new ArrayList[n];
        for(int i=0;i<n;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int val = Integer.parseInt(st.nextToken());
                if(val==0){
                    continue;
                }

                lists[i].add(new int[]{j,val});
            }
        }
        maxBitSize = 1<<n;

        bfs(0);

        System.out.println(min);
    }
}
