import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {

    static int n,m,x,y;
    static int[] dice = {0,0,0,0,0,0};
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    public static void rollDice(int dir){
        int[] temp  = new int[6];
        for(int i=0;i<6;i++)
            temp[i] = dice[i];

        if(dir==1){
            dice[0] = temp[4];
            dice[2] = temp[5];
            dice[4] = temp[2];
            dice[5] = temp[0];
        }else if(dir==2){
            dice[0] = temp[5];
            dice[2] = temp[4];
            dice[4] = temp[0];
            dice[5] = temp[2];
        }else if(dir==3){
            for(int i=0;i<3;i++){
                dice[i] = temp[i+1];
            }
            dice[3] = temp[0];
        }else if(dir==4){
            for(int i=1;i<4;i++){
                dice[i] = temp[i-1];
            }
            dice[0] = temp[3];
        }

    }

    public static void move(int dir){
        int nextY = y;
        int nextX = x;

        if(dir==1)
            nextX++;
        else if(dir==2)
            nextX--;
        else if(dir==3)
            nextY--;
        else if(dir==4)
            nextY++;


        if(nextY<0 || nextY>=n)
            return;
        if(nextX<0 || nextX>=m)
            return;

        x = nextX;
        y = nextY;

        rollDice(dir);

        sb.append(dice[0]).append("\n");
        if(map[y][x]==0){
            map[y][x] = dice[2];
        }else{
            dice[2] = map[y][x];
            map[y][x] = 0;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            move(Integer.parseInt(st.nextToken()));
        }
        System.out.print(sb.toString());
    }
}
