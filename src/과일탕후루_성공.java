import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 과일탕후루_성공 {

    static int n;
    static int[] arr,cur;

    static int count(int[] cur){
        int cnt = 0;
        for(int i:cur){
            if(i==0){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        n = Integer.parseInt(st.nextToken());
        int max =-1;
        input = br.readLine();
        st = new StringTokenizer(input);

        arr = new int[n];
        cur = new int[10];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int left=0;
        int right=0;
        while(right<n){
            cur[arr[right++]]++;
            while(10-count(cur)>2){
                cur[arr[left++]]--;
            }
            max = Math.max(max,right-left);
        }

        System.out.println(max);
    }
}
