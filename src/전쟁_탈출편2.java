import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전쟁_탈출편2 {

    static int target;
    static ArrayList<int[]>[] lists;
    static int[] min;
    static int[] min2;
    static boolean[] isVisited;
    static int[] prevNum;
    static ArrayList<Integer> lastList;

    static void bfs(){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];
            int curVal = cur[1];

            prevNum[1] = -1;

            if(isVisited[curIndx])
                continue;

            isVisited[curIndx] = true;

            for(int[] next : lists[curIndx]){
                int nextIndx = next[0];
                int nextVal = next[1]+curVal;

                if(min[nextIndx]>nextVal) {
                    prevNum[nextIndx] = curIndx;
                    min[nextIndx] = nextVal;
                    queue.add(new int[]{nextIndx, nextVal});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        target = n;
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            lists[i] = new ArrayList<>();
        lastList = new ArrayList<>();
        isVisited = new boolean[n+1];
        prevNum = new int[n+1];
        min = new int[n+1];
        min2 = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1] = 0;
        Arrays.fill(prevNum, -1);
        //Arrays.fill(min2, Integer.MAX_VALUE);


        for(int i=1;i<=m;i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            lists[a].add(new int[]{b,c});
            lists[b].add(new int[]{a,c});
        }

        bfs();

        //lists에서 최단거리 간선 제거
        int curIndx = n;
        while(true){
            if(prevNum[curIndx]==-1)
                break;

            int prev = prevNum[curIndx];


            int val = min[curIndx] - min[prev];
            //System.out.println(prev +" - >"+ curIndx + " val  = " + val);
            //System.out.println(prev +" lists size + " + lists[prev].size());
            //System.out.println(curIndx +" lists size + " + lists[curIndx].size());
            for (int i = 0; i < lists[prev].size(); i++) {
                int[] x = lists[prev].get(i);
                if (x[0] == curIndx && x[1] == val) {
                    int[] remove = lists[prev].remove(i);
                    //System.out.println(prev + " " + remove[0] + " " + remove[1]);
                    break;
                }
            }
            for (int i = 0; i < lists[curIndx].size(); i++) {
                int[] x = lists[curIndx].get(i);
                if (x[0] == prev && x[1] == val) {
                    int[] remove = lists[curIndx].remove(i);
                    //System.out.println(remove[0] + " " + curIndx + " " + remove[1]);
                    break;
                }
            }
            curIndx = prev;
        }

        Arrays.fill(min, Integer.MAX_VALUE);
        isVisited = new boolean[n+1];
        bfs();
        System.out.println(min[n]);
    }
}