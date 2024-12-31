import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 뱀 {


    static class Move{
        int second;
        char dir;

        Move(int second,char dir){
            this.second=second;
            this.dir = dir;
        }
    }

    static int n;
    static Deque<int[]> deque;
    static int[][] map;
    static char curDir;
    static boolean move(){
        int[] head = deque.getLast();
        int curY = head[0];
        int curX = head[1];

        int nextY = -1;
        int nextX = -1;

        if(curDir=='L'){
            nextY = curY;
            nextX = curX-1;
        }else if(curDir=='R'){
            nextY = curY;
            nextX = curX+1;
        }else if(curDir=='N'){
            nextY = curY-1;
            nextX = curX;
        }else if(curDir=='S'){
            nextY = curY+1;
            nextX = curX;
        }

        if(nextY<=0||nextY>n)
            return false;

        if(nextX<=0||nextX>n)
            return false;

        if(map[nextY][nextX]==-1)
            return false;


        deque.add(new int[]{nextY,nextX});
        if(map[nextY][nextX]==0){

            int[] tail = deque.removeFirst();
            map[tail[0]][tail[1]]=0;
        }
        map[nextY][nextX]=-1;

        return true;
    }

    static void changeDir(char next){
        if(next =='L'){
            if(curDir=='N'){
                curDir='L';
            }else if(curDir=='R'){
                curDir='N';
            }else if(curDir=='S'){
                curDir='R';
            }
            else if(curDir=='L'){
                curDir='S';
            }
        }else if(next=='D'){
            if(curDir=='N'){
                curDir='R';
            }else if(curDir=='R'){
                curDir='S';
            }else if(curDir=='S'){
                curDir='L';
            }
            else if(curDir=='L'){
                curDir='N';
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        StringTokenizer st = null;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        ArrayList<Move> moveList = new ArrayList<>();
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            moveList.add(new Move(second,dir));
        }

        deque = new ArrayDeque<>();
        deque.add(new int[]{1,1});
        map[1][1] = -1;
        int answer = 0;
        curDir = 'R';
        int curSecond = 0;
        for(Move m : moveList){
            int second = m.second;
            char nextDir = m.dir;
            for(int i=0;i<second-curSecond;i++){
                if(move()){
                    answer++;
                }else{
                    System.out.println(answer+1);
                    return;
                }
            }
            curSecond+=second-curSecond;
            changeDir(nextDir);
        }
        while(move()){
            answer++;
        }
        System.out.println(answer+1);
    }
}
