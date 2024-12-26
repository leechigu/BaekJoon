import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {

    static int stY;
    static int stX;
    static int targetY;
    static int targetX;
    static int[][] con;
    static boolean isPossible;
    static boolean[] isVisited;

    static void dfs(int y, int x){
        if(isPossible)
            return;
        if(Math.abs(targetY-y)+Math.abs(targetX-x)<=1000){
            isPossible = true;
            return;
        }

        for(int i=0;i<con.length;i++){
            if(!isVisited[i]&&Math.abs(y-con[i][0])+Math.abs(x-con[i][1])<=1000){
                isVisited[i] = true;
                dfs(con[i][0],con[i][1]);
                isVisited[i] = false;
            }
        }
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{stY,stX});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int len = Math.abs(curY-targetY)+Math.abs(curX-targetX);

            //System.out.println(curY + " " + curX);

            if(len<=1000){
                isPossible = true;
                return;
            }

            for(int i=0;i<con.length;i++){
                if(isVisited[i]){
                    continue;
                }

                len = Math.abs(curY-con[i][0])+Math.abs(curX-con[i][1]);
                //System.out.println("len = "+len);
                if(len<=1000){
                    isVisited[i] = true;
                    queue.add(new int[]{con[i][0],con[i][1]});
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-->0){

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            stY = Integer.parseInt(st.nextToken());
            stX = Integer.parseInt(st.nextToken());

            con = new int[n][2];
            isVisited = new boolean[n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                con[i][0] = Integer.parseInt(st.nextToken());
                con[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            isPossible = false;

            //dfs(stY,stX);
            bfs();

            if(isPossible){
                sb.append("happy").append("\n");
            }else{
                sb.append("sad").append("\n");
            }
        }
        System.out.print(sb);
    }
}
