import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {

    static int[][] basketInfo;
    static int n,m;

    static int[][] cloudInfo;
    static boolean[][] isCloudBefore;

    static int[][] pos = new int[][]{
            {0,-1},
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1}
    };

    static void doProcess(int s,int d){

        moveCloud(s,d);

        isCloudBefore = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cloudInfo[i][j]==1){
                    basketInfo[i][j]++;
                    isCloudBefore[i][j] = true;
                    cloudInfo[i][j]=0;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isCloudBefore[i][j]){
                    doWaterCopyMagic(i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!isCloudBefore[i][j] && basketInfo[i][j]>=2){
                    basketInfo[i][j]-=2;
                    cloudInfo[i][j]=1;
                }
            }
        }
    }

    static void doWaterCopyMagic(int y,int x){

        for(int i=1;i<8;i+=2){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY<0 || nextY>=n) continue;
            if(nextX<0 || nextX>=n) continue;

            if(basketInfo[nextY][nextX]>=1){
                basketInfo[y][x]++;
            }
        }
    }

    static void moveCloud(int s, int d){
        int[][] newCloundInfo = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cloudInfo[i][j]==1){
                    move(newCloundInfo,s,d,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            cloudInfo[i] = newCloundInfo[i].clone();
        }
    }

    static void move(int[][] newCloudInfo,int s, int d, int y, int x){
        int dist = s%n;
        int nextY = (y+pos[d][0] * dist + n) %n;
        int nextX = (x+pos[d][1] * dist + n) %n;
        newCloudInfo[nextY][nextX] = 1;
    }

    static int calResult(){

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result+=basketInfo[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        basketInfo = new int[n][n];
        cloudInfo = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                basketInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloudInfo[n-1][0]=1;
        cloudInfo[n-1][1]=1;
        cloudInfo[n-2][0]=1;
        cloudInfo[n-2][1]=1;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            doProcess(s,d);
        }

        System.out.print(calResult());
    }
}
