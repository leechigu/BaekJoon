import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나머지_합 {

    public static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] restList = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken())%m;
        }

        restList[0] = arr[0];
        if(map.containsKey(restList[0])){
            map.get(restList[0]).add(0);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(0);
            map.put(restList[0],list);
        }

        for(int i=1;i<n;i++){
            restList[i] = (restList[i-1]+arr[i])%m;
            if(map.containsKey(restList[i])){
                map.get(restList[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(restList[i],list);
            }
        }
        long answer = 0;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            if(key==0){
                answer+=list.size();
            }
            answer+=((long) list.size() *(long)(list.size()-1))/2;
        }

        System.out.println(answer);
    }
}
