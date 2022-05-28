import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }
        Arrays.sort(arr);

        int cnt = 1;
        int curNum = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]==curNum)
                cnt++;
            else{
                hashMap.put(curNum,cnt);
                curNum = arr[i];
                cnt=1;
            }
        }

        hashMap.put(arr[n-1],cnt);


        /*for(int i=0;i<n;i++){
            String num = st.nextToken();
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }
            else{
                hashMap.put(num,1);
            }
        }*/

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<m;i++){
            int t = Integer.parseInt(st.nextToken());
            stringBuilder.append(hashMap.getOrDefault(t,0)).append(' ');
        }

        System.out.println(stringBuilder);
    }
}
