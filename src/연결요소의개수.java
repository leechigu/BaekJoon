import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] splitStr = input.split(" ");

        int n = Integer.parseInt(splitStr[0]);
        int m = Integer.parseInt(splitStr[1]);

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=0;i<m;i++){
            input = br.readLine();
            splitStr = input.split(" ");

            int u = Integer.parseInt(splitStr[0]);
            int v = Integer.parseInt(splitStr[1]);

            if(map.containsKey(u)){
                Set<Integer> tempSet = map.get(u);
                tempSet.add(v);
                map.put(u,tempSet);
            }else{
                Set<Integer> tempSet =new HashSet<>();
                tempSet.add(v);
                map.put(u,tempSet);
            }

            if(map.containsKey(v)){
                Set<Integer> tempSet = map.get(v);
                tempSet.add(u);
                map.put(v,tempSet);
            }else{
                Set<Integer> tempSet =new HashSet<>();
                tempSet.add(u);
                map.put(v,tempSet);
            }
        }

        boolean[] isVisited = new boolean[n+1];

        int answer=0;
        for(int i=1;i<=n;i++){
            if(isVisited[i])
                continue;

            answer++;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while(!queue.isEmpty()){
                int x = queue.poll();
                if(map.containsKey(x)){
                    for(int c : map.get(x)){
                        if(!isVisited[c]){
                            isVisited[c] = true;
                            queue.add(c);
                        }
                    }
                }
            }
        }

        System.out.println(answer);


    }
}
