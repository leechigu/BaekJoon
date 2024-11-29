import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        input = br.readLine();
        st = new StringTokenizer(input);

        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int total = 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int len = 0;


        while(right<n){
            total+=arr[right++];
            len++;
            if(len==k)
                max = Math.max(max,total);

            while(len==k){
                total-=arr[left++];
                len--;
                if(len==k)
                    max = Math.max(max,total);
            }
        }
        System.out.println(max);
    }
}
