import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 랜선자르기 {

    static long[] arr;
    static long n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int k = Integer.parseInt(st.nextToken());
        n = Long.parseLong(st.nextToken());

        //1 ~ min 값 까지

        arr = new long[k];
        for(int i=0;i<k;i++)
            arr[i] = Long.parseLong(br.readLine());

        Arrays.sort(arr);
        long max = arr[arr.length-1];
        long min = 1;
        long mid = (min + max) / 2;


        while(min<=max){
            //System.out.println(min + " " + mid + " " + max);
            if(check(mid)>=n){
                min = mid+1;
                mid = (min + max) / 2;
            } else {
                max = mid-1;
                mid = (min + max) / 2 ;
            }
        }
        System.out.print(mid);
    }

    static long check(long mid){
        long cnt = 0;
        for(long val : arr) {
            cnt += val / mid;
            if(cnt>=n)
                return cnt;
        }
        return cnt;
    }

}
