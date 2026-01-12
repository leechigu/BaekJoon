import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 개미굴 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    static class Node{
        String val;
        Node(String cur){
            this.val = cur;
        }
        Map<String, Node> childMap = new TreeMap<>();
    }


    static void dfs(Node cur,int depth){
        String head = "";
        for(int i=0;i<depth;i++){
            head = head + "--";
        }
        sb.append(head).append(cur.val).append("\n");

        if(!cur.childMap.isEmpty()) {
            for (String next : cur.childMap.keySet()) {
                dfs(cur.childMap.get(next), depth + 1);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        Node root = new Node("");

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            Node cur = root;

            for(int j=0;j<m;j++){
                String curStr = st.nextToken();
                if(!cur.childMap.containsKey(curStr)){
                    Node node = new Node(curStr);
                    cur.childMap.put(curStr,node);
                }
                cur = cur.childMap.get(curStr);
            }
        }

        for(String start : root.childMap.keySet()){
            dfs(root.childMap.get(start),0);
        }

        System.out.print(sb.toString());

    }
}
