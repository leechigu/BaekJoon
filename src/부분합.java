import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left=0;
        int right= -1;
        int sum=0;
        int len = 0;
        int minLen = Integer.MAX_VALUE;
        while(true){
            if(sum<s){
                if(right==n-1)
                    break;
                right++;
                sum+=arr[right];
                len++;
            }else{
                minLen = Math.min(minLen,len);
                sum-=arr[left];
                left++;
                len--;
            }
        }
        if(minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.print(minLen);
        }

    }
}
