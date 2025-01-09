import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        while(left<right){
            int sum = arr[left]+arr[right];
            int abs = Math.abs(sum);
            if(min>abs){
                ansL = left;
                ansR = right;
                min = abs;
            }
            if(sum>=0)
                right--;
            else
                left++;
        }
        System.out.print(arr[ansL]+" "+arr[ansR]);
    }
}
