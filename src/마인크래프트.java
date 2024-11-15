import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {

    static void cal(int floor ,int blockCnt){
        int val = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int curFloor = map[i][j];
                if(curFloor>=floor){
                    blockCnt += curFloor-floor;
                    val += 2*(curFloor-floor);
                }else{
                    blockCnt -= floor-curFloor;
                    val += floor-curFloor;
                }
                if(val>min)
                    return;
            }
        }

        if(blockCnt>=0&&val<=min){
            min = val;
            maxVal = Math.max(floor,maxVal);
        }
    }

    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int n;
    static int m;
    static int b;
    static int maxVal = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        int minFloor = 257;
        int maxFloor = -1;

        for(int i=1;i<=n;i++){
            input = br.readLine();
            st = new StringTokenizer(input);

            for(int j=1;j<=m;j++){
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;

                if(cur<minFloor)
                    minFloor =cur;
                if(cur>maxFloor)
                    maxFloor = cur;

            }
        }

        for(int i=minFloor;i<=maxFloor;i++){
            int blockCnt = b;
            cal(i,blockCnt);
        }

        System.out.println(min+ " "+maxVal);

    }
}
