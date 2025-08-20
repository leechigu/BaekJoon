import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {
    static int[][][] map;
    static int n;
    static int curY,curX;
    static List<Integer> cur = new ArrayList<>();

    public static void dfs(int depth, int target){
        if(depth==target)
            return;
        for(int i=cur.size()-1;i>=0;i--)
            cur.add((cur.get(i)+1)%4);
        dfs(depth+1,target);
    }

    public static void go(int dir){

        int next = -1;
        map[curY][curX][dir]=1;
        if(dir==0){
            next = curX+1;
            curX = next;
        }else if(dir==1){
            next = curY-1;
            curY = next;
        }else if(dir==2){
            next = curX-1;
            curX = next;
        }
        else if(dir==3){
            next = curY+1;
            curY = next;
        }
        map[curY][curX][(dir+2)%4] = 1;
    }

    public static boolean check(int y, int x){
        int cnt = 0;

        for(int i=0;i<4;i++){
            if(map[y][x][i]==1){
                cnt++;
                break;
            }
        }

        for(int i=0;i<4;i++){
            if(map[y][x+1][i]==1){
                cnt++;
                break;
            }
        }
        for(int i=0;i<4;i++){
            if(map[y+1][x][i]==1){
                cnt++;
                break;
            }
        }
        for(int i=0;i<4;i++){
            if(map[y+1][x+1][i]==1){
                cnt++;
                break;
            }
        }

        if(cnt==4)
            return true;
        return false;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[101][101][4];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            cur = new ArrayList<>();
            cur.add(dir);
            dfs(0,g);
            for(int d : cur){
                go(d);
            }
        }

        int answer = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(check(i,j))
                    answer++;
            }
        }
        System.out.print(answer);

    }
}
