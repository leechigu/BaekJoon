import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 사이클게임_union {

    static int n;
    static int m;

    static int[] arr;

    public static int findRoot(int a){
        if(a==arr[a])
            return a;
        return arr[a] = findRoot(arr[a]);
    }

    public static void union(int a, int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if(rootA<rootB){
            arr[rootB] = rootA;
        }else{
            arr[rootA] = rootB;
        }
        arr[b] = findRoot(a);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        int answer = 0;

        int[][] map = new int[m][2];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
        }

        for(int i=0;i<m;i++){

            int a = map[i][0];
            int b = map[i][1];

            if(findRoot(a)==findRoot(b)){
                answer = i+1;
                break;
            }else{
                union(a,b);
            }
        }
        System.out.println(answer);
    }
}
