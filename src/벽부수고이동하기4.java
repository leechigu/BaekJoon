import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기4 {

    static int[][] pos = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

    static int n;
    static int m;

    static boolean[][] isVisited;
    static int[][] map;
    static int cnt;
    static List<int[]> list;

    static Map<String,String> parent = new HashMap<>();

    static void dfs(int y, int x,int startY,int startX){

        cnt++;
        list.add(new int[]{y,x});
        isVisited[y][x] = true;

        parent.put(y+","+x,startY+","+startX);

        for(int i=0;i<4;i++){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY<0||nextY>=n){
                continue;
            }
            if(nextX<0||nextX>=m){
                continue;
            }

            if(map[nextY][nextX]==-1){
                continue;
            }

            if(!isVisited[nextY][nextX]){
                dfs(nextY,nextX,startY,startX);
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n][m];
        map = new int[n][m];

        for(int i=0;i<n;i++){
            String cur = br.readLine();
            for(int j=0;j<m;j++){
                if(cur.charAt(j)=='1'){
                    map[i][j] = -1;
                }else {
                    map[i][j] = cur.charAt(j) - '0';
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isVisited[i][j]||map[i][j]==-1)
                    continue;
                list = new ArrayList<>();
                cnt = 0;
                dfs(i,j,i,j);

                for(int[] temp : list){
                    int y = temp[0];
                    int x = temp[1];
                    map[y][x] = cnt;
                }
            }
        }


        int[][] answer = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==-1){
                    answer[i][j] = sumNearNum(i,j)%10;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static int sumNearNum(int y, int x){

        int answer = 0;

        Set<String> set = new HashSet<>();

        for(int i=0;i<4;i++){
            int nextY = y + pos[i][0];
            int nextX = x + pos[i][1];

            if(nextY<0||nextY>=n){
                continue;
            }
            if(nextX<0||nextX>=m){
                continue;
            }
            if(map[nextY][nextX]==-1){
                continue;
            }
            set.add(parent.get(nextY+","+nextX));
        }

        for(String key : set){
            String[] split = key.split(",");
            int keyY = Integer.parseInt(split[0]);
            int keyX = Integer.parseInt(split[1]);

            answer+= map[keyY][keyX];

        }

        return answer+1;
    }

}
