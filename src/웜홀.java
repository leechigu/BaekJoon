import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 웜홀 {

    static ArrayList<int[]>[] lists;
    static int[] dis;
    static int n;

    static boolean bellmanFord(int st){
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        boolean update = false;

        dis[st] = 0;

        for(int i=1;i<=n;i++){
            update = false;
            for(int j=1;j<=n;j++){
                for(int[] list : lists[j]){
                    int next = list[0];
                    int nextVal = list[1];
                    if(dis[j]==Integer.MAX_VALUE)
                        continue;
                    if(dis[next]> dis[j] + nextVal){
                        dis[next] = dis[j] + nextVal;
                        update = true;
                    }
                }
            }
            if(!update)
                break;
        }

        if(update){
            for(int i=1;i<=n;i++){
                for(int[] list : lists[i]){
                    int next = list[0];
                    int nextVal = list[1];
                    if(dis[i]==Integer.MAX_VALUE)
                        continue;
                    if(dis[next]>dis[i]+nextVal){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n+1];
            for(int i=0;i<=n;i++)
                lists[i] = new ArrayList<>();

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new int[]{e,t});
                lists[e].add(new int[]{s,t});
            }
            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                lists[s].add(new int[]{e,-t});
            }

            boolean isAns = false;
            for(int i=1;i<=n;i++){
                if(bellmanFord(i)) {
                    isAns = true;
                    break;
                }
            }
            if(isAns)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");

        }
        System.out.print(sb);
    }
}
