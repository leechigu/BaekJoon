import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과M_9_고수풀이 {
    static boolean[] isVisited;
    static int[] arr,ans;
    static StringBuilder sb;
    public static void dfs(int cur,int target){
        if(cur==target){
            for(int x : ans)
                sb.append(x).append(" ");
            sb.append("\n");
            return;
        }
        int lastUsed = 0;
        for(int i=0;i<arr.length;i++){
            if(!isVisited[i]&& arr[i]!=lastUsed){
                isVisited[i] = true;
                lastUsed = arr[i];
                ans[cur] = arr[i];
                dfs(cur+1,target);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");
        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);
        splitStr = br.readLine().split(" ");
        isVisited = new boolean[n];
        arr = new int[n];
        ans = new int[m];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(splitStr[i]);
        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0,m);
        System.out.println(sb);
    }
}
