import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값과최댓값 {

    static int n;
    static int size;
    static int[][] node;
    static StringBuilder sb = new StringBuilder();

    public static int[] init(int indx){
        if(indx>=size){
            return node[indx];
        }
        int[] left = init(indx*2);
        int[] right = init(indx*2+1);
        node[indx][0] = Math.max(left[0],right[0]);
        node[indx][1] = Math.min(left[1],right[1]);

        return node[indx];
    }

    public static void search(int st, int ed){
        st+=size-1;
        ed+=size-1;
        int[] answer = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};

        long sum = 0;
        while(true){
            if(st%2==1){
                answer[0] = Math.max(answer[0],node[st][0]);
                answer[1] = Math.min(answer[1],node[st][1]);
                st++;
            }
            if(ed%2==0){
                answer[0] = Math.max(answer[0],node[ed][0]);
                answer[1] = Math.min(answer[1],node[ed][1]);
                ed--;
            }
            if(st>ed){
                break;
            }
            st/=2;
            ed/=2;
        }
        sb.append(answer[1]).append(" ").append(answer[0]).append("\n");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        size = 1;
        while(size<n){
            size*=2;
        }

        node  = new int[size*2][2];

        for(int i=0;i<node.length;i++){
            node[i][0] = Integer.MIN_VALUE;
            node[i][1] = Integer.MAX_VALUE;
        }

        for(int i=0;i<n;i++){
            node[i+size][0] = Integer.parseInt(br.readLine());
            node[i+size][1] = node[i+size][0];
        }

        init(1);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            search(b,c);
        }
        System.out.print(sb.toString());
    }
}
