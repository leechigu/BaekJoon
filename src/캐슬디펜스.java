import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 캐슬디펜스 {

    static int n,m,d;
    static int[][] map;
    static int max = -1;

    static boolean[] isVisited;
    static int[] rangerPos = new int[3];
    static int cnt;

    static void dfs(int depth,int pos){

        if(depth==3){
            int temp = go();
            //System.out.println(temp);
            max = Math.max(max,temp);
            return;
        }

        for(int i=pos;i<m;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                rangerPos[depth] = i;
                dfs(depth+1,i);
                isVisited[i] = false;
            }
        }


    }

    static int go(){

        //System.out.println(rangerPos[0] + " " + rangerPos[1] + " " +rangerPos[2] + " ");

        int[][] tempMap = new int[n][m];
        for(int i=0;i<n;i++){
            tempMap[i] = map[i].clone();
        }

        int dis = d;

        for(int t=0;t<n;t++){
            int min1 = 30;
            int min2 = 30;
            int min3 = 30;

            int[] pos1 = new int[]{-1,-1};
            int[] pos2 = new int[]{-1,-1};
            int[] pos3 = new int[]{-1,-1};

            for(int j=0;j<m;j++){
                for(int i=0;i<n-t;i++){
                    if(tempMap[i][j]==1){
                        //System.out.println("i = "+ i + " j =" + j);
                        int dis1 = n-i + Math.abs(j-rangerPos[0]);
                        //System.out.println("dis1 "+ dis1);
                        if(dis1<=dis && dis1<min1){
                            min1 = dis1;
                            pos1[0] = i;
                            pos1[1] = j;
                        }
                        int dis2 = n-i + Math.abs(j-rangerPos[1]);
                        //System.out.println("dis2 "+ dis1);
                        if(dis2<=dis &&dis2<min2){
                            min2 = dis2;
                            pos2[0] = i;
                            pos2[1] = j;
                        }
                        int dis3 = n-i + Math.abs(j-rangerPos[2]);
                        //System.out.println("dis3 "+ dis1);
                        if(dis3<=dis && dis3<min3){
                            min3 = dis3;
                            pos3[0] = i;
                            pos3[1] = j;
                        }
                    }
                }
            }
            if(pos1[0]!=-1)
                tempMap[pos1[0]][pos1[1]] = 0;
            if(pos2[0]!=-1)
                tempMap[pos2[0]][pos2[1]] = 0;
            if(pos3[0]!=-1)
                tempMap[pos3[0]][pos3[1]] = 0;
            //System.out.println("1 = " + pos1[0]+", "+pos1[1]);
            //System.out.println("2 = " + pos2[0]+", "+pos2[1]);
            //System.out.println("3 = " + pos3[0]+", "+pos3[1]);
            //System.out.println("-----------------------Move----------------------");
            //움직이기
            //System.out.println("-----------------------Move----------------------");
            //System.out.println("---------------------------------------------");
            dis++;
        }

        int resultCnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tempMap[i][j]==1){
                    resultCnt++;
                }
            }
        }
        return cnt - resultCnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    cnt++;
            }
        }

        dfs(0,0);
        System.out.print(max);
    }
}
