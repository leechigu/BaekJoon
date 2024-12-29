import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<int[]> stack = new Stack<>();
        StringBuilder sb= new StringBuilder();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            int a = arr[i];
            if(stack.isEmpty())
                stack.add(new int[]{a,i});
            else{
                while(true){
                    if(stack.isEmpty()) {
                        stack.add(new int[]{a,i});
                        break;
                    }
                    int[] peek = stack.peek();
                    int val = peek[0];
                    int indx = peek[1];
                    if(val<a){
                        stack.pop();
                        ans[indx] = a;
                    }else{
                        stack.add(new int[]{a,i});
                        break;
                    }
                }
            }
        }
        for(int a : ans)
            sb.append(a).append(" ");
        System.out.print(sb);
    }
}
