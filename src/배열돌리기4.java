import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 배열돌리기4 {

    static int[][] arr;
    static int n,m,k;
    static boolean[] isVisited;
    static int result = Integer.MAX_VALUE;

    static int[][] rotateInfo;


    public static void dfs(int depth){

        if(depth==0){
            calArrValue();
            return;
        }

        for(int x=0;x<k;x++){
            if(!isVisited[x]) {
                isVisited[x] = true;
                //현재 값 저장
                int[][] tempArr = new int[n][m];
                for (int i = 0; i < n; i++) {
                    tempArr[i] = arr[i].clone();
                }

                rotateArr(rotateInfo[x][0], rotateInfo[x][1], rotateInfo[x][2]);
                dfs(depth-1);
                //원복
                for (int i = 0; i < n; i++) {
                    arr[i] = tempArr[i].clone();
                }
                isVisited[x] = false;
            }
        }

    }


    public static void calArrValue(){
/*        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cur = 0;
            for(int j=0;j<m;j++){
                cur+=arr[i][j];
            }
            min = Math.min(min,cur);
        }
        result = Math.min(min,result);
    }

    public static void rotate(int y,int x,int depth){

        if(depth<=0){
            return;
        }

        int x1 = x-depth;
        int x2 = x+depth;
        int y1 = y-depth;
        int y2 = y+depth;

        //서 위로
        int firstValue = arr[y1][x1];

        for(int i=y1;i<y2;i++){
            arr[i][x1] = arr[i+1][x1];
        }

        //남 <--
        for(int j=x1;j<x2;j++){
            arr[y2][j] = arr[y2][j+1];
        }

        //동 아래로
        for(int i=y2;i>y1;i--){
            arr[i][x2] = arr[i-1][x2];
        }
        //북 -->
        for(int j=x2;j>x1+1;j--){
            arr[y1][j] = arr[y1][j-1];
        }

        arr[y1][x1+1]= firstValue;

    }

    public static void rotateArr(int y,int x,int depth){
        while(true){
            if(depth==0)
                break;
            rotate(y,x,depth);
            depth--;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isVisited = new boolean[k];

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateInfo = new int[k][3];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int depth = Integer.parseInt(st.nextToken());
            rotateInfo[i][0] = y;
            rotateInfo[i][1] = x;
            rotateInfo[i][2] = depth;
        }

        dfs(k);
        System.out.println(result);
    }
}
