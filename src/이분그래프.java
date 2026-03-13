import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이분그래프 {


    static List<Integer>[] lists;
    static int[] arr;
    static boolean[] isVisited;

    static boolean result = true;

    static void dfs(int st){

        if(!result)
            return;

        int curVal = arr[st];
        for(int next : lists[st]){
            if(arr[next]==0){
                if(curVal==1){
                    arr[next]=2;
                }else if(curVal==2){
                    arr[next]=1;
                }
            }else{
                if(arr[next]==curVal){
                    result = false;
                    return;
                }
            }

            if(isVisited[next]){
                continue;
            }
            isVisited[next] = true;
            dfs(next);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(k-->0){

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lists = new ArrayList[v+1];
            for(int i=0;i<=v;i++){
                lists[i] = new ArrayList<>();
            }

            isVisited = new boolean[v+1];
            arr = new int[v+1];

            for(int i=0;i<e;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                lists[a].add(b);
                lists[b].add(a);
            }
            result = true;
            for(int i=1;i<=v;i++){
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    arr[i] = 1;
                    dfs(i);
                }
            }

            if(result){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
}
