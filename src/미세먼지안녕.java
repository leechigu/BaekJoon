import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

    static int[][] map;
    static int[][] tempMap;
    static int r;
    static int c;
    static int[][] pos = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public static void diffuse(){
        //확산
        tempMap = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]==0){
                    continue;
                }
                //상하좌우
                boolean[] isPossible = new boolean[4];
                int cnt = 1;
                for(int k=0;k<4;k++){
                    int nextY = i+pos[i][0];
                    int nextX = j+pos[i][1];
                    if(nextX<0||nextX>=c){
                        continue;
                    }
                    if(nextY<0||nextY>=r){
                        continue;
                    }
                    if(map[nextY][nextX]==-1){
                        continue;
                    }
                    isPossible[i] = true;
                    cnt++;
                }

                

            }
        }
            //개수 파악
            //계산
        //반영

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j] += tempMap[i][j];
            }
        }
    }

    public static void move(){

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(t-->0){
            diffuse();
            move();
        }


    }
}
