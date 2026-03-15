import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 별자리만들기 {

    static int[] parent;
    static int n;

    public static double calDistanceUseArr(double[] arr1, double[] arr2){
        return calDistance(arr1[0],arr1[1],arr2[0],arr2[1]);
    }
    public static double calDistance(double x1,double y1,double x2,double y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

    public static void union(int a,int b){

        int rootA = findRoot(a);
        int rootB = findRoot(b);

        int minRoot = Math.min(rootA,rootB);
        int maxRoot = Math.max(rootA,rootB);

        parent[maxRoot] = minRoot;

    }

    public static int findRoot(int i){
        if(i==parent[i])
            return i;
        return parent[i] = findRoot(parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n  = Integer.parseInt(st.nextToken());
        double[][] posArr = new double[n][2];
        parent  = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            posArr[i][0] = Double.parseDouble(st.nextToken());
            posArr[i][1] = Double.parseDouble(st.nextToken());
        }

        Queue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[2],o2[2]);
            }
        });


        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                queue.add(new double[]{i, j, calDistanceUseArr(posArr[i], posArr[j])});
            }
        }

        double answer = 0;

        while(!queue.isEmpty()){
            double[] cur = queue.poll();
            int a = (int)cur[0];
            int b = (int)cur[1];
            double distance = cur[2];

            if(findRoot(a)!=findRoot(b)){
                union(a,b);
                answer+=distance;
            }
        }

        System.out.println(answer);

    }
}
