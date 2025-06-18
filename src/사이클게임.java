import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사이클게임 {

    static int n;
    static int m;
    static ArrayList<Integer>[] lists;

    static boolean[] isVisited;

    public static boolean dfs(int st,int cur){
        isVisited[cur] = true;

        for(int next : lists[cur]){
            if(isVisited[next]){
                if(cur==st){
                    return true;
                }
            }else{
                dfs(st,next);
            }
        }
        return false;
    }

    public static boolean checkCycle(){
        for(int i=0;i<n;i++){
            isVisited = new boolean[n];
            boolean temp = dfs(i,i);
            if(temp)
                return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n];

        for(int i=0;i<n;i++){
            lists[i] = new ArrayList<Integer>();
        }

        int answer = 0;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);

            if(checkCycle()){
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);
    }
}
