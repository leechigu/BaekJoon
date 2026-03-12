import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 경쟁적전염 {


    static int[][] map;
    static int n;
    static int[][] pos = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] isVisited;
    static Map<Integer, List<int[]>> nextValueMap = new HashMap<>();

    static void dfs(int y,int x,int num){

        for(int i=0;i<4;i++){
            int nextY = pos[i][0] + y;
            int nextX = pos[i][1] + x;

            if(nextY<0||nextY>=n) continue;
            if(nextX<0||nextX>=n) continue;

            if(isVisited[nextY][nextX])
                continue;

            if(map[nextY][nextX]==0){
                map[nextY][nextX] = num;
                isVisited[nextY][nextX] = true;
                nextValueMap.get(num).add(new int[]{nextY,nextX});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        isVisited = new boolean[n][n];


        for(int i=1;i<=k;i++){
            nextValueMap.put(i,new ArrayList<>());
        }


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0){
                    nextValueMap.get(map[i][j]).add(new int[]{i,j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;

        for(int j=0;j<s;j++) {

            for (int i = 1; i <= k; i++) {

                List<int[]> curValueList = nextValueMap.get(i);
                nextValueMap.put(i,new ArrayList<>());
                for(int[] curValue : curValueList){
                    dfs(curValue[0],curValue[1],i);
                }
            }
/*            System.out.println();
            System.out.println((j+1)+" :초 ");

            for(int i=0;i<n;i++){
                for(int a=0;a<n;a++){
                    System.out.print(map[i][a] + " ");
                }
                System.out.println();
            }*/
        }
        System.out.print(map[y][x]);

    }
}
