import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 텀프로젝트{
    static int n;
    static int[] arr;
    static boolean[] isTeam;
    static boolean[] visited;
    static int answer;
    public static void dfs(int cur){

        if(isTeam[cur]){
            return;
        }

        if(visited[cur]){
            isTeam[cur] = true;
            answer--;
        }
        visited[cur] = true;
        dfs(arr[cur]);
        isTeam[cur] = true;
        visited[cur] = false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            n= Integer.parseInt(br.readLine());
            arr = new int[n];
            isTeam = new boolean[n];
            visited = new boolean[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            answer = n;
            for(int i =0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken())-1;
                if(arr[i] == i) {
                    isTeam[i] = true;
                    answer--;
                }
            }
            for(int i =0; i<n; i++){
                if(!isTeam[i]){
                    dfs(i);
                }
            }

            sb.append(answer).append("\n");

        }
        System.out.print(sb.toString());
    }
}