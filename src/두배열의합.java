import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 두배열의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr1[j];
                map1.put(sum,map1.getOrDefault(sum,0)+1);
            }
        }

        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=i;j<m;j++){
                sum+=arr2[j];
                map2.put(sum,map2.getOrDefault(sum,0)+1);
            }
        }

        long answer = 0;

        for(Integer k : map1.keySet()){
            int x = t-k;
            if(map2.containsKey(x)){
                answer+= (long) map1.get(k) *map2.get(x);
            }
        }
        System.out.print(answer);
    }
}
