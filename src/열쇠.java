import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 열쇠 {

    static char[][] map;
    static boolean[] canOpen = new boolean[26];
    static int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    static int h,w;
    static boolean[][] isVisited;
    static int max = 0;
    static Map<Character,List<int[]>> doorPos;

    static Queue<int[]> queue = new LinkedList<>();

    static void bfs(){
        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            char cur = map[y][x];
            if(cur>='a' && cur<='z'){
                char door = Character.toUpperCase(cur);
                if(doorPos.containsKey(door)) {
                    List<int[]> list = doorPos.get(door);
                    for (int[] pos : list) {
                        if (isVisited[pos[0]][pos[1]]) {
                            queue.add(new int[]{pos[0], pos[1]});
                        }
                    }
                }
                canOpen[cur-'a'] = true;
            }else if(cur == '$'){
                map[y][x] = '*';
                max++;
            }

            for(int i=0;i<4;i++){
                int nextY = y+pos[i][0];
                int nextX = x+pos[i][1];

                if(nextY<0 || nextY >= h) continue;
                if(nextX<0 || nextX >= w) continue;
                if(map[nextY][nextX]=='*') continue;
                if(isVisited[nextY][nextX]) continue;
                if(map[nextY][nextX]>='A' && map[nextY][nextX]<='Z'){
                    char door = map[nextY][nextX];
                    if(!canOpen[door-'A']){
                        isVisited[nextY][nextX] = true;
                        continue;
                    }
                }
                isVisited[nextY][nextX] = true;
                queue.add(new int[]{nextY,nextX});
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            max = 0;
            map = new char[h][w];
            doorPos = new HashMap<>();
            canOpen = new boolean[26];

            for(int i=0;i<h;i++){
                String str = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]>='A' && map[i][j]<='Z'){
                        if(doorPos.containsKey(map[i][j])){
                            doorPos.get(map[i][j]).add(new int[]{i,j});
                        }else{
                            List<int[]> posList = new ArrayList<>();
                            posList.add(new int[]{i,j});
                            doorPos.put(map[i][j],posList);
                        }
                    }
                }
            }

            String str = br.readLine();
            if(!str.equals("0")) {
                for (int i = 0; i < str.length(); i++) {
                    canOpen[str.charAt(i) - 'a'] = true;
                }
            }

            isVisited = new boolean[h][w];

            for(int i=0;i<w;i++){
                if(map[0][i]!='*') {
                    isVisited[0][i] = true;
                    if(map[0][i]>='A' && map[0][i]<='Z'){
                        if(!canOpen[map[0][i]-'A']) continue;
                    }
                    queue.add(new int[]{0, i});
                }
            }

            for(int i=0;i<w;i++){
                if(map[h-1][i]!='*') {
                    isVisited[h-1][i] = true;
                    if(map[h-1][i]>='A' && map[h-1][i]<='Z'){
                        if(!canOpen[map[h-1][i]-'A']) continue;
                    }
                    queue.add(new int[]{h-1, i});
                }
            }

            for(int i=0;i<h;i++){
                if(map[i][0]!='*') {
                    isVisited[i][0] = true;
                    if(map[i][0]>='A' && map[i][0]<='Z'){
                        if(!canOpen[map[i][0]-'A']) continue;
                    }
                    queue.add(new int[]{i, 0});
                }
            }

            for(int i=0;i<h;i++){
                if(map[i][w-1]!='*') {
                    isVisited[i][w-1] = true;
                    if(map[i][w-1]>='A' && map[i][w-1]<='Z'){
                        if(!canOpen[map[i][w-1]-'A']) continue;
                    }
                    queue.add(new int[]{i, w-1});
                }
            }
            bfs();
            sb.append(max).append("\n");
        }
        System.out.print(sb.toString());

    }
}
