import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 평범한배낭_fail {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");
        int n = Integer.parseInt(splitStr[0]);
        int k = Integer.parseInt(splitStr[1]);

        int[] dp = new int[k+1];

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            splitStr = br.readLine().split(" ");
            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int weight = arr[i][0];
            int val = arr[i][1];

            if(map.containsKey(weight)){
                List<Integer> list = map.get(weight);
                list.add(val);
                map.put(weight,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(weight,list);
            }
        }
        List<Integer> keyList = new ArrayList<>();
        for(int mapKey : map.keySet()){
            keyList.add(mapKey);
        }

        boolean[] isUsed = new boolean[k];

        for(int i=1;i<=k;i++){
            int max = 0;
            int maxKey = -1;
            for(int key:keyList){
                if(i-key<0) {

                }
                else if(i-key>0 && dp[i-key]==0){

                }
                else{
                    if(!isUsed[key]&&!isUsed[i-key]&&max<dp[i-key]+dp[key]){
                        isUsed[i-key] = true;
                        System.out.println("hello1 Key"+key);
                        max = dp[i-key]+dp[key];
                        maxKey = -1;
                    }
                    if(map.containsKey(key)) {
                        System.out.println("hello2 Key"+key);
                        List<Integer> list = map.get(key);
                        if (max < dp[i - key] + list.get(0)) {
                            max = dp[i - key] + list.get(0);
                            maxKey = key;
                        }
                    }
                }
            }

            System.out.println(maxKey);

            dp[i] = max;
            if(maxKey==-1)
                continue;

            List<Integer> list = map.get(maxKey);
            Integer remove = list.remove(0);
            System.out.println(maxKey + " remove " +remove);
            if(list.isEmpty()){
                map.remove(maxKey);
            }else{
                map.put(maxKey,list);
            }
        }


        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);

    }
}
