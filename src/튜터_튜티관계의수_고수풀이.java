import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 튜터_튜티관계의수_고수풀이 {

    static ArrayList<Integer>[] edge;
    static boolean[] isVisited;

    static long dfs(int cur){
        long answer = 1;
        isVisited[cur] = true;

        for(int next : edge[cur]){
            if(isVisited[next])
                continue;
            isVisited[next]= true;
            answer += dfs(next);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n+1];
        edge = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            edge[i] = new ArrayList<>();
        }


        for(int i=0;i<m;i++){
            input = br.readLine();
            st = new StringTokenizer(input);

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edge[u].add(v);
            edge[v].add(u);
        }

        long answer = 1;

        for(int i=1;i<=n;i++){
            answer = (answer *  dfs(i))%1000000007;
        }
        System.out.println(answer);
    }
}
