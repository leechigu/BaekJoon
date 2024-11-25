import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {

    static ArrayList<Integer>[] edges;
    static int[][] map;
    static void bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int temp : edges[cur]){
                if(map[a][temp]==1)
                    continue;
                map[a][temp]=1;
                queue.add(temp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n+1];
        map = new int[n+1][n+1];

        for(int i=0;i<=n;i++)
            edges[i] = new ArrayList<>();

        for(int i=1;i<=n;i++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            for(int j =1; j<=n;j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur ==1){
                    edges[i].add(j);
                }
            }
        }

        for(int i=1;i<=n;i++)
            bfs(i);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
