import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_2 {
    static int[] arr;
    static boolean[] isVisited;
    static StringBuilder sb;

    public static void dfs(int cur, int curIndx,int target){
        if(cur == target){
            for(int i=0;i<arr.length;i++)
                if(isVisited[i])
                    sb.append(i+1).append(" ");
            sb.append("\n");
            return;
        }


        for(int i=curIndx;i<arr.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                dfs(cur+1,i,target);
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

        arr = new int[n];
        isVisited = new boolean[n];
        sb = new StringBuilder();

        dfs(0,0,m);

        System.out.println(sb);
    }
}
