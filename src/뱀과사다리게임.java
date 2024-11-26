import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀과사다리게임 {

    static ArrayList<Integer>[] ladders;
    static ArrayList<Integer>[] snakes;
    static boolean[] isVisited;

    int min = Integer.MAX_VALUE;

    static int bfs(){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        int answer = 0;

        while(!queue.isEmpty()) {

            int[] curData = queue.poll();
            int cur = curData[0];
            int seq = curData[1];

            if (cur == 100) {
                answer = seq;
                break;
            }

            isVisited[cur] = true;

            for(int i=1;i<=6;i++){

                int next = cur+i;
                if(next>100)
                    break;

                if(!ladders[next].isEmpty()){
                    for (int nextLadder : ladders[next]) {
                        if (isVisited[nextLadder])
                            continue;
                        queue.add(new int[]{nextLadder, seq + 1});
                    }
                }
                if(!snakes[next].isEmpty()){
                    for (int nextSnake : snakes[next]) {
                        if (isVisited[nextSnake])
                            continue;
                        queue.add(new int[]{nextSnake, seq + 1});
                    }
                }

                if(ladders[next].isEmpty()&&snakes[next].isEmpty()){
                    if(!isVisited[next])
                        queue.add(new int[]{next,seq+1});
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ladders = new ArrayList[101];
        snakes = new ArrayList[101];
        isVisited = new boolean[101];

        for(int i=0;i<=100;i++) {
            ladders[i] = new ArrayList<>();
            snakes[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladders[a].add(b);
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snakes[a].add(b);
        }

        System.out.println(bfs());

    }
}
