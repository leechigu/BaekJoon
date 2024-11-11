import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전쟁_탈출편2 {

    static int target;
    static ArrayList<int[]>[] lists;

    static void bfs(){

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{1,0});
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        target = n;
        int m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=1;i<=m;i++){

            input = br.readLine();
            st = new StringTokenizer(input);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


        }


    }
}
