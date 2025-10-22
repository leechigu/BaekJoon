import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 행렬제곱 {

    static long b;
    static int n;
    static long max;
    static HashMap<Long,int[][]> map = new HashMap<>();

    public static void calMax(){
        max = 1;
        while(max*2<=b){
            max*=2;
        }
    }

    public static void calArr(long seq, int[][] arr){
        map.put(seq,arr);
        if(seq == max){
            return;
        }
        int[][] nextArr = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cur=0;
                for(int k=0;k<n;k++){
                    cur+=arr[i][k] * arr[k][j];
                }
                nextArr[i][j] = cur % 1000;
            }
        }
        calArr(seq*2,nextArr);
    }

    public static void cal(){
        int[][] start = new int[n][n];
        for(int i=0;i<n;i++){
            start[i][i] = 1;
        }
        while(true){
            if(b==0){
                break;
            }
            if(b>=max){
                start = calculation(start,map.get(max));
                b-=max;
            }else{
                max/=2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(start[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int[][] calculation(int[][] arr1,int[][] arr2){
        int[][] nextArr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cur=0;
                for(int k=0;k<n;k++){
                    cur+=arr1[i][k] * arr2[k][j];
                }
                nextArr[i][j] = cur %1000;
            }
        }
        return nextArr;
    }





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calMax();
        calArr(1,arr);
        cal();

    }
}
