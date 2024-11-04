import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기 {

    static Map<Integer, List<Integer>> map;

    public static void dfs(int[] arr, boolean[] isVisited,int cur){
        List<Integer> list;

        if(map.containsKey(cur))
            list = map.get(cur);
        else{
            return;
        }

        for(int i : list) {
            arr[i] = cur;
        }

        for(int i : list){
            if(!isVisited[i]) {
                isVisited[i] = true;
                dfs(arr, isVisited, i);
            }
        }
        for(int i : list) {
            arr[i] = cur;
        }


    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        int[][] arr = new int[n][2];

        map = new HashMap<>();

        for(int i=0;i<n-1;i++){
            input = br.readLine();
            String[] splitStr = input.split(" ");
            int x = Integer.parseInt(splitStr[0]);
            int y = Integer.parseInt(splitStr[1]);

            if(map.containsKey(x)){
                List<Integer> list = map.get(x);
                list.add(y);
                map.put(x,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(y);
                map.put(x,list);
            }

            if(map.containsKey(y)){
                List<Integer> list = map.get(y);
                list.add(x);
                map.put(y,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(x);
                map.put(y,list);
            }
        }



        int[] answer = new int[n+1];
        boolean[] isVisited = new boolean[n+1];
        dfs(answer,isVisited,1);


        for(int i=2;i<n+1;i++){
            System.out.println(answer[i]);
        }

    }
}
