import java.util.*;

public class DFS와BFS_new {

    static int arr[][];
    static boolean[] visited;

    public static void dfs(int v){
        visited[v] =true;
        System.out.print(v+" ");
        if(v==arr.length){
            return;
        }
        for(int i=1;i<arr.length;i++){
            if(1 == arr[v][i] &&visited[i]==false){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> que =new LinkedList<>();
        que.add(v);
        visited[v]=true;
        System.out.print(v+" ");
        while(!que.isEmpty()){
            int temp = que.poll();
            for(int i=1;i<arr.length;i++){
                if(arr[temp][i]==1&&visited[i]==false){
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();int m = sc.nextInt(); int v = sc.nextInt();
        arr = new int[n+1][n+1];
        int e1,e2;
        for(int i=0;i<m;i++){
            e1 = sc.nextInt();e2=sc.nextInt();
            arr[e1][e2]=1;
            arr[e2][e1]=1;
        }
        visited =new boolean[n+1];
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
}
