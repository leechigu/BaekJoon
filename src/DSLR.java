import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {

    static boolean[] isVisited;
    static String bfs(int cur, int target){

        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{String.valueOf(cur),""});

        String answer ="";

        while(!queue.isEmpty()){

            String[] poll = queue.poll();
            String valStr = poll[0];
            int val = Integer.parseInt(valStr);
            String curStr = poll[1];

            if(val==target){
                answer = curStr;
                break;
            }

            isVisited[val] = true;

            //D
            int doubleVal = (val*2)%10000;
            if(!isVisited[doubleVal])
                queue.add(new String[]{String.valueOf(doubleVal),curStr+"D"});

            //S
            int minusOneVal = val==0?9999:val-1;
            if(!isVisited[minusOneVal])
                queue.add(new String[]{String.valueOf(minusOneVal),curStr+"S"});

            //L
            String lStr = valStr.substring(1);
            lStr= lStr + valStr.charAt(0);
            if(!isVisited[Integer.parseInt(lStr)])
                queue.add(new String[]{lStr,curStr+"L"});

            //R
            String RStr = valStr.substring(0,valStr.length()-1);
            RStr = valStr.charAt(valStr.length()-1) + RStr;
            if(!isVisited[Integer.parseInt(RStr)])
                queue.add(new String[]{RStr,curStr+"R"});

        }


        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-->0){
            isVisited = new boolean[10001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String answer = bfs(a, b);
            sb.append(answer).append("\n");

        }
        System.out.print(sb);
    }
}
