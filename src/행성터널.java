import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 행성터널 {

    static List<int[]> lists = new ArrayList<>();
    static int n;
    static int[] parents;
    static int[] childCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arrX = new int[n][2];
        int[][] arrY = new int[n][2];
        int[][] arrZ = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arrX[i][0] = i;
            arrX[i][1] = Integer.parseInt(st.nextToken());
            arrY[i][0] = i;
            arrY[i][1] = Integer.parseInt(st.nextToken());
            arrZ[i][0] = i;
            arrZ[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrX, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Arrays.sort(arrY, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Arrays.sort(arrZ, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        setLists(arrX);
        setLists(arrY);
        setLists(arrZ);

        parents = new int[n];
        childCnt = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
            childCnt[i] = 1;
        }


        lists.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        long answer = 0;
        for (int[] info : lists) {

            int a = info[0];
            int b = info[1];
            int val = info[2];

            if (findRoot(a) != findRoot(b)) {
                union(a, b);
                answer += val;
            }
        }

        System.out.print(answer);

    }

    static int findRoot(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = findRoot(parents[a]);
    }

    static void union(int a,int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(childCnt[rootA]>childCnt[rootB]){
            parents[rootB] = rootA;
            childCnt[rootA] += childCnt[rootB];
        }else{
            parents[rootA] = rootB;
            childCnt[rootB] += childCnt[rootA];
        }
    }

    static void setLists(int[][] arr){
        for(int i=0;i<n-1;i++){
            int a = arr[i][0];
            int b = arr[i+1][0];
            int val = Math.abs(arr[i][1] - arr[i+1][1]);
            lists.add(new int[]{a,b,val});
        }
    }

}
