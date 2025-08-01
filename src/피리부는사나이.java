import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 피리부는사나이 {

    static int[][][] parent;
    static char[][] map;
    static boolean[][] isClear;
    static int answer = 0;
    static int n;
    static int m;

    static boolean isReverse(char a, char b){

        if(a=='U'&&b=='D'){
            return true;
        }
        if(a=='L'&&b=='R'){
            return true;
        }
        if(a=='R'&&b=='L'){
            return true;
        }
        if(a=='D'&&b=='U'){
            return true;
        }
        return false;
    }

    static void dfs(int y, int x, List<String> list){

        isClear[y][x] = true;
        list.add(y+","+x);
        int nextY = y;
        int nextX = x;

        if(map[y][x] == 'U'){
            nextY--;
        }else if(map[y][x] == 'D'){
            nextY++;
        }else if(map[y][x] == 'L'){
            nextX--;
        }else if(map[y][x] == 'R'){
            nextX++;
        }

        if(nextX==-1||nextX==m){
            answer++;
            return;
        }
        if(nextY==-1||nextY==n){
            answer++;
            return;
        }

        if(list.contains(nextY+","+nextX)){
            answer++;
            return;
        }

        if(isReverse(map[y][x],map[nextY][nextX])){
            isClear[nextY][nextX] = true;
            answer++;
            return;
        }

        if(!isClear[nextY][nextX]){
            dfs(nextY, nextX, list);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        isClear = new boolean[n][m];
        parent = new int[n][m][2];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                parent[i][j][0] = i;
                parent[i][j][1] = j;
            }
        }

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!isClear[i][j])
                    dfs(i, j, new ArrayList<>());
            }
        }
        System.out.print(answer);
    }
}
