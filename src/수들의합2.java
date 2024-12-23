import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr= new int[n];

        input = br.readLine();
        st = new StringTokenizer(input);

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int total=0;
        int left=0;
        int right=0;
        int answer =0;

        while(right<n) {
            total += arr[right++];
            if (total == m) {
                answer++;
            }
            while (total > m) {
                total -= arr[left++];
                if (total == m) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
