import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출2 {

    static char[][] map;
    static int n,m;
    static int[] blue;
    static int[] red;
    static int min = 11;

    public static void dfs(int seq,int dir){

        if(seq == 11 || seq >= min){
            return;
        }

        int state = move(dir);
        if(state==1){
            min = Math.min(seq,min);
            return;
        }else if(state==-1){
            return;
        }

        for(int i=0;i<4;i++){

            int[] tempBlue = blue.clone();
            int[] tempRed = red.clone();
            dfs(seq+1,i);
            blue = tempBlue.clone();
            red = tempRed.clone();
        }
    }


    public static int move(int dir){
        int[] x = new int[2];
        int[] y = new int[2];
        int nextY;
        int nextX;
        if(dir==0){

            if(blue[0]<red[0]){
                x = blue;
                y = red;
            }else{
                y = blue;
                x = red;
            }
            nextY = x[0];
            while(true){
                nextY--;
                if(map[nextY][x[1]]=='.'){
                }else if(map[nextY][x[1]]=='O'){
                    nextY = -1;
                    x[1] = -1;
                    break;
                }else{
                    nextY++;
                    break;
                }
            }
            x[0] = nextY;


            nextY = y[0];
            while(true){
                nextY--;
                if(!(x[0]==nextY && x[1]==y[1] ) && map[nextY][y[1]]=='.'){
                }else if(map[nextY][y[1]]=='O'){
                    nextY = -1;
                    y[1] = -1;
                    break;
                }else{
                    nextY++;
                    break;
                }
            }
            y[0] = nextY;

        }else if(dir==1){
            if(blue[0]>red[0]){
                x = blue;
                y = red;
            }else{
                y = blue;
                x = red;
            }

            nextY = x[0];
            while(true){
                nextY++;
                if(map[nextY][x[1]]=='.'){
                }else if(map[nextY][x[1]]=='O'){
                    nextY = -1;
                    x[1] = -1;
                    break;
                }else{
                    nextY--;
                    break;
                }
            }
            x[0] = nextY;

            nextY = y[0];
            while(true){
                nextY++;
                if(!(x[0]==nextY && x[1]==y[1] ) && map[nextY][y[1]]=='.'){
                }else if(map[nextY][y[1]]=='O'){
                    nextY = -1;
                    y[1] = -1;
                    break;
                }else{
                    nextY--;
                    break;
                }
            }
            y[0] = nextY;

        }else if(dir==2){
            if(blue[1]>red[1]){
                x = blue;
                y = red;
            }else{
                y = blue;
                x = red;
            }
            nextX = x[1];
            while(true){
                nextX++;
                if(map[x[0]][nextX]=='.'){
                }else if(map[x[0]][nextX]=='O'){
                    nextX = -1;
                    x[0] = -1;
                    break;
                }else{
                    nextX--;
                    break;
                }
            }
            x[1] = nextX;

            nextX = y[1];
            while(true){
                nextX++;
                if(!(x[0]==y[0] && x[1]==nextX ) && map[y[0]][nextX]=='.'){
                }else if(map[y[0]][nextX]=='O'){
                    nextX = -1;
                    y[0] = -1;
                    break;
                }else{
                    nextX--;
                    break;
                }
            }
            y[1] = nextX;


        }else if(dir==3){
            if(blue[1]<red[1]){
                x = blue;
                y = red;
            }else{
                y = blue;
                x = red;
            }
            nextX = x[1];
            while(true){
                nextX--;
                if(map[x[0]][nextX]=='.'){
                }else if(map[x[0]][nextX]=='O'){
                    nextX = -1;
                    x[0] = -1;
                    break;
                }else{
                    nextX++;
                    break;
                }
            }
            x[1] = nextX;

            nextX = y[1];
            while(true){
                nextX--;
                if(!(x[0]==y[0] && x[1]==nextX ) && map[y[0]][nextX]=='.'){
                }else if(map[y[0]][nextX]=='O'){
                    nextX = -1;
                    y[0] = -1;
                    break;
                }else{
                    nextX++;
                    break;
                }
            }
            y[1] = nextX;
        }
        if(blue[0]==-1 || blue[1] ==-1){
            return -1;
        }
        if(red[0]==-1 || red[1] ==-1){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='B'){
                    blue = new int[]{i,j};
                    map[i][j] = '.';
                }else if(map[i][j]=='R') {
                    red = new int[]{i,j};
                    map[i][j] = '.';
                }
            }
        }

        for(int i=0;i<4;i++){
            int[] tempBlue = blue.clone();
            int[] tempRed = red.clone();
            dfs(1,i);
            blue = tempBlue.clone();
            red = tempRed.clone();
        }
        if(min ==11)
            min = -1;
        System.out.print(min);
    }
}
