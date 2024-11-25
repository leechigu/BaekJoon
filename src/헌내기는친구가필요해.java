import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {


    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};

    static char[][] map;

    static int n;
    static int m;
    static boolean[][] isVisitied;
    static int answer = 0;
    static void dfs(int x,int y){


        if(map[y][x]=='P'){
            answer++;
        }

        for(int i = 0; i <4; i++){
            int nextX = x+pos[i][0];
            int nextY = y+pos[i][1];

            if(nextX<=0||nextX>m)
                continue;
            if(nextY<=0||nextY>n)
                continue;

            if(isVisitied[nextY][nextX]){
                continue;
            }


            isVisitied[nextY][nextX] = true;

            if(map[nextY][nextX]=='X')
                continue;
            dfs(nextX,nextY);
        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        isVisitied = new boolean[n+1][m+1];


        int x = 0;
        int y = 0;

        for(int i=1;i<=n;i++){
            input = br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j] = input.charAt(j-1);
                if(map[i][j]=='I'){
                    x = j;
                    y = i;
                }
            }
        }
        dfs(x,y);
        if(answer==0){
            System.out.println("TT");
        }else {
            System.out.println(answer);
        }
    }
}
