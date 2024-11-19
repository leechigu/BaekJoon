import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {

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
        for(int i=0;i<n-1;i++){
            int left = arr[i];
            for(int j=i+1;j<n;j++){
                int right = arr[j];
                int cur = left+right;
                if(cur == x ){
                    answer++;
                }
                if(cur>x)
                    break;
            }
        }
        System.out.println(answer);
    }
}
