import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 할로윈의양아치 {


    static int n;
    static int k;
    static int[] arr;
    static int[] parent;
    static int[] childCnt;
    static int[] value;
    static List<int[]> list = new ArrayList<>();

    static int findRoot(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findRoot(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (childCnt[rootA] > childCnt[rootB]) {
            parent[rootB] = rootA;
            childCnt[rootA] += childCnt[rootB];
            value[rootA] += value[rootB];
        } else {
            parent[rootA] = rootB;
            childCnt[rootB] += childCnt[rootA];
            value[rootB] += value[rootA];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        childCnt = new int[n + 1];
        value = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            childCnt[i] = 1;
            value[i] = arr[i];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findRoot(a) != findRoot(b)) {
                union(a, b);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (findRoot(i) == i) {
                list.add(new int[]{childCnt[i], value[i]});
            }
        }

        k-=1;
        int[][] dp = new int[list.size()+1][k+1];

        for(int i=1;i<=list.size();i++){
            for(int j=1;j<=k;j++){
                int a = dp[i-1][j];
                int b = 0;
                int[] temp = list.get(i-1);
                if(j-temp[0]>=0){
                    b = dp[i-1][j-temp[0]]+temp[1];
                }
                dp[i][j] = Math.max(a,b);
            }
        }

        System.out.print(dp[list.size()][k]);

    }
}