import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 최단경로_BFS {

    static boolean[] isVisited;
    static int[] min;
    static int start;
    static ArrayList<int[]>[] arrayList;


    public static void bfs(int cur, int cost){



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        min = new int[v+1];
        for(int i=0;i<v+1;i++)
            min[i] = Integer.MAX_VALUE;

        //isVisited = new boolean[v+1];

        arrayList = new ArrayList[v+1];

        int[][] arr = new int[v+1][3];

        for (int i = 1; i <=e; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());



            arr[i] = new int[]{a,b,c};
        }

        bfs(start,0);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<min.length;i++){
            if(min[i]!=Integer.MAX_VALUE)
                sb.append(min[i]).append("\n");
            else
                sb.append("INF").append("\n");
        }
        System.out.print(sb);


    }
}
