import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이중우선순위큐 {

    static Map<Integer,Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            int k = Integer.parseInt(br.readLine());

            for(int i=0;i<k;i++){

                st  = new StringTokenizer(br.readLine());
                String operationType = st.nextToken();
                int operationValue = Integer.parseInt(st.nextToken());

                if("D".equals(operationType)){
                    if(map.isEmpty())
                        continue;
                    if(operationValue==1){
                        delete(queue2);
                    }else if(operationValue==-1){
                        delete(queue);
                    }
                }else if("I".equals(operationType)){
                    queue.add(operationValue);
                    queue2.add(operationValue);
                    map.put(operationValue,map.getOrDefault(operationValue,0)+1);
                }
            }
            if(map.isEmpty())
                sb.append("EMPTY").append("\n");
            else{
                int max = delete(queue2);
                int min = max;
                if(!map.isEmpty()){
                    min = delete(queue);
                }
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.print(sb);
    }


    static public int delete(Queue<Integer> queue){

        int deletedVal;
        while(true){
            deletedVal = queue.poll();
            int cnt = map.getOrDefault(deletedVal,0);
            if (cnt == 0) {
                continue;

            }else if(cnt == 1){
                map.remove(deletedVal);
            }else{
                map.put(deletedVal,cnt-1);
            }
            break;
        }
        return deletedVal;
    }
}
