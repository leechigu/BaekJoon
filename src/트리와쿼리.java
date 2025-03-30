import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리와쿼리 {

    static int[] len;
    static Map<Integer,Integer> map = new HashMap<>();

    static ArrayList<Integer>[] inputs;
    static ArrayList<Integer>[] lists;

    static void makeTree(int cur, int parent){
        for(int next : inputs[cur]){
            if(next != parent){
                lists[cur].add(next);
                makeTree(next,cur);
            }
        }
    }

    static int countSubtreeNodes(int cur){
        len[cur] = 1;
        for(int next : lists[cur])
            len[cur] += countSubtreeNodes(next);
        return len[cur];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        len = new int[n+1];
        len[r] = 0;
        inputs = new ArrayList[n+1];
        lists = new ArrayList[n+1];

        for(int i=0;i<=n;i++) lists[i] = new ArrayList<Integer>();
        for(int i=0;i<=n;i++) inputs[i] = new ArrayList<Integer>();

        int[][] input = new int[n][2];

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inputs[a].add(b);
            inputs[b].add(a);
        }

        makeTree(r,-1);
        countSubtreeNodes(r);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            int query = Integer.parseInt(br.readLine());
            sb.append(len[query]).append("\n");
        }
        System.out.print(sb);
    }
}
