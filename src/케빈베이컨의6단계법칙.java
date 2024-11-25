import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    static boolean[] isVisited;
    static ArrayList<Integer>[] lists;
    static int min;
    static int[][] result;

    static void bfs(int start){

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curIndx = cur[0];

            if(isVisited[curIndx])
                continue;
            isVisited[curIndx] = true;
            int curDepth = cur[1];

            result[start][curIndx] = curDepth;

            ArrayList<Integer> list = lists[curIndx];
            for(int next : list){
                if(!isVisited[next])
                    queue.add(new int[]{next,curDepth+1});
            }

        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        lists = new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            lists[i] = new ArrayList<>();
        }


        for(int i=0;i<m;i++){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);

        }

        int minPerson = Integer.MAX_VALUE;
        min = Integer.MAX_VALUE;
        result = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            isVisited = new boolean[n+1];
            bfs(i);

            int sum = 0;
            for(int j=1;j<=n;j++){
                sum+=result[i][j];
            }
            if(sum<min){
                min = sum;
                minPerson = i;
            }
        }
        System.out.println(minPerson);
    }
}
