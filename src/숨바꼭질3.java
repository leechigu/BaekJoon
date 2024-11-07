import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질3 {

    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int k = Integer.parseInt(splitStr[1]);

        Arrays.fill(arr, 100001);

        for(int i=0;i<=n;i++)
            arr[i] = n-i;

        for(int i=n+1;i<arr.length;i++){
            if((i &1)==1)
                arr[i] = Math.min(Math.min(arr[i-1]+1,arr[(i+1)/2]+1),arr[(i-1)/2]+1);
            else
                arr[i] = Math.min(arr[i-1]+1,arr[i/2]);
        }

        System.out.println(arr[k]);

    }
}
