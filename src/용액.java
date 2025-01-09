import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //산성 양수
        //알칼리 음수
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //투포인터
        int left = 0;
        int right = n-1;
        int cur = Math.abs(arr[left]+arr[right]);
        int min = cur;

        int ansL = left;
        int ansR = right;

        while(left<right){
            int sum = arr[left]+arr[right];
            int abs = Math.abs(sum);
            if(abs<=min){
                ansL = left;
                ansR = right;
                min = abs;
            }
            if(sum>=0){
                right--;
            }else{
                left++;
            }
        }
        System.out.println(arr[ansL] + " "+ arr[ansR]);

    }
}
