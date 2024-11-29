
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의지름 {

    static ArrayList<int[]>[] lists;
    static boolean[] isVisited;
    static int maxLen = -1;
    static int index;
    static void dfs(int curIndx,int curLen){

        if(curLen > maxLen){
            maxLen = curLen;
            index = curIndx;
        }

        for(int[] next : lists[curIndx]){

            if(isVisited[next[0]]){
                continue;
            }
            isVisited[next[0]] = true;
            dfs( next[0] , curLen+next[1] );

        }



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        isVisited = new boolean[n+1];
        lists = new ArrayList[n+1];

        for(int i=0;i<=n;i++)
            lists[i] = new ArrayList<>();

        StringTokenizer st;

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            lists[parent].add(new int[]{child,val});
            lists[child].add(new int[]{parent,val});
        }

        isVisited[1] =true;
        dfs(1,0);
        //System.out.println(index);
        //int x = index;
        isVisited = new boolean[n+1];
        maxLen =-1;
        isVisited[index] =true;
        dfs(index,0);
        System.out.println(maxLen);
    }
}
