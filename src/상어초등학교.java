import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 상어초등학교 {

    static int[][] map;
    static int[][] likeMap;
    static int n;
    static int[][] pos = {{1,0},{0,1},{-1,0},{0,-1}};
    static Map<Integer, List<Integer>> hashMap = new HashMap<>();

    public static void setStudent(StringTokenizer st){
        int x = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<Integer> likeList = new ArrayList<>();
        likeList.add(a);
        likeList.add(b);
        likeList.add(c);
        likeList.add(d);

        int maxLike = -1;
        int maxNull = -1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int like = 0;
                int nul = 0;

                if(map[i][j] ==0){

                    for(int[] val : pos){
                        int nextY = i+val[0];
                        int nextX = j+val[1];

                        if(nextX<0||nextX>=n) continue;
                        if(nextY<0||nextY>=n) continue;
                        if(map[nextY][nextX]==0){
                            nul++;
                        }else if(likeList.contains(map[nextY][nextX])){
                            like++;
                        }
                    }
                    if(like>maxLike){
                        maxLike = like;
                        maxNull = nul;
                    }else if(like==maxLike){
                        maxNull = Math.max(maxNull,nul);
                    }
                }
            }
        }
        boolean isSet = false;
        for(int i=0;i<n;i++){
            if(isSet){
                break;
            }
            for(int j=0;j<n;j++){
                int like = 0;
                int nul = 0;
                for(int[] val : pos){
                    int nextY = i+val[0];
                    int nextX = j+val[1];

                    if(nextX<0||nextX>=n) continue;
                    if(nextY<0||nextY>=n) continue;
                    if(map[nextY][nextX]==0){
                        nul++;
                    }else if(likeList.contains(map[nextY][nextX])){
                        like++;
                    }
                }
                if(like==maxLike&&nul==maxNull && map[i][j]==0){
                    map[i][j] = x;
                    likeMap[i][j] = maxLike;
                    isSet = true;
                    break;
                }
            }
        }
        hashMap.put(x,likeList);
    }

    public static int cal(){

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int like = 0;
                List<Integer> likeList = hashMap.get(map[i][j]);
                for(int[] val : pos){
                    int nextY = i+val[0];
                    int nextX = j+val[1];

                    if(nextX<0||nextX>=n) continue;
                    if(nextY<0||nextY>=n) continue;
                    if(likeList.contains(map[nextY][nextX])){
                        like++;
                    }
                }

                if(like==1){
                    answer+=1;
                }else if(like==2){
                    answer+=10;
                }else if(like==3){
                    answer+=100;
                }else if(like==4){
                    answer+=1000;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        likeMap = new int[n][n];
        StringTokenizer st = null;

        for(int i=0;i<n*n;i++){
            st = new StringTokenizer(br.readLine());
            setStudent(st);
        }
        System.out.print(cal());
    }
}
