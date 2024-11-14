import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(t-->0){

            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tempArr = br.readLine();
            tempArr = tempArr.substring(1,tempArr.length()-1);
            String[] splitStr = tempArr.split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            if(!splitStr[0].equals(""))
                for(int i=0;i<splitStr.length;i++)
                    deque.add(Integer.parseInt(splitStr[i]));

            boolean isReverse = false;
            boolean isError = false;
            for(int i=0;i<function.length();i++){
                char cur = function.charAt(i);
                if(cur == 'R'){
                    isReverse = !isReverse;
                }
                else if(cur == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if(!isReverse)
                        deque.removeFirst();
                    else
                        deque.removeLast();

                }
            }
            if(isError)
                continue;

            sb.append("[");
            int cnt = deque.size();
            if(!isReverse){
                for(int i=0;i<cnt;i++){
                    sb.append(deque.removeFirst());
                    if(i!=cnt-1)
                        sb.append(",");
                }
            }
            else{
                for(int i=0;i<cnt;i++){
                    sb.append(deque.removeLast());
                    if(i!=cnt-1)
                        sb.append(",");
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
    }
}
