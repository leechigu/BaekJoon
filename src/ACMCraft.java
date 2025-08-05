import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ACMCraft {

    public static int n;
    public static int k;
    public static ArrayList<Integer>[] lists;
    public static int[] bldgs;
    public static int[] min;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            bldgs = new int[n];
            for(int i=0 ;i<n;i++){
                bldgs[i]  = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<k;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                lists[a].add(b);
            }

            int target = Integer.parseInt(br.readLine());

        }

    }
}
