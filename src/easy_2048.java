import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class easy_2048 {

    static int n;
    static int[][] map;
    static int max = -1;

    public static void dfs(int depth,int dir){

        int cur = move(dir);
        if(cur>max){
            max = cur;
        }

        if(depth<5){
            int[][] memory = new int[n][n];
            for(int i=0;i<n;i++){
                memory[i] = Arrays.copyOf(map[i],n);
            }
            for(int i=0;i<4;i++) {
                dfs(depth + 1, i);
                for(int j=0;j<n;j++){
                    map[j] = Arrays.copyOf(memory[j],n);
                }

            }
        }
    }

    public static int move(int dir){

        int max = -1;
        before(dir);

        if(dir==0){
            for(int i=1;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j] == map[i-1][j]){
                        map[i-1][j] *=2;
                        max = Math.max(max,map[i-1][j]);
                        for(int k=i;k<n-1;k++){
                            map[k][j] = map[k+1][j];
                        }
                        map[n-1][j] = 0;
                    }
                }
            }
        }else if(dir==1){
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<n;j++){
                    if(map[i][j] == map[i+1][j]){
                        map[i+1][j] *=2;
                        max = Math.max(max,map[i+1][j]);
                        for(int k=i;k>=1;k--){
                            map[k][j] = map[k-1][j];
                        }
                        map[0][j] = 0;
                    }
                }
            }
        }else if(dir==2){
            for(int i=0;i<n;i++){
                for(int j=1;j<n;j++){
                    if(map[i][j] == map[i][j-1]){
                        map[i][j-1] *=2;
                        max = Math.max(max,map[i][j-1]);
                        for(int k=j;k<n-1;k++){
                            map[i][k] = map[i][k+1];
                        }
                        map[i][n-1] = 0;
                    }
                }
            }
        }else if(dir==3){
            for(int i=0;i<n;i++){
                for(int j=n-2;j>=0;j--){
                    if(map[i][j] == map[i][j+1]){
                        map[i][j+1] *=2;
                        max = Math.max(max,map[i][j+1]);
                        for(int k=j;k>=1;k--){
                            map[i][k] = map[i][k-1];
                        }
                        map[i][0] = 0;
                    }
                }
            }
        }
        return max;
    }

    public static void before(int dir){

        if(dir==0){
            for(int j=0;j<n;j++){
                int pos =0;
                for(int i=0;i<n;i++){
                    if(map[i][j]!=0){
                        map[pos++][j] = map[i][j];
                    }
                }
                while (pos<n) {
                    map[pos++][j] = 0;
                }
            }
        }else if(dir==1){
            for(int j=0;j<n;j++){
                int pos = n-1;
                for(int i=n-1;i>=0;i--){
                    if(map[i][j]!=0){
                        map[pos--][j] = map[i][j];
                    }
                }
                while (pos >= 0) {
                    map[pos--][j] = 0;
                }
            }
        }else if(dir==2){
            for(int i=0;i<n;i++){
                int pos = 0;
                for(int j=0;j<n;j++){
                    if(map[i][j]!=0){
                        map[i][pos++] = map[i][j];
                    }
                }
                while (pos<n) {
                    map[i][pos++] = 0;
                }
            }
        }else if(dir==3){
            for(int i=0;i<n;i++){
                int pos = n-1;
                for(int j=n-1;j>=0;j--){
                    if(map[i][j]!=0){
                        map[i][pos--] = map[i][j];
                    }
                }
                while (pos >= 0) {
                    map[i][pos--] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }

        int[][] copyMap = new int[n][n];
        for(int j=0;j<n;j++)
            copyMap[j] = Arrays.copyOf(map[j],n);

        for(int i=0;i<4;i++){
            dfs(0,i);

            for(int j=0;j<n;j++)
                map[j] = Arrays.copyOf(copyMap[j],n);

        }

        System.out.println(max);
    }
}
