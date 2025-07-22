import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {

    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        String answer = "";

        for(int i=0;i<n-1;i++){
            int a = i;
            int left = i+1;
            int right = n-1;
            while(left<right){
                long sum = arr[a] + arr[left] + arr[right];
                if(Math.abs(sum)<min){
                    min = Math.abs(sum);
                    answer = arr[a] +" "+ arr[left]+ " " + arr[right];
                }
                if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        System.out.print(answer);
    }
}
