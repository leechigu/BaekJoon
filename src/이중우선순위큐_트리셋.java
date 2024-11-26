import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 이중우선순위큐_트리셋 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            TreeSet<Integer> treeSet = new TreeSet<>();
            int k = Integer.parseInt(br.readLine());

            for(int i=0;i<k;i++){
                st  = new StringTokenizer(br.readLine());

                String operationType = st.nextToken();
                int operationValue = Integer.parseInt(st.nextToken());

                if("D".equals(operationType)){
                    if(treeSet.isEmpty())
                        continue;
                    if(operationValue==1){
                        Integer max = treeSet.pollLast();
                    }else if(operationValue==-1){
                        Integer min = treeSet.pollFirst();
                    }
                }else if("I".equals(operationType)){
                    treeSet.add(operationValue);
                }
            }
            if(treeSet.isEmpty())
                sb.append("EMPTY").append("\n");
            else{
                int max = treeSet.pollLast();
                int min = max;
                if(!treeSet.isEmpty()){
                    min = treeSet.pollFirst();
                }
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.print(sb);
    }
}
