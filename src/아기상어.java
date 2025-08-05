import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아기상어 {

    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] map;
    static int n;
    static int x;
    static int y;
    static int level;
    static List<int[]> fishList = new ArrayList<>();

    static boolean check(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]!=0&&map[i][j]<level)
                    return true;
            }
        }
        return false;
    }

    static int[] findFish(){
        Collections.sort(fishList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]<level&&o2[2]>=level) {
                    return -1;
                }
                if(o2[2]<level&&o1[2]>=level) {
                    return 1;
                }
                if(o1[2]<level&&o2[2]<level){
                    if(bfs(o1[0],o1[1])<bfs(o2[0],o2[1])){
                        return -1;
                    }else if(bfs(o1[0],o1[1])==bfs(o2[0],o2[1])){
                        if(o1[1]<o2[1])
                            return -1;
                        else if(o1[1]==o2[1]){
                            if(o1[0]<o2[0])
                                return -1;
                            else
                                return 1;
                        }
                        else
                            return 1;
                    }else{
                        return 1;
                    }
                }
                return 0;
            }
        });
        return fishList.remove(0);
    }

    static int bfs(int targetX,int targetY){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        boolean[][] isVisited = new boolean[n][n];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curVal = cur[2];
            if(curX==targetX&&curY==targetY){
                return curVal;
            }
            for(int i=0;i<4;i++){
                int nextX = curX+pos[i][0];
                int nextY = curY+pos[i][1];
                if(nextX<0||nextX>=n)
                    continue;
                if(nextY<0||nextY>=n)
                    continue;
                if(isVisited[nextY][nextX])
                    continue;
                if(map[nextY][nextX]>level){
                    continue;
                }
                isVisited[nextY][nextX] = true;
                queue.add(new int[]{nextX,nextY,curVal+1});
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        level = 2;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur!=0&&cur!=9){
                    fishList.add(new int[]{j,i,cur});
                }
                if(cur==9){
                    x=j;
                    y=i;
                    continue;
                }
                map[i][j] = cur;
            }
        }

        int eatCnt = 0;
        int answer=0;
        while(true){
            if(!check()){
                break;
            }
            int[] fish = findFish();
            int dis = bfs(fish[0],fish[1]);
            if(dis==Integer.MAX_VALUE)
                break;
            answer+=dis;
            x=fish[0];
            y=fish[1];
            eatCnt++;
            map[y][x] = 0;
            if(eatCnt==level){
                level++;
                eatCnt=0;
            }
        }
        System.out.print(answer);
    }
}
