import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리순회 {
    static Map<Integer, int[]> map;
    static StringBuilder sb;
    public static void bfs_stack(){
        Stack<Integer> q = new Stack<>();
        q.add(0);
        int beforeNum = 0;
        while(!q.isEmpty()){
            int cur = q.pop();
            char a = (char) (cur+'A');
            sb.append(a);
            int[] childs = map.get(cur);
            int left = childs[0];
            int right = childs[1];
            if(right==-1) {
            }
            else{
                q.add(right);
            }
            if(left==-1) {
            }
            else{
                q.add(left);
            }
        }
        sb.append("\n");
    }

    public static void recursive1(int n ,Stack<Integer> stack){
        int[] child = map.get(n);

        int left = child[0];
        int right = child[1];

        if(right!=-1){
            recursive1(right,stack);
        }
        stack.add(n);
        if(left!=-1){
            recursive1(left,stack);
        }
    }

    public static void recursive2(int n){
        int[] child = map.get(n);
        int left = child[0];
        int right = child[1];

        if(left!=-1){
            recursive2(left);
        }
        if(right!=-1){
            recursive2(right);
        }
        sb.append((char)(n+'A'));
    }


    public static void main(String[] args) throws IOException {

        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n  = Integer.parseInt(input);
        map = new HashMap<Integer, int[]>();

        for(int i=0;i<n;i++){
            input  = br.readLine();
            String[] splitStr = input.split(" ");
            int a = splitStr[0].charAt(0)-'A';
            int b = splitStr[1].equals(".")?-1:splitStr[1].charAt(0)-'A';
            int c = splitStr[2].equals(".")?-1:splitStr[2].charAt(0)-'A';

            map.put(a,new int[]{b,c});
        }

        bfs_stack();
        Stack<Integer> stack =new Stack<>();
        recursive1(0,stack);

        while(!stack.isEmpty()) {
            sb.append((char)(stack.pop()+'A'));
        }
        sb.append("\n");

        recursive2(0);
        sb.append("\n");
        System.out.println(sb);



    }
}
