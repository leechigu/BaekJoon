import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 낚시왕 {

    static int[][] map;
    static int r,c,m;
    static Map<Integer,int[]> shark =new HashMap<>();

    public static int catchShark(int x){
        int sum=0;
        for(int i=0;i<r;i++){
            if(map[i][x]!=0){
                sum+=map[i][x];
                map[i][x] = 0;
                shark.remove(map[i][x]);
                break;
            }
        }
        return sum;
    }

    public static void move(){

        int[][] nextMap = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]!=0){
                    int y = i;
                    int x = j;
                    int size = map[i][j];
                    int[] sharkInfo = shark.get(size);
                    int dir = sharkInfo[0];
                    int speed = sharkInfo[1];

                    if(dir == 1){
                        int a = (r-1)-y;
                        speed +=a;
                        speed %= ((r-1)*2);
                        if(speed>=1 && speed<=(r-1)){
                            y = (r-1) -speed;
                        }else if(speed ==0){
                            y = r-1;
                        }else {
                            dir = 2;
                            y = speed - (r-1);
                        }
                    }else if(dir == 2){
                        int a = y;
                        speed +=a;
                        speed %= ((r-1)*2);
                        if(speed>=1 && speed<=(r-1)){
                            y = speed;
                        }else if(speed ==0){
                            y = 0;
                        }else {
                            dir = 1;
                            y = (r-1)*2 - speed;
                        }
                    }else if(dir == 3){
                        int a = x;
                        speed +=a;
                        speed %= ((c-1)*2);
                        if(speed>=1 && speed<=(c-1)){
                            x = speed;
                        }else if(speed ==0){
                            x = 0;
                        }else {
                            dir = 4;
                            x = (c-1)*2 - speed;
                        }
                    }else if(dir == 4){
                        int a = (c-1)-x;
                        speed +=a;
                        speed %= ((c-1)*2);
                        if(speed>=1 && speed<=(c-1)){
                            x = (c-1) -speed;
                        }else if(speed ==0){
                            x = c-1;
                        }else {
                            dir = 3;
                            x = speed - (c-1);
                        }
                    }
                    if(nextMap[y][x]<size){
                        nextMap[y][x] = size;
                        shark.put(size, new int[]{dir,sharkInfo[1]});
                    }else{
                        shark.remove(size);
                    }

                }
            }
        }
        for(int i=0;i<r;i++){
            map[i] = nextMap[i];
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = z;
            shark.put(z,new int[]{d,s});

        }

        int sum = 0;
        for(int i=0;i<c;i++){
            sum+=catchShark(i);
            move();
        }
        System.out.print(sum);
    }
}
