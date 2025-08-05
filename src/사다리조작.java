import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {

    static int n;
    static int m;
    static int[][] map;
    static int min = 4;

    public static void dfs(int cnt){
        if(cnt>min){
            return;
        }
        if(check()){
            min = Math.min(min,cnt);
            return;
        }

        if(cnt==3){
            return;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j]!=1){
                    map[i][j] = 1;
                    dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static boolean check(){
        //System.out.println();
        for(int i=1;i<=n;i++){
            //System.out.println("start : "+1 + " " + i + " "+ i);
            if(!go(1,i,i))
                return false;
        }
        return true;
    }

    public static boolean go(int y,int x, int start){

        int nextX = x;
        if(x<n&&map[y][x]==1){
            //System.out.println("hit before : "+x);
            nextX++;
            //System.out.println("hit after : "+ nextX);
        }
        if(x>1&&map[y][x-1]==1){
            nextX--;
        }
        if(y==m){
            //System.out.println("finish : " + y + " " + nextX + " "+ start);
            return start == nextX;
        }

        return go(y+1,nextX,start);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m+1][n+1];

        for(int i=0;i<h;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }
        dfs(0);

        if(min>3)
            min = -1;
        System.out.print(min);


    }
}
