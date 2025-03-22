import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 주사위굴리기 {

    static int n;
    static int m;
    static int[][] map;


    static ArrayList<Integer> body =  new ArrayList<>(); //1이 머리 3이 아래
    static ArrayList<Integer> wing =  new ArrayList<>();

    static boolean isZone(int y,int x){
        if(y==n||y<0) return false;
        if(x==m||x<0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        body.add(0);body.add(0);body.add(0);body.add(0);
        wing.add(0);wing.add(0);wing.add(0);

        map =  new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] move = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++)
            move[i] = Integer.parseInt(st.nextToken());
        // 1 : 동 2 : 서 3 : 북 4 : 남



        int curY = y;
        int curX = x;
        for(int m : move){
            int nextY=curY;
            int nextX=curX;

            int val = map[curY][curX];
            if(val==0){
                map[curY][curX] = body.get(2);
            }


            if(m==1){
                nextX++;
                if(!isZone(nextY,nextX)){
                    continue;
                }

                if(val!=0) {
                    body.remove(2);
                    body.add(2, val);
                }

            }else if(m==2){
                nextX--;
                if(!isZone(nextY,nextX)){
                    continue;
                }
                body.remove(2);
                body.add(2,val);
            }else if(m==3){
                nextY++;
                if(!isZone(nextY,nextX)){
                    continue;
                }
                body.remove(2);
                body.add(2,val);
            }else if(m==4){
                nextY--;
                if(!isZone(nextY,nextX)){
                    continue;
                }
                body.remove(2);
                body.add(2,val);
            }

            curY = nextY;
            curX = nextX;
        }

    }
}
