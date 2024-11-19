import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_투포인터 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        int left = 0;
        int right = arr.length-1;

        while(left<right){

            int a = arr[left];
            a += arr[right];

            if(a==x)
                answer++;
            if(a<=x)
                left++;
            else
                right--;

        }
        System.out.println(answer);
    }
}
