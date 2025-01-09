import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해_dfs_timeout {


    static int[] arr;
    static int n;
    static int k;
    static int answer = 0;


    static void dfs(int sum,int depth){

        if(depth==k){
            //System.out.println(sum);
            if(sum==n) {
                answer++;
                answer%=1000000000;
            }
            return;
        }

        for(int i=0;i<arr.length;i++){
            dfs(sum+i,depth+1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr= new int[n+1];

        dfs(0,0);

        System.out.println(answer);

    }
}
