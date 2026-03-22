import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레드블루스패닝트리 {

    static int[] parents;
    static int n;

    static void union(int a,int b){

        int rootA = findRoot(a);
        int rootB = findRoot(b);

        int minRoot = Math.min(rootA,rootB);
        int maxRoot = Math.max(rootA,rootB);

        parents[minRoot] = maxRoot;
    }

    static int findRoot(int a){
        if(parents[a]==a){
            return a;
        }
        return parents[a] = findRoot(parents[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String start = br.readLine();
            if("0 0 0".equals(start))
                break;
            StringTokenizer st = new StringTokenizer(start);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Queue<int[]> pq1 = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            Queue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                char color = st.nextToken().charAt(0);
                int f = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken())-1;

                int val = color=='B'?1:0;
                int val2 = color=='B'?0:1;

                pq1.add(new int[]{val,f,t});
                pq2.add(new int[]{val2,f,t});
            }

            //red인 경우부터 채운다 -> blue 최소의 수
            int minBlue = 0;
            parents = new int[n];

            for(int i=0;i<n;i++){
                parents[i] = i;
            }

            while(!pq1.isEmpty()){

                int[] poll = pq1.poll();

                int val = poll[0];
                int a = poll[1];
                int b = poll[2];

                if(findRoot(a)!=findRoot(b)){
                    if(val==1)
                        minBlue++;
                    union(a,b);
                }
            }
            //blue인 경우부터 채운다 -> blue 최대 의 수
            int maxBlue = 0;
            for(int i=0;i<n;i++){
                parents[i] = i;
            }
            while(!pq2.isEmpty()){
                int[] poll = pq2.poll();

                int val = poll[0];
                int a = poll[1];
                int b = poll[2];

                if(findRoot(a)!=findRoot(b)){
                    if(val==0)
                        maxBlue++;
                    union(a,b);
                }
            }

            //System.out.println("k ="+k);
            //System.out.println("min = " + minBlue + " max = " + maxBlue);
            if(maxBlue>=k&&minBlue<=k){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
