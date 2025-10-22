import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Σ {

    static long b;
    static int n;
    static int mod = 1000000007;
    static Map<Integer,Long> map;
    static int max;

    public static void makeMap(int seq, long a){

        map.put(seq,a);
        if(seq==max)
            return;
        long next = (a*a) % mod;
        makeMap(seq*2,next);
    }

    public static long findReverse(){

        int target = mod-2;
        int tempMax = max;
        long val =1;
        while(true){

            if(target == 0)
                break;

            if(target>=tempMax){
                val *= map.get(tempMax);
                target -= tempMax;
                val %= mod;
            }else{
                tempMax/=2;
            }
        }
        return val;
    }

    public static long cal(int a, int b){
        map = new HashMap<>();
        makeMap(1,a);
        long temp = findReverse();
        temp *= b;
        temp %= mod;
        return temp;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        long answer = 0;
        max = 1;
        while(max*2<=mod){
            max*=2;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer += cal(a,b);
            answer %= mod;
        }

        System.out.print(answer);

    }
}
