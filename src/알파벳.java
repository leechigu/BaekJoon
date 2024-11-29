import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알파벳 {


    static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] arr;
    static int r;
    static int c;
    static boolean[][] isVisited;
    static int max = -1;

    static HashSet<Integer> set = new HashSet<>();

    public static void dfs(int y, int x,int depth){

        max = Math.max(max,depth);

        for(int i=0;i<4;i++){
            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];
            if(nextY<=0||nextY>r){
                continue;
            }
            if(nextX<=0||nextX>c) {
                continue;
            }
            if(isVisited[nextY][nextX]){
                continue;
            }
            if(set.contains(arr[nextY][nextX])){
                continue;
            }
            isVisited[nextY][nextX] = true;
            set.add(arr[nextY][nextX]);
            dfs(nextY,nextX,depth+1);
            set.remove(arr[nextY][nextX]);
            isVisited[nextY][nextX] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        isVisited = new boolean[r+1][c+1];
        arr = new int[r+1][c+1];

        for(int i=1;i<=r;i++){
            char [] chars = br.readLine().toCharArray();
            for(int j=1;j<=c;j++){
                arr[i][j] = chars[j-1]-'A';
            }
        }
        set.add(arr[1][1]);
        dfs(1,1,1);
        System.out.println(max);


    }
}
