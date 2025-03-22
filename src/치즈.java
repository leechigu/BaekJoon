import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 치즈 {

    static int[][] map;
    static int n;
    static int m;
    static boolean[][] isVisitied;
    static int[][] pos = {{1,0},{-1,0},{0,-1},{0,1}};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true){
            if(checkIsAllMelted()){
                break;
            }
            doMelt();
            answer++;
        }
        System.out.println(answer);
    }

    static void doMelt(){

        int[][] tempMap = new int[n][m];
        isVisitied = new boolean[n][m];

        dfs(0,0,tempMap);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tempMap[i][j]>=2){
                    map[i][j]=0;
                }
            }
        }
    }

    static void dfs(int y, int x, int[][] tempMap){

        if(y==n-1&&x==m-1){
            return;
        }

        for(int i=0;i<4;i++){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY<0||nextY>=n||nextX<0||nextX>=m){
                continue;
            }
            if(isVisitied[nextY][nextX]){
                continue;
            }
            if(map[nextY][nextX]==1) {
                tempMap[nextY][nextX]++;
                continue;
            }

            isVisitied[nextY][nextX]=true;
            dfs(nextY,nextX,tempMap);
        }

    }

    static boolean checkIsAllMelted(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1)
                    return false;
            }
        }
        return true;
    }
}
