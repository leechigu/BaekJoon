import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로_dfs_map {

    static boolean[] isVisited;
    static int[] min;
    static int start;
    static Map<Integer, Map<Integer,Integer>> map;


    public static void dfs(int cur, int cost){

        if(min[cur]>cost){
            min[cur] = cost;
        }else{
            return;
        }
        if(isVisited[cur])
            return;
        isVisited[cur] = true;

        Map<Integer,Integer> tempMap= map.get(cur);

        if(tempMap != null) {
            for (int key : tempMap.keySet()) {
                int nextCost = cost + tempMap.get(key);
                if (min[key] > nextCost)
                    dfs(key, nextCost);
            }
        }
        isVisited[cur] = false;
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

        isVisited = new boolean[v+1];
        map = new HashMap<>();

        for (int i = 1; i <=e; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Map<Integer,Integer> tempMap;
            if (map.containsKey(a)) {
                tempMap = map.get(a);
            } else {
                tempMap = new HashMap<>();
            }

            if(tempMap.containsKey(b)){
                if(tempMap.get(b)>c){
                    tempMap.put(b,c);
                }else{
                    continue;
                }
            }
            else{
                tempMap.put(b,c);
            }
            map.put(a, tempMap);
        }

        dfs(start,0);

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
