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
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 1;
        int answer = 0;

        int cur = 0;

        Arrays.sort(arr);

        while(right<n)
        {
            if(cur<=x)
                cur=arr[right++]+arr[left];

            if(cur==x){
                answer++;
            }
            System.out.println(cur);

            while(cur<=x){

                cur=arr[left++]+arr[right];
                System.out.println(cur);
                if(cur==x){
                    answer++;
                }

                if(left==right)
                    break;

            }
            if(left==right)
                break;
        }
        System.out.println(answer);
    }
}
