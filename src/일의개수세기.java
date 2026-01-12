import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 일의개수세기 {

    public static long cal(char[] arr){
        int cnt = 0;
        int len = arr.length;
        for(int i=0;i<len;i++){
            if('1'==arr[i]){
                cnt++;
            }
        }

        long total = 0;
        long s = 2;

        if(arr[0]=='1'){
            total+=cnt;
            arr[0]='0';
            cnt--;
        }
        for(int i=1;i<len;i++){
            if(arr[i]=='1'){
                total+=cnt;
                arr[i]= '0';
                cnt--;
                total += i*s/2 + s*cnt;
            }
            s*=2;
        }
        return total;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger tempA  = new BigInteger(st.nextToken());
        BigInteger tempB  = new BigInteger(st.nextToken());
        String binary = tempA.toString(2);
        binary = new StringBuilder(binary).reverse().toString();
        char[] arr = binary.toCharArray();

        long A = cal(arr);

        binary = tempB.toString(2);
        binary = new StringBuilder(binary).reverse().toString();
        arr = binary.toCharArray();

        long B = cal(arr);

        System.out.print(B-A);

    }
}
