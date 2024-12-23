import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 과일탕후루_실패 {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);

        int[] arr = new int[n];



        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max =-1;


        for(int i=1;i<n;i++){
            int[] cnt = new int[10];
            Deque<Integer> deque = new ArrayDeque<>();
            for(int j=0;j<=i;j++){
                deque.addLast(arr[j]);
                cnt[arr[j]]++;
            }

            int x = 0;
            int total = 0;
            for(int j=0;j<10;j++) {
                if (cnt[j] > 0) {
                    x++;
                    total += cnt[j];
                }
            }

            /*for(int temp : deque){
                System.out.print(temp +" ");
            }
            System.out.println();*/

            if(x<=2) {
                max = Math.max(total, max);
            }

            for(int j=i+1;j<n;j++){
                cnt[deque.removeFirst()]--;
                deque.addLast(arr[j]);
                cnt[arr[j]]++;
                x=0;
                total=0;
                for(int k=0;k<10;k++) {
                    if (cnt[k] > 0) {
                        x++;
                        total += cnt[k];
                    }
                }
                if(x<=2){
                    max = Math.max(total,max);
                }
            }
        }
        System.out.println(max);
    }
}
