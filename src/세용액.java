import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        long min = Long.MAX_VALUE;
        String answer = "";

        while(true){
            if(right-left<1){
                break;
            }
            long sum = 0;

            if(Math.abs(arr[left])>Math.abs(arr[right])){
                for(int mid=left+1;mid<=right-1;mid++){
                    sum = arr[left] + arr[mid] + arr[right];
                    if(min>Math.abs(sum)) {
                        min = Math.abs(sum);
                        System.out.println(min);
                        answer = arr[left] + " " + arr[mid] + " " + arr[right];
                    }
                }
                left++;
            }else{
                for(int mid=left+1;mid<=right-1;mid++) {
                    sum = arr[left] + arr[mid] + arr[right];
                    if (min > Math.abs(sum)) {
                        min = Math.abs(sum);
                        answer = arr[left] + " " + arr[mid] + " " + arr[right];
                    }
                }
                right--;
            }
        }

        System.out.print(answer);

    }
}
