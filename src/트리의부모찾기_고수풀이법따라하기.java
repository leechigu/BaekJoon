import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class 트리의부모찾기_고수풀이법따라하기 {



    public static void main(String[] args) throws IOException {

        int N,parent[];
        boolean[] visit;
        ArrayList<Integer>[] list;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        list = new ArrayList[N+1];
        parent = new int[N+1];
        visit = new boolean[N+1];

        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<N-1;i++){
            input = br.readLine();
            String[] splitStr = input.split(" ");
            int a = Integer.parseInt(splitStr[0]);
            int b = Integer.parseInt(splitStr[1]);
            list[a].add(b);
            list[b].add(a);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visit[1] = true;
        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int nextNode : list[curNode]){
                if(!visit[nextNode]){
                    visit[nextNode] = true;
                    parent[nextNode] = curNode;
                    q.add(nextNode);
                }
            }
        }

        /*for(int i=2;i<parent.length;i++)
            System.out.println(parent[i]);*/
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<parent.length;i++)
            sb.append(parent[i]).append('\n');

        System.out.println(sb);
    }
}
