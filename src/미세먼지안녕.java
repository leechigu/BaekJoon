import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

    static int r;
    static int c;
    static int[][] pos = {{1,0},{-1,0},{0,-1},{0,1}};

    static int y1;static int y2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        int t = Integer.parseInt(inputs[2]);

        int[][] map = new int[r][c];

        y1 = -1;y2 = -1;

        for(int i=0;i<r;i++){
            input = br.readLine();
            inputs = input.split(" ");
            for(int j=0;j<c;j++){
                int cur = Integer.parseInt(inputs[j]);
                map[i][j] = cur;
                if(cur==-1){
                    y2 = i;
                }
            }
        }

        y1 = y2-1;

        while(t-->0){
            spreadDust(map);
            airMove(map);
        }

        int answer = 2;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                answer+=map[i][j];
        System.out.println(answer);
    }


    private static void spreadDust(int[][] map){
        int[][] tempMap = new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(map[i][j]>0)
                    moveDust(map,tempMap,i,j);

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                map[i][j]+=tempMap[i][j];

    }

    private static void moveDust(int[][] map, int[][] tempMap, int y, int x){
        int cnt = 0;
        int ahrt = map[y][x]/5;

        for(int i=0;i<4;i++){
            int nextY = y+pos[i][0];
            int nextX = x+pos[i][1];

            if(nextY>=r||nextY<0||nextX>=c||nextX<0)
                continue;
            if(map[nextY][nextX]==-1)
                continue;

            tempMap[nextY][nextX]+= ahrt;
            cnt++;

        }
        map[y][x] -= ahrt*cnt;
    }

    private static void airMove(int[][] map){
        //case1
        for(int i=y1-2;i>=0;i--) {
            map[i + 1][0] = map[i][0];
        }
        //case2
        for(int j=1;j<c;j++)
            map[0][j-1]=map[0][j];
        //case3
        for(int i=1;i<=y1;i++)
            map[i-1][c-1]=map[i][c-1];
        //case4
        for(int j=c-2;j>=1;j--)
            map[y1][j+1] = map[y1][j];
        map[y1][1] = 0;
        //case5
        for(int i=y2+2;i<r;i++)
            map[i-1][0] = map[i][0];
        //case6
        for(int j=1;j<c;j++)
            map[r-1][j-1] = map[r-1][j];
        //case7
        for(int i=r-2;i>=y2;i--)
            map[i+1][c-1] = map[i][c-1];
        //case8
        for(int j=c-2;j>=1;j--)
            map[y2][j+1] = map[y2][j];
        map[y2][1] = 0;

    }


}

