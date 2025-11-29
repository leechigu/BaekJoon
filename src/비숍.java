import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍 {

    static int max = -1;
    static int n;
    static int[][] map;

    static boolean[] d1;
    static boolean[] d2;

    public static void dfs(int cur, int cnt, boolean isEven){
        max = Math.max(cnt,max);

        int val = cur;
        while(val<n*n){
            int y = val/n;
            int x = val%n;

            if(isEven){
                if((y+x)%2!=0){
                    val++;
                    continue;
                }
            }else{
                if((y+x)%2==0){
                    val++;
                    continue;
                }
            }

            if(map[y][x]==1){
                int a = y+x;
                int b = y-x + (n-1);
                if(!d1[a] && !d2[b]) {
                    d1[a] = true;
                    d2[b] = true;
                    dfs(y * n + x + 1, cnt + 1, isEven);
                    d1[a] = false;
                    d2[b] = false;
                }

            }
            val++;
        }

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d1 = new boolean[2*n-1];
        d2 = new boolean[2*n-1];
        dfs(0,0,true);
        int temp = max;

        max = -1;
        d1 = new boolean[2*n-1];
        d2 = new boolean[2*n-1];
        dfs(1,0,false);

        System.out.println(temp+max);

    }
}
